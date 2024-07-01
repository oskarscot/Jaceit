package scot.oskar.jaceit.api.request;


import scot.oskar.jaceit.api.exception.ApiException;

/**
 * Callback for API calls.
 *
 * @param <T> the type of the result
 */
public interface ApiCallback<T> {

    /**
     * Called when the API call is successful.
     *
     * @param result the result of the API call
     */
    void onSuccess(T result);

    /**
     * Called when the API call fails.
     *
     * @param exception contains information about the failure and status code
     */
    void onFailure(ApiException exception);

}
