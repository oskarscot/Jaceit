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
        Request request = createGetRequest(url);

        logger.info("Making GET request to {}", url);

        this.httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                handleFailure(e, callback);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                handleResponse(response, responseType, callback);
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

    private Request createGetRequest(String url) {
        return new Request.Builder()
                .url(url)
                .get()
                .build();
    }

    private <T> void handleResponse(@NotNull Response response, Class<T> responseType, ApiCallback<T> callback) {
        try (ResponseBody responseBody = response.body()) {
            if (responseBody == null) {
                logger.warn("API returned an empty response for {}", response.request().url());
                callback.onFailure(new ApiException("API returned an empty response"));
                return;
            }

            String responseBodyString = responseBody.string();
            if (response.isSuccessful()) {
                try {
                    T result = objectMapper.readValue(responseBodyString, responseType);
                    callback.onSuccess(result);
                } catch (JsonProcessingException e) {
                    logger.error("Failed to parse JSON response", e);
                    callback.onFailure(new ApiException("Failed to parse response", e));
                }
            } else {
                handleError(response, responseBodyString, callback);
            }
        } catch (IOException e) {
            logger.error("Failed to read response body", e);
            callback.onFailure(new ApiException("Failed to read response body", e));
        }
    }

    private <T> void handleError(@NotNull Response response, String responseBodyString, ApiCallback<T> callback) {
        try {
            ApiErrorResponse errorResponse = objectMapper.readValue(responseBodyString, ApiErrorResponse.class);
            List<ApiErrorResponse.ErrorDetail> errors = errorResponse.getErrors();
            logger.error("API request failed: {} ({})", errors, response.code());
            callback.onFailure(new ApiException("API request failed: %s (%d)".formatted(errors, response.code()), response.code()));
        } catch (JsonProcessingException e) {
            logger.error("Failed to parse error response", e);
            callback.onFailure(new ApiException("Failed to parse error response", e));
        }
    }

    private void handleFailure(IOException e, ApiCallback<?> callback) {
        logger.error("Request failed", e);
        callback.onFailure(new ApiException("An error occurred while making the request", e));
    }
}