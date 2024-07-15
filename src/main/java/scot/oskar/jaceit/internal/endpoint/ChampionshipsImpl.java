package scot.oskar.jaceit.internal.endpoint;

import org.apache.commons.lang3.Validate;
import scot.oskar.jaceit.api.endpoint.Championships;
import scot.oskar.jaceit.api.entity.championship.AllChampionships;
import scot.oskar.jaceit.api.entity.championship.ChampionshipType;
import scot.oskar.jaceit.api.request.ApiClient;
import scot.oskar.jaceit.api.request.QueryParameters;
import scot.oskar.jaceit.internal.web.check.ParameterCheck;
import scot.oskar.jaceit.internal.web.check.impl.IntegerCheck;
import scot.oskar.jaceit.internal.web.check.impl.LimitCheck;
import scot.oskar.jaceit.internal.web.check.impl.NonNegativeCheck;
import scot.oskar.jaceit.internal.web.check.impl.OffsetDivisibleByLimitCheck;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static scot.oskar.jaceit.internal.util.SimpleRequestCaller.fetchAsync;
import static scot.oskar.jaceit.internal.util.SimpleRequestCaller.fetchSync;
import static scot.oskar.jaceit.internal.util.ValidationUtil.validateUrl;

public class ChampionshipsImpl implements Championships  {

    private final ApiClient apiClient;
    private final String FACEIT_DATA_API = "https://open.faceit.com/data/v4/";

    public ChampionshipsImpl(ApiClient apiClient) {
        this.apiClient = apiClient;
    }


    @Override
    public AllChampionships getAll(String game) {
        Validate.notNull(game, "Game cannot be null");
        Validate.notEmpty(game, "Game cannot be empty");
        return fetchSync(apiClient, FACEIT_DATA_API + "championships?game=" + game, AllChampionships.class);
    }

    @Override
    public CompletableFuture<AllChampionships> getAllAsync(String game) {
        Validate.notNull(game, "Game cannot be null");
        Validate.notEmpty(game, "Game cannot be empty");
        return fetchAsync(apiClient, FACEIT_DATA_API + "championships?game=" + game, AllChampionships.class);
    }

    @Override
    public AllChampionships getAll(String game, ChampionshipType type) {
        Validate.notNull(game, "Game cannot be null!");
        Validate.notNull(type, "ChampionshipType cannot be null!");
        return fetchSync(apiClient, FACEIT_DATA_API + "championships?game=" + game + "&type=" + type.toString().toLowerCase(), AllChampionships.class);
    }

    @Override
    public CompletableFuture<AllChampionships> getAllAsync(String game, ChampionshipType type) {
        Validate.notNull(game, "Game cannot be null!");
        Validate.notNull(type, "ChampionshipType cannot be null!");
        Validate.notEmpty(game, "Game cannot be empty");
        return fetchAsync(apiClient, FACEIT_DATA_API + "championships?game=" + game + "&type=" + type.toString().toLowerCase(), AllChampionships.class);
    }

    @Override
    public AllChampionships getAll(String game, ChampionshipType type, QueryParameters queryParameters) {
        Validate.notNull(game, "Game cannot be null!");
        Validate.notEmpty(game, "Game cannot be empty");
        Validate.notNull(type, "ChampionshipType cannot be null!");
        Validate.notNull(queryParameters, "QueryParameters cannot be null!");
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

        return fetchSync(apiClient, url, AllChampionships.class);
    }

    @Override
    public CompletableFuture<AllChampionships> getAllAsync(String game, ChampionshipType type, QueryParameters queryParameters) {
        Validate.notNull(game, "Game cannot be null!");
        Validate.notEmpty(game, "Game cannot be empty");
        Validate.notNull(type, "ChampionshipType cannot be null!");
        Validate.notNull(queryParameters, "QueryParameters cannot be null!");
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

        return fetchAsync(apiClient, url, AllChampionships.class);
    }
}
