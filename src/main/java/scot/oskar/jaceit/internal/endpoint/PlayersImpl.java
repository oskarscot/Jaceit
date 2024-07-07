package scot.oskar.jaceit.internal.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scot.oskar.jaceit.api.endpoint.Players;
import scot.oskar.jaceit.api.entity.player.*;
import scot.oskar.jaceit.api.exception.ApiException;
import scot.oskar.jaceit.api.exception.DataFetchException;
import scot.oskar.jaceit.api.request.ApiCallback;
import scot.oskar.jaceit.api.request.ApiClient;
import scot.oskar.jaceit.api.request.QueryParameters;
import scot.oskar.jaceit.internal.web.QueryValidator;
import scot.oskar.jaceit.internal.web.check.ParameterCheck;
import scot.oskar.jaceit.internal.web.check.impl.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class PlayersImpl implements Players {

    private final Logger logger = LoggerFactory.getLogger("Players");
    private final ApiClient apiClient;
    private final String FACEIT_DATA_API = "https://open.faceit.com/data/v4/";

    public PlayersImpl(ApiClient apiClient) {
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
    public PlayerProfile getDetailsById(String playerId) {
        return fetchSync(FACEIT_DATA_API + "players/" + playerId, PlayerProfile.class);
    }


    @Override
    public CompletableFuture<PlayerProfile> getDetailsByIdAsync(String playerId) {
        return fetchAsync(FACEIT_DATA_API + "players/" + playerId, PlayerProfile.class);
    }

    @Override
    public PlayerProfile getDetailsByNickname(String nickname, QueryParameters parameters) {
        parameters.add("nickname", nickname);
        return fetchSync(FACEIT_DATA_API + "players?" + parameters, PlayerProfile.class);
    }

    @Override
    public PlayerProfile getDetailsByNickname(String nickname) {
        return fetchSync(FACEIT_DATA_API + "players?nickname=" + nickname, PlayerProfile.class);
    }

    @Override
    public CompletableFuture<PlayerProfile> getDetailsByNicknameAsync(String nickname, QueryParameters parameters) {
        parameters.add("nickname", nickname);
        return fetchAsync( FACEIT_DATA_API + "players?" + parameters, PlayerProfile.class);
    }

    @Override
    public CompletableFuture<PlayerProfile> getDetailsByNicknameAsync(String nickname) {
        return fetchAsync(FACEIT_DATA_API + "players?nickname=" + nickname, PlayerProfile.class);
    }

    @Override
    public PlayerResults getLastResultsForGame(String playerId, String game) {
        return fetchSync(FACEIT_DATA_API + "players/" + playerId + "/games/" + game + "/stats", PlayerResults.class);
    }

    @Override
    public PlayerResults getLastResultsForGame(String playerId, String game, QueryParameters parameters) {
        String url = FACEIT_DATA_API + "players/" + playerId + "/games/" + game + "/stats?" + parameters;

        Map<String, List<ParameterCheck>> checks = Map.of(
                "offset", List.of(
                        new ParametersContainValueCheck("limit"),
                        new IntegerCheck(),
                        new OffsetDivisibleByLimitCheck(),
                        new NonNegativeCheck()
                ),
                "limit", List.of(
                        new IntegerCheck(),
                        new NonNegativeCheck(),
                        new LimitCheck(100)
                )
        );

        validateUrl(url, checks);

        return fetchSync(url, PlayerResults.class);
    }

    @Override
    public CompletableFuture<PlayerResults> getResultsForGameAsync(String playerId, String game, QueryParameters parameters) {
        String url = FACEIT_DATA_API + "players/" + playerId + "/games/" + game + "/stats?" + parameters;

        Map<String, List<ParameterCheck>> checks = Map.of(
                "offset", List.of(
                        new ParametersContainValueCheck("limit"),
                        new IntegerCheck(),
                        new OffsetDivisibleByLimitCheck(),
                        new NonNegativeCheck()
                ),
                "limit", List.of(
                        new IntegerCheck(),
                        new NonNegativeCheck(),
                        new LimitCheck(100)
                )
        );

        validateUrl(url, checks);

        return fetchAsync(url, PlayerResults.class);
    }

    @Override
    public CompletableFuture<PlayerResults> getResultsForGameAsync(String playerId, String game) {
        return fetchAsync(FACEIT_DATA_API + "players/" + playerId + "/games/" + game + "/stats", PlayerResults.class);
    }

    @Override
    public PlayerBans getPlayerBans(String playerId) {
        return fetchSync(FACEIT_DATA_API + "players/" + playerId + "/bans", PlayerBans.class);
    }

    @Override
    public CompletableFuture<PlayerBans> getPlayerBansAsync(String playerId) {
        return fetchAsync(FACEIT_DATA_API + "players/" + playerId + "/bans", PlayerBans.class);
    }

    @Override
    public PlayerMatchHistory getMatchHistory(String playerId, String game) {
        return fetchSync(FACEIT_DATA_API + "players/" + playerId + "/history?game=" + game, PlayerMatchHistory.class);
    }

    @Override
    public PlayerMatchHistory getMatchHistory(String playerId, String game, QueryParameters parameters) {
        parameters.add("game", game);
        String url = FACEIT_DATA_API + "players/" + playerId + "/history?" + parameters;

        Map<String, List<ParameterCheck>> checks = Map.of(
                "offset", List.of(
                        new ParametersContainValueCheck("limit"),
                        new IntegerCheck(),
                        new OffsetDivisibleByLimitCheck(),
                        new NonNegativeCheck()
                ),
                "limit", List.of(
                        new IntegerCheck(),
                        new NonNegativeCheck(),
                        new LimitCheck(100)
                ),
                "from", List.of(
                        new IntegerCheck(),
                        new NonNegativeCheck(),
                        new FromBeforeToCheck()
                ),
                "to", List.of(
                        new IntegerCheck(),
                        new NonNegativeCheck()
                )
        );

        validateUrl(url, checks);

        return fetchSync(url, PlayerMatchHistory.class);
    }

    @Override
    public PlayerHubs getPlayerHubs(String playerId) {
        return fetchSync(FACEIT_DATA_API + "players/" + playerId + "/hubs", PlayerHubs.class);
    }

    @Override
    public PlayerHubs getPlayerHubs(String playerId, QueryParameters parameters) {
        String url = FACEIT_DATA_API + "players/" + playerId + "/hubs?" + parameters;

        Map<String, List<ParameterCheck>> checks = Map.of(
                "offset", List.of(
                        new ParametersContainValueCheck("limit"),
                        new IntegerCheck(),
                        new OffsetDivisibleByLimitCheck(),
                        new NonNegativeCheck()
                ),
                "limit", List.of(
                        new IntegerCheck(),
                        new NonNegativeCheck(),
                        new LimitCheck(50)
                )
        );

        validateUrl(url, checks);

        return fetchSync(url, PlayerHubs.class);
    }

    @Override
    public PlayerTeams getPlayerTeams(String playerId) {
        return fetchSync(FACEIT_DATA_API + "players/" + playerId + "/teams", PlayerTeams.class);
    }

    @Override
    public PlayerTeams getPlayerTeams(String playerId, QueryParameters parameters) {
        String url = FACEIT_DATA_API + "players/" + playerId + "/teams?" + parameters;

        Map<String, List<ParameterCheck>> checks = Map.of(
                "offset", List.of(
                        new ParametersContainValueCheck("limit"),
                        new IntegerCheck(),
                        new OffsetDivisibleByLimitCheck(),
                        new NonNegativeCheck()
                ),
                "limit", List.of(
                        new IntegerCheck(),
                        new NonNegativeCheck(),
                        new LimitCheck(50)
                )
        );

        validateUrl(url, checks);

        return fetchSync(url, PlayerTeams.class);
    }

    @Override
    public PlayerTournaments getPlayerTournaments(String playerId) {
        return fetchSync(FACEIT_DATA_API + "players/" + playerId + "/tournaments", PlayerTournaments.class);
    }

    @Override
    public PlayerTournaments getPlayerTournaments(String playerId, QueryParameters parameters) {
        String url = FACEIT_DATA_API + "players/" + playerId + "/tournaments?" + parameters;

        Map<String, List<ParameterCheck>> checks = Map.of(
                "offset", List.of(
                        new ParametersContainValueCheck("limit"),
                        new IntegerCheck(),
                        new OffsetDivisibleByLimitCheck(),
                        new NonNegativeCheck()
                ),
                "limit", List.of(
                        new IntegerCheck(),
                        new NonNegativeCheck(),
                        new LimitCheck(50)
                )
        );

        validateUrl(url, checks);

        return fetchSync(url, PlayerTournaments.class);
    }

    @Override
    public PlayerStats getPlayerStats(String playerId, String game) {
        return fetchSync(FACEIT_DATA_API + "players/" + playerId + "/stats/" + game, PlayerStats.class);
    }
}
