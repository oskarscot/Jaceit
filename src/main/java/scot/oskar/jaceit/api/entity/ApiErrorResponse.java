package scot.oskar.jaceit.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents an error response from the Faceit API.
 */
public class ApiErrorResponse {

    @JsonProperty("errors")
    private List<ErrorDetail> errors;

    public List<ErrorDetail> getErrors() {
        return errors;
    }

    public static class ErrorDetail {

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
