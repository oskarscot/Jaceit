package scot.oskar.jaceit.api.exception;

/**
 * An exception that is thrown when an error occurs while interacting with the FACEIT API.
 **/
public class ApiException extends Exception {

    private final int statusCode;

    public ApiException(String message) {
        super(message);
        this.statusCode = 0;
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
        this.statusCode = 0;
    }

    public ApiException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
