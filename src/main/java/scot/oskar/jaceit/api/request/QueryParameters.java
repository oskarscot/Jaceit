package scot.oskar.jaceit.api.request;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;

/**
 * Represents a set of query parameters that can be added to a URL.
 */
public class QueryParameters {

    private final Map<String, String> queryParameters;

    /**
     * Create a new set of query parameters that should be provided in key-value pairs.
     *
     * @param params key-value pairs of parameters
     * @return a new set of query parameters
     */
    public static QueryParameters of(String... params) {
        return new QueryParameters(params);
    }

    private QueryParameters(String... params) {
        queryParameters = new HashMap<>();
        if (params.length % 2 != 0) {
            throw new IllegalArgumentException("Parameters should be provided in key-value pairs.");
        }
        for (int i = 0; i < params.length; i += 2) {
            queryParameters.put(params[i], params[i + 1]);
        }
    }

    /**
     * Get the value of a query parameter.
     *
     * @param key the key of the parameter
     * @return an optional containing the value if it exists, empty otherwise
     */
    public Optional<String> get(String key) {
        return Optional.ofNullable(queryParameters.get(key));
    }

    /**
     * Check if a query parameter exists.
     *
     * @param key the key of the parameter
     * @return true if the parameter exists, false otherwise
     */
    public boolean contains(String key) {
        return queryParameters.containsKey(key);
    }

    /**
     * Add a query parameter to the set if it doesn't exist.
     * If the parameter already exists, the value will not be updated.
     *
     * @param key   the key of the parameter
     * @param value the value of the parameter
     * @return this object
     */
    public QueryParameters add(String key, String value) {
        queryParameters.putIfAbsent(key, value);
        return this;
    }

    /**
     * Returns a string of parameters that can be appended to a URL.
     *
     * @return a URL ready string of parameters
     */
    public String toQueryString() {
        StringJoiner sj = new StringJoiner("&");
        for (Map.Entry<String, String> entry : queryParameters.entrySet()) {
            sj.add(encode(entry.getKey()) + "=" + encode(entry.getValue()));
        }
        return sj.toString();
    }

    private String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

    @Override
    public String toString() {
        return toQueryString();
    }
}
