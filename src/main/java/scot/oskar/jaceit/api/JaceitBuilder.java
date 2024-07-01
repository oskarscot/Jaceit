package scot.oskar.jaceit;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;

public class JaceitBuilder {

    public static JaceitBuilder create(String apiKey) {
        return new JaceitBuilder(apiKey);
    }

    public static JaceitBuilder createDefault(String apiKey) {
        return new JaceitBuilder(apiKey)
                .withDefaultHttpClient()
                .withDefaultObjectMapper();
    }

    private final String apiKey;
    private OkHttpClient httpClient;
    private ObjectMapper objectMapper;

    private JaceitBuilder(String apiKey) {
        this.apiKey = apiKey;
    }

    public JaceitBuilder withHttpClient(OkHttpClient httpClient) {
        this.httpClient = httpClient;
        return this;
    }

    public JaceitBuilder withDefaultHttpClient() {
        return this;
    }

    public JaceitBuilder withObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        return this;
    }

    public JaceitBuilder withDefaultObjectMapper() {
        return this;
    }

    public Jaceit build() {
        return new Jaceit(apiKey, httpClient, objectMapper);
    }

}
