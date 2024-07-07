package scot.oskar.jaceit.api.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import scot.oskar.jaceit.internal.entity.ApiErrorResponseImpl;

import java.util.List;

/**
 * Represents the structure of an API error response.
 * This interface defines the methods to access the details of the errors included in the response.
 * The implementation class for this interface is {@link ApiErrorResponseImpl}.
 */
@JsonDeserialize(as = ApiErrorResponseImpl.class)
public interface ApiErrorResponse {

    /**
     * Retrieves the list of error details included in the API error response.
     *
     * @return a list of {@link ErrorDetail} instances.
     */
    List<ErrorDetail> getErrors();

    /**
     * Represents the details of an individual error included in the API error response.
     * This interface defines the methods to access the properties of an error detail.
     * The implementation class for this interface is {@link ApiErrorResponseImpl.ErrorDetailImpl}.
     */
    @JsonDeserialize(as = ApiErrorResponseImpl.ErrorDetailImpl.class)
    interface ErrorDetail {

        /**
         * Retrieves the error message.
         *
         * @return a string representing the error message.
         */
        String getMessage();

        /**
         * Retrieves the error code.
         *
         * @return a string representing the error code.
         */
        String getCode();

        /**
         * Retrieves the HTTP status associated with the error.
         *
         * @return an integer representing the HTTP status.
         */
        int getHttpStatus();

        /**
         * Retrieves the list of parameters related to the error.
         *
         * @return a list of strings representing the error parameters.
         */
        List<String> getParameters();
    }
}
