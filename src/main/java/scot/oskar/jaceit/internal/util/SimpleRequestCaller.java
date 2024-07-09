package scot.oskar.jaceit.internal.util;

import org.apache.commons.lang3.Validate;
import scot.oskar.jaceit.api.exception.ApiException;
import scot.oskar.jaceit.api.exception.DataFetchException;
import scot.oskar.jaceit.api.request.ApiCallback;
import scot.oskar.jaceit.api.request.ApiClient;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class SimpleRequestCaller {

    private SimpleRequestCaller() {

    }

    public static <T> T fetchSync(ApiClient client, String url, Class<T> responseType) {
        Validate.isInstanceOf(ApiClient.class, client, "client must be an instance of ApiClient");
        Validate.notEmpty(url, "url must not be empty");
        Validate.notNull(url, "responseType must not be null");

        CompletableFuture<T> future = new CompletableFuture<>();
        client.getWithCallback(url, responseType, new ApiCallback<>() {
            @Override
            public void onSuccess(T result) {
                future.complete(result);
            }

            @Override
            public void onFailure(ApiException exception) {
                future.completeExceptionally(exception);
            }
        });

        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new DataFetchException("Failed to fetch data: " + e.getMessage());
        }
    }

    public static <T> CompletableFuture<T> fetchAsync(ApiClient client, String url, Class<T> responseType) {
        Validate.isInstanceOf(ApiClient.class, client, "client must be an instance of ApiClient");
        Validate.notEmpty(url, "url must not be empty");
        Validate.notNull(url, "responseType must not be null");

        return client.get(url, responseType);
    }

}
