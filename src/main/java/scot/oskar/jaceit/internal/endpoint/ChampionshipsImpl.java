package scot.oskar.jaceit.internal.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scot.oskar.jaceit.api.endpoint.Championships;
import scot.oskar.jaceit.api.entity.championship.ChampionshipResponse;
import scot.oskar.jaceit.api.entity.championship.ChampionshipType;
import scot.oskar.jaceit.api.exception.ApiException;
import scot.oskar.jaceit.api.exception.DataFetchException;
import scot.oskar.jaceit.api.request.ApiCallback;
import scot.oskar.jaceit.api.request.ApiClient;
import scot.oskar.jaceit.api.request.QueryParameters;
import scot.oskar.jaceit.internal.web.QueryValidator;
import scot.oskar.jaceit.internal.web.check.ParameterCheck;
import scot.oskar.jaceit.internal.web.check.impl.IntegerCheck;
import scot.oskar.jaceit.internal.web.check.impl.LimitCheck;
import scot.oskar.jaceit.internal.web.check.impl.NonNegativeCheck;
import scot.oskar.jaceit.internal.web.check.impl.OffsetDivisibleByLimitCheck;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ChampionshipsImpl implements Championships  {

    private final Logger logger = LoggerFactory.getLogger("Championships");
    private final ApiClient apiClient;
    private final String FACEIT_DATA_API = "https://open.faceit.com/data/v4/";

    public ChampionshipsImpl(ApiClient apiClient) {
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

    private void validateUrl(String url, Map<String, List<ParameterCheck>> checks) {
        QueryValidator validator = new QueryValidator();
        checks.forEach((key, checkList) -> checkList.forEach(check -> validator.addCheck(key, check)));

        if (validator.invalid(url)) {
            logger.warn("Invalid query parameters: {}", validator.getErrors());
            throw new IllegalArgumentException("Invalid query parameters");
        }
    }

    @Override
    public ChampionshipResponse getChampionships(String game) {
        return fetchSync(FACEIT_DATA_API + "championships?game=" + game, ChampionshipResponse.class);
    }

    @Override
    public ChampionshipResponse getChampionships(String game, ChampionshipType type) {
        return fetchSync(FACEIT_DATA_API + "championships?game=" + game + "&type=" + type.toString().toLowerCase(), ChampionshipResponse.class);
    }

    @Override
    public ChampionshipResponse getChampionships(String game, ChampionshipType type, QueryParameters queryParameters) {
        queryParameters.add("game", game);
        queryParameters.add("type", type.toString().toLowerCase());

        String url = FACEIT_DATA_API + "championships?" + queryParameters.toQueryString();

        Map<String, List<ParameterCheck>> checks = Map.of(
                "limit", List.of(
                        new IntegerCheck(),
                        new NonNegativeCheck(),
                        new LimitCheck(10)
                ),
                "offset", List.of(
                        new IntegerCheck(),
                        new NonNegativeCheck(),
                        new OffsetDivisibleByLimitCheck()
                )
        );

        validateUrl(url, checks);

        return fetchSync(url, ChampionshipResponse.class);
    }
}
