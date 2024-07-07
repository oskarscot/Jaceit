package scot.oskar.jaceit.internal.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scot.oskar.jaceit.api.entity.ApiErrorResponse;
import scot.oskar.jaceit.api.request.ApiCallback;
import scot.oskar.jaceit.api.request.ApiClient;
import scot.oskar.jaceit.api.exception.ApiException;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ApiClientImpl implements ApiClient {

    private final Logger logger = LoggerFactory.getLogger("RequestLogger");
    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;

    public ApiClientImpl(OkHttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public <T> void getWithCallback(String url, Class<T> responseType, ApiCallback<T> callback) {
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        this.logger.info("Making GET request to {}", url);

        this.httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                callback.onFailure(new ApiException("An error occurred while making the request", e));
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String responseBody = response.body().string();
                if (response.isSuccessful()) {
                    if (responseBody.isEmpty()) {
                        logger.warn("API returned an empty response for {}", url);
                        callback.onFailure(new ApiException("API returned an empty response"));
                        return;
                    }
                    try {
                        final T result = objectMapper.readValue(responseBody, responseType);
                        callback.onSuccess(result);
                    } catch (JsonProcessingException e) {
                        logger.error("Failed to parse json response", e);
                        callback.onFailure(new ApiException("Failed to parse response", e));
                    }
                } else {
                    final ApiErrorResponse errorResponse = objectMapper.readValue(responseBody, ApiErrorResponse.class);
                    final List<ApiErrorResponse.ErrorDetail> errors = errorResponse.getErrors();
                    logger.error("API request failed: {} ({})", errors, response.code());
                    callback.onFailure(new ApiException("API request failed: %s (%d)".formatted(errors, response.code()), response.code()));
                }
            }
        });
    }

    @Override
    public <T> CompletableFuture<T> get(String url, Class<T> responseType) {
        CompletableFuture<T> future = new CompletableFuture<>();
        getWithCallback(url, responseType, new ApiCallback<>() {
            @Override
            public void onSuccess(T result) {
                future.complete(result);
            }

            @Override
            public void onFailure(ApiException exception) {
                future.completeExceptionally(exception);
            }
        });
        return future;
    }

}
