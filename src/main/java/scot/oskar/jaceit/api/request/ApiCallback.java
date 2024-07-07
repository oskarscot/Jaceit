package scot.oskar.jaceit.api.request;


import scot.oskar.jaceit.api.exception.ApiException;

/**
 * Callback for API calls. Implement this interface to handle the result of an API call.
 *
 * @param <T> the type of the result
 */
public interface ApiCallback<T> {

    /**
     * Called when the API call is successful.
     * The result of the API call is passed to this method.
     *
     * @param result the result of the API call
     */
    void onSuccess(T result);

    /**
     * Called when the API call fails.
     * The exception contains information about the failure and status code.
     *
     * @param exception contains information about the failure and status code
     */
    void onFailure(ApiException exception);

}
