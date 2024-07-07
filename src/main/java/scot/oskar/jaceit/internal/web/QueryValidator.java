package scot.oskar.jaceit.internal.web;

import scot.oskar.jaceit.internal.web.check.ParameterCheck;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An instance of this class can be used to validate query strings in URLs.
 * It allows for the addition of checks for specific parameters and composite checks
 * that can be used to validate multiple parameters at once.

 * The checks are run in the order they are added, and the first check that fails will
 * cause the validation to fail.

 * The checks are implemented as classes that implement the {@link ParameterCheck} interface.
 * For parameter specific checks use {@link #addCheck(String, ParameterCheck)}
 * For checks that should be run on multiple parameters use {@link #addCompositeCheck(ParameterCheck)}
 */
public class QueryValidator {

    private final Map<String, List<ParameterCheck>> parameterChecks;
    private final Map<String, String> failedParameters;
    private final List<ParameterCheck> compositeChecks;

    public QueryValidator() {
        this.parameterChecks = new HashMap<>();
        this.failedParameters = new HashMap<>();
        this.compositeChecks = new ArrayList<>();
    }

    /**
     * Add a check for a specific parameter, this check will be run when the parameter is present.
     * For checks that should be run on multiple parameters use {@link #addCompositeCheck(ParameterCheck)}
     *
     * @param parameter is the parameter that we want to validate.
     * @param check an implementation of a ParameterCheck {@link ParameterCheck}
     * @return QueryValidator
     */
    public QueryValidator addCheck(String parameter, ParameterCheck check) {
        parameterChecks.computeIfAbsent(parameter, k -> new ArrayList<>()).add(check);
        return this;
    }

    /**
     * Adds a new composite check that will be run on all parameters.
     * For parameter specific checks use {@link #addCheck(String, ParameterCheck)}
     *
     * @param check the composite check to add
     * @return this QueryValidator instance
     */
    public QueryValidator addCompositeCheck(ParameterCheck check) {
        this.compositeChecks.add(check);
        return this;
    }

    /**
     * Validate the query string in the given URL against the checks that have been added.
     *
     * @param url the URL to validate
     * @return true if the URL is invalid, false otherwise
     */
    public boolean invalid(String url) {
        failedParameters.clear();  // Clear previous errors
        String queryString = extractQueryString(url);
        if (queryString == null) {
            return true;
        }

        // param=abc
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
                return true;
            }
        }

        return !isValid;
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

    /**
     * Get the error string for the failed parameters.
     *
     * @return an error string containing the parameters that failed validation
     */
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