package scot.oskar.jaceit.api.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import scot.oskar.jaceit.internal.entity.ApiErrorResponseImpl;

import java.util.List;

@JsonDeserialize(as = ApiErrorResponseImpl.class)
public interface ApiErrorResponse {

    List<ErrorDetail> getErrors();

    @JsonDeserialize(as = ApiErrorResponseImpl.ErrorDetailImpl.class)
    interface ErrorDetail {

        String getMessage();

        String getCode();

        int getHttpStatus();

        List<String> getParameters();

    }
}
