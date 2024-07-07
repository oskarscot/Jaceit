package scot.oskar.jaceit.internal.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import scot.oskar.jaceit.api.entity.ApiErrorResponse;

import java.util.List;

/**
 * Represents an error response from the Faceit API.
 */
public class ApiErrorResponseImpl implements ApiErrorResponse {

    @JsonProperty("errors")
    private List<ErrorDetail> errors;

    @Override
    public List<ApiErrorResponse.ErrorDetail> getErrors() {
        return errors;
    }

    public static class ErrorDetailImpl implements ErrorDetail {

        @JsonProperty("message")
        private String message;

        @JsonProperty("code")
        private String code;

        @JsonProperty("http_status")
        private int httpStatus;

        @JsonProperty("parameters")
        private List<String> parameters;

        public String getMessage() {
            return message;
        }

        public String getCode() {
            return code;
        }

        public int getHttpStatus() {
            return httpStatus;
        }

        public List<String> getParameters() {
            return parameters;
        }

        @Override
        public String toString() {
            return this.getMessage();
        }
    }
}
