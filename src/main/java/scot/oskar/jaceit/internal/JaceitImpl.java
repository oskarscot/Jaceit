package scot.oskar.jaceit.internal;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scot.oskar.jaceit.api.Jaceit;
import scot.oskar.jaceit.api.endpoint.Championships;
import scot.oskar.jaceit.api.endpoint.Matches;
import scot.oskar.jaceit.api.endpoint.Players;
import scot.oskar.jaceit.api.request.ApiClient;
import scot.oskar.jaceit.internal.endpoint.ChampionshipsImpl;
import scot.oskar.jaceit.internal.endpoint.MatchesImpl;
import scot.oskar.jaceit.internal.endpoint.PlayersImpl;
import scot.oskar.jaceit.internal.web.ApiClientImpl;
import scot.oskar.jaceit.internal.web.JaceitInterceptor;

public class JaceitImpl implements Jaceit {

    private final Logger logger = LoggerFactory.getLogger("Jaceit");
    protected final String apiKey;
    protected final OkHttpClient httpClient;
    protected final ObjectMapper objectMapper;
    protected final PlayersImpl playerEndpoint;
    protected final MatchesImpl matchEndpoint;
    protected final ChampionshipsImpl championshipEndpoint;
    protected final ApiClient apiClient;

    public JaceitImpl(String apiKey, OkHttpClient httpClient, ObjectMapper objectMapper) {
        if (apiKey == null || apiKey.isBlank()) {
            logger.error("The provided API key is not valid.");
            throw new IllegalArgumentException("API key cannot be null or empty");
        }

        logger.trace("Creating Jaceit instance...");
        this.apiKey = apiKey;
        this.httpClient = httpClient.newBuilder()
                .addInterceptor(new JaceitInterceptor(this.apiKey))
                .build();
        this.objectMapper = objectMapper;

        logger.trace("Creating API client and endpoints...");
        this.apiClient = new ApiClientImpl(this.httpClient, this.objectMapper);

        this.playerEndpoint = new PlayersImpl(this.apiClient);
        this.matchEndpoint = new MatchesImpl(this.apiClient);
        this.championshipEndpoint = new ChampionshipsImpl(this.apiClient);
        logger.trace("Jaceit instance created");
    }

    @Override
    public ApiClient apiClient() {
        return this.apiClient;
    }

    @Override
    public Players players() {
        return this.playerEndpoint;
    }

    @Override
    public Matches matches() {
        return this.matchEndpoint;
    }

    @Override
    public Championships championships() {
        return this.championshipEndpoint;
    }
}
