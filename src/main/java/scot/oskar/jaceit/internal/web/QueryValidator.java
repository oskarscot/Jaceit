package scot.oskar.jaceit.internal.web;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class QueryValidator {

    private final Map<String, Predicate<String>> parameterChecks;
    private final Map<String, String> failedParameters;
    private final List<BiPredicate<String, Map<String, String>>> customChecks;

    public QueryValidator() {
        this.parameterChecks = new HashMap<>();
        this.failedParameters = new HashMap<>();
        this.customChecks = new ArrayList<>();
    }

    public QueryValidator addCheck(String parameter, Predicate<String> check) {
        parameterChecks.put(parameter, check);
        return this;
    }

    public QueryValidator addCheck(BiPredicate<String, Map<String, String>> check) {
        customChecks.add(check);
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
            String value = entry.getValue();
            Predicate<String> check = parameterChecks.get(key);
            if (check != null && !check.test(value)) {
                failedParameters.put(key, value);
                isValid = false;
            }
        }

        // Apply custom checks if present
        for (BiPredicate<String, Map<String, String>> customCheck : customChecks) {
            if (!customCheck.test(null, parameters)) {
                isValid = false;
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