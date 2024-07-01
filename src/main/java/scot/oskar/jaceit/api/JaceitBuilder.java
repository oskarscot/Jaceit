package scot.oskar.jaceit.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import scot.oskar.jaceit.internal.JaceitImpl;

import java.util.concurrent.TimeUnit;

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
    private OkHttpClient httpClient = new OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build();
    private ObjectMapper objectMapper = new ObjectMapper();

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

    public JaceitImpl build() {
        return new JaceitImpl(apiKey, httpClient, objectMapper);
    }

}
