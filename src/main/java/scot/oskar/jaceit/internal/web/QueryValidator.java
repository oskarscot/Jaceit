package scot.oskar.jaceit.internal.web;

import scot.oskar.jaceit.internal.web.check.ParameterCheck;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryValidator {

    private final Map<String, List<ParameterCheck>> parameterChecks;
    private final Map<String, String> failedParameters;
    private final List<ParameterCheck> compositeChecks;

    public QueryValidator() {
        this.parameterChecks = new HashMap<>();
        this.failedParameters = new HashMap<>();
        this.compositeChecks = new ArrayList<>();
    }

    public QueryValidator addCheck(String parameter, ParameterCheck check) {
        parameterChecks.computeIfAbsent(parameter, k -> new ArrayList<>()).add(check);
        return this;
    }

    public QueryValidator addCompositeCheck(ParameterCheck check) {
        this.compositeChecks.add(check);
        return this;
    }

    public boolean validate(String url) {
        failedParameters.clear();  // Clear previous errors
        String queryString = extractQueryString(url);
        if (queryString == null) {
            return false;
        }

        Map<String, String> parameters = parseQueryString(queryString);
        boolean isValid = true;

        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            String key = entry.getKey();
            List<ParameterCheck> checks = parameterChecks.get(key);
            if (checks != null) {
                for (ParameterCheck check : checks) {
                    if (!check.test(parameters, key)) {
                        failedParameters.put(key, entry.getValue());
                        isValid = false;
                    }
                }
            }
        }

        for (ParameterCheck check : compositeChecks) {
            if (!check.test(parameters, null)) {
                return false;
            }
        }

        return isValid;
    }

    private String extractQueryString(String url) {
        int queryStart = url.indexOf("?");
        if (queryStart == -1) {
            return null;
        }
        return url.substring(queryStart + 1);
    }

    private Map<String, String> parseQueryString(String queryString) {
        Map<String, String> parameters = new HashMap<>();
        String[] pairs = queryString.split("&");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2) {
                String key = decode(keyValue[0]);
                String value = decode(keyValue[1]);
                parameters.put(key, value);
            }
        }
        return parameters;
    }

    private String decode(String value) {
        return URLDecoder.decode(value, StandardCharsets.UTF_8);
    }

    public String getErrors() {
        if (failedParameters.isEmpty()) {
            return "No errors.";
        }

        StringBuilder errorBuilder = new StringBuilder("Validation failed for parameters: ");
        failedParameters.forEach((key, value) -> errorBuilder
                .append("\nParameter: ").append(key)
                .append(", Value: ").append(value));
        return errorBuilder.toString();
    }
}