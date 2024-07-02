package scot.oskar.jaceit.api.request;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class QueryParameters {

    private final Map<String, String> queryParameters;

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

    public String get(String key) {
        return queryParameters.get(key);
    }

    public boolean contains(String key) {
        return queryParameters.containsKey(key);
    }

    public QueryParameters add(String key, String value) {
        queryParameters.put(key, value);
        return this;
    }

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
