package scot.oskar.jaceit.internal.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import scot.oskar.jaceit.api.request.ApiClient;
import scot.oskar.jaceit.internal.exception.ApiException;
import scot.oskar.jaceit.internal.web.model.ApiErrorResponse;

import java.io.IOException;
import java.util.List;

public class ApiClientImpl implements ApiClient {

    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;

    public ApiClientImpl(OkHttpClient httpClient, ObjectMapper objectMapper) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
    }

    /**
     * Make a GET request to the Faceit API. The response will be parsed into the given type.
     *
     * @param url the url to call
     * @param responseType the type to parse the response into
     * @param callback the callback to call when the request is complete
     * @param <T> the type to parse the response into
     */
    public <T> void getAsync(String url, Class<T> responseType, ApiCallback<T> callback) {
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                callback.onFailure(new ApiException("An error occurred while making the request", e));
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String responseBody = response.body().string();
                if (response.isSuccessful()) {
                    if (responseBody.isEmpty()) {
                        callback.onFailure(new ApiException("API returned an empty response"));
                        return;
                    }
                    try {
                        final T result = objectMapper.readValue(responseBody, responseType);
                        callback.onSuccess(result);
                    } catch (JsonProcessingException e) {
                        callback.onFailure(new ApiException("Failed to parse response", e));
                    }
                } else {
                    final ApiErrorResponse errorResponse = objectMapper.readValue(responseBody, ApiErrorResponse.class);
                    final List<ApiErrorResponse.ErrorDetail> errors = errorResponse.getErrors();
                    callback.onFailure(new ApiException("API request failed: %s (%d)".formatted(errors, response.code()), response.code()));
                }
            }
        });
    }

}
