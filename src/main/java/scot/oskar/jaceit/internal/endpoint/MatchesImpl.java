package scot.oskar.jaceit.internal.endpoint;

import scot.oskar.jaceit.api.endpoint.Matches;
import scot.oskar.jaceit.api.entity.match.MatchDetails;
import scot.oskar.jaceit.api.entity.match.MatchStats;
import scot.oskar.jaceit.api.request.ApiClient;

import java.util.concurrent.CompletableFuture;

import static scot.oskar.jaceit.internal.util.SimpleRequestCaller.fetchAsync;
import static scot.oskar.jaceit.internal.util.SimpleRequestCaller.fetchSync;

public class MatchesImpl implements Matches {

    private final ApiClient apiClient;
    private final String FACEIT_DATA_API = "https://open.faceit.com/data/v4/";

    public MatchesImpl(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public MatchDetails getMatchDetails(String matchId) {
        return fetchSync(apiClient, FACEIT_DATA_API + "matches/" + matchId, MatchDetails.class);
    }

    @Override
    public CompletableFuture<MatchDetails> getMatchDetailsAsync(String matchId) {
        return fetchAsync(apiClient, FACEIT_DATA_API + "matches/" + matchId, MatchDetails.class);
    }

    @Override
    public MatchStats getMatchStats(String matchId) {
        return fetchSync(apiClient, FACEIT_DATA_API + "matches/" + matchId + "/stats", MatchStats.class);
    }

    @Override
    public CompletableFuture<MatchStats> getMatchStatsAsync(String matchId) {
        return fetchAsync(apiClient, FACEIT_DATA_API + "matches/" + matchId + "/stats", MatchStats.class);
    }


}
