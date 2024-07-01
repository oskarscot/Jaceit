package scot.oskar.jaceit.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import scot.oskar.jaceit.api.Jaceit;
import scot.oskar.jaceit.api.endpoint.Players;
import scot.oskar.jaceit.api.request.ApiClient;
import scot.oskar.jaceit.internal.endpoint.PlayerEndpoint;
import scot.oskar.jaceit.internal.web.ApiClientImpl;
import scot.oskar.jaceit.internal.web.JaceitInterceptor;

public class JaceitImpl implements Jaceit {

    private final String apiKey;
    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper;
    private final PlayerEndpoint playerEndpoint;
    private ApiClient apiClient;

    public JaceitImpl(String apiKey, OkHttpClient httpClient, ObjectMapper objectMapper) {
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalArgumentException("API key is invalid or missing!");
        }

        this.apiKey = apiKey;
        this.httpClient = httpClient.newBuilder()
                .addInterceptor(new JaceitInterceptor(this.apiKey))
                .build();
        this.objectMapper = objectMapper;

        this.apiClient = new ApiClientImpl(this.httpClient, this.objectMapper);

        this.playerEndpoint = new PlayerEndpoint(this.apiClient);
    }

    @Override
    public ApiClient apiClient() {
        return this.apiClient;
    }

    @Override
    public Players players() {
        return this.playerEndpoint;
    }
}
