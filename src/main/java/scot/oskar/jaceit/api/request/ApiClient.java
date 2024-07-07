package scot.oskar.jaceit.api.request;

import java.util.concurrent.CompletableFuture;

/**
 * This interface represents a client that can make requests to the Faceit API.
 * The client is asynchronous and will return the result of the request in a callback.
 */
public interface ApiClient {

    /**
     * Make a GET request to the Faceit API. The response will be parsed into the given type.
     * @param url the url to call
     * @param responseType the type to parse the response into
     * @param callback the callback to call when the request is complete
     */
    <T> void getWithCallback(String url, Class<T> responseType, ApiCallback<T> callback);

    /**
     * Make a GET request to the Faceit API. The response will be parsed into the given type. This method will return a
     * CompletableFuture that will complete when the request is complete.
     * @param url the url to call
     * @param responseType the type to parse the response into
     * @return a CompletableFuture that will complete when the request is complete
     */
    <T> CompletableFuture<T> get(String url, Class<T> responseType);
}
