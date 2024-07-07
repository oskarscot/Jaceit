package scot.oskar.jaceit.internal.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scot.oskar.jaceit.api.endpoint.Matches;
import scot.oskar.jaceit.api.entity.match.MatchDetails;
import scot.oskar.jaceit.api.exception.ApiException;
import scot.oskar.jaceit.api.exception.DataFetchException;
import scot.oskar.jaceit.api.request.ApiCallback;
import scot.oskar.jaceit.api.request.ApiClient;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MatchesImpl implements Matches {

    private final Logger logger = LoggerFactory.getLogger("Matches");
    private final ApiClient apiClient;
    private final String FACEIT_DATA_API = "https://open.faceit.com/data/v4/";

    public MatchesImpl(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    private <T> T fetchSync(String url, Class<T> responseType) {
        CompletableFuture<T> future = new CompletableFuture<>();
        apiClient.getWithCallback(url, responseType, new ApiCallback<>() {
            @Override
            public void onSuccess(T result) {
                future.complete(result);
            }

            @Override
            public void onFailure(ApiException exception) {
                future.completeExceptionally(exception);
            }
        });

        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new DataFetchException("Failed to fetch data: " + e.getMessage());
        }
    }

    private <T> CompletableFuture<T> fetchAsync(String url, Class<T> responseType) {
        return apiClient.get(url, responseType);
    }

    @Override
    public MatchDetails getMatchDetails(String matchId) {
        return fetchSync(FACEIT_DATA_API + "matches/" + matchId, MatchDetails.class);
    }
}
