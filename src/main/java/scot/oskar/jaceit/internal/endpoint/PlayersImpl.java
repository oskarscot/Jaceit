package scot.oskar.jaceit.internal.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scot.oskar.jaceit.api.endpoint.Players;
import scot.oskar.jaceit.api.entity.player.*;
import scot.oskar.jaceit.api.request.ApiClient;
import scot.oskar.jaceit.api.request.QueryParameters;
import scot.oskar.jaceit.internal.web.check.ParameterCheck;
import scot.oskar.jaceit.internal.web.check.impl.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static scot.oskar.jaceit.internal.util.SimpleRequestCaller.fetchAsync;
import static scot.oskar.jaceit.internal.util.SimpleRequestCaller.fetchSync;
import static scot.oskar.jaceit.internal.util.ValidationUtil.validateUrl;

public class PlayersImpl implements Players {

    private final ApiClient apiClient;
    private final String FACEIT_DATA_API = "https://open.faceit.com/data/v4/";

    public PlayersImpl(ApiClient apiClient) {
        this.apiClient = apiClient;
    }


    @Override
    public PlayerProfile getDetailsById(String playerId) {
        return fetchSync(apiClient, FACEIT_DATA_API + "players/" + playerId, PlayerProfile.class);
    }


    @Override
    public CompletableFuture<PlayerProfile> getDetailsByIdAsync(String playerId) {
        return fetchAsync(apiClient, FACEIT_DATA_API + "players/" + playerId, PlayerProfile.class);
    }

    @Override
    public PlayerProfile getDetailsByNickname(String nickname, QueryParameters parameters) {
        parameters.add("nickname", nickname);
        return fetchSync(apiClient, FACEIT_DATA_API + "players?" + parameters, PlayerProfile.class);
    }

    @Override
    public PlayerProfile getDetailsByNickname(String nickname) {
        return fetchSync(apiClient, FACEIT_DATA_API + "players?nickname=" + nickname, PlayerProfile.class);
    }

    @Override
    public CompletableFuture<PlayerProfile> getDetailsByNicknameAsync(String nickname, QueryParameters parameters) {
        parameters.add("nickname", nickname);
        return fetchAsync(apiClient, FACEIT_DATA_API + "players?" + parameters, PlayerProfile.class);
    }

    @Override
    public CompletableFuture<PlayerProfile> getDetailsByNicknameAsync(String nickname) {
        return fetchAsync(apiClient, FACEIT_DATA_API + "players?nickname=" + nickname, PlayerProfile.class);
    }

    @Override
    public PlayerResults getLastResultsForGame(String playerId, String game) {
        return fetchSync(apiClient, FACEIT_DATA_API + "players/" + playerId + "/games/" + game + "/stats", PlayerResults.class);
    }

    @Override
    public PlayerResults getLastResultsForGame(String playerId, String game, QueryParameters parameters) {
        String url = FACEIT_DATA_API + "players/" + playerId + "/games/" + game + "/stats?" + parameters;

        Map<String, List<ParameterCheck>> checks = Map.of("offset", List.of(new ParametersContainValueCheck("limit"), new IntegerCheck(), new OffsetDivisibleByLimitCheck(), new NonNegativeCheck()), "limit", List.of(new IntegerCheck(), new NonNegativeCheck(), new LimitCheck(100)));

        validateUrl(url, checks);

        return fetchSync(apiClient, url, PlayerResults.class);
    }

    @Override
    public CompletableFuture<PlayerResults> getResultsForGameAsync(String playerId, String game, QueryParameters parameters) {
        String url = FACEIT_DATA_API + "players/" + playerId + "/games/" + game + "/stats?" + parameters;

        Map<String, List<ParameterCheck>> checks = Map.of("offset", List.of(new ParametersContainValueCheck("limit"), new IntegerCheck(), new OffsetDivisibleByLimitCheck(), new NonNegativeCheck()), "limit", List.of(new IntegerCheck(), new NonNegativeCheck(), new LimitCheck(100)));

        validateUrl(url, checks);

        return fetchAsync(apiClient, url, PlayerResults.class);
    }

    @Override
    public CompletableFuture<PlayerResults> getResultsForGameAsync(String playerId, String game) {
        return fetchAsync(apiClient, FACEIT_DATA_API + "players/" + playerId + "/games/" + game + "/stats", PlayerResults.class);
    }

    @Override
    public PlayerBans getPlayerBans(String playerId) {
        return fetchSync(apiClient, FACEIT_DATA_API + "players/" + playerId + "/bans", PlayerBans.class);
    }

    @Override
    public CompletableFuture<PlayerBans> getPlayerBansAsync(String playerId) {
        return fetchAsync(apiClient, FACEIT_DATA_API + "players/" + playerId + "/bans", PlayerBans.class);
    }

    @Override
    public PlayerMatchHistory getMatchHistory(String playerId, String game) {
        return fetchSync(apiClient, FACEIT_DATA_API + "players/" + playerId + "/history?game=" + game, PlayerMatchHistory.class);
    }

    @Override
    public PlayerMatchHistory getMatchHistory(String playerId, String game, QueryParameters parameters) {
        parameters.add("game", game);
        String url = FACEIT_DATA_API + "players/" + playerId + "/history?" + parameters;

        Map<String, List<ParameterCheck>> checks = Map.of("offset", List.of(new ParametersContainValueCheck("limit"), new IntegerCheck(), new OffsetDivisibleByLimitCheck(), new NonNegativeCheck()), "limit", List.of(new IntegerCheck(), new NonNegativeCheck(), new LimitCheck(100)), "from", List.of(new IntegerCheck(), new NonNegativeCheck(), new FromBeforeToCheck()), "to", List.of(new IntegerCheck(), new NonNegativeCheck()));

        validateUrl(url, checks);

        return fetchSync(apiClient, url, PlayerMatchHistory.class);
    }

    @Override
    public PlayerHubs getPlayerHubs(String playerId) {
        return fetchSync(apiClient, FACEIT_DATA_API + "players/" + playerId + "/hubs", PlayerHubs.class);
    }

    @Override
    public PlayerHubs getPlayerHubs(String playerId, QueryParameters parameters) {
        String url = FACEIT_DATA_API + "players/" + playerId + "/hubs?" + parameters;

        Map<String, List<ParameterCheck>> checks = Map.of("offset", List.of(new ParametersContainValueCheck("limit"), new IntegerCheck(), new OffsetDivisibleByLimitCheck(), new NonNegativeCheck()), "limit", List.of(new IntegerCheck(), new NonNegativeCheck(), new LimitCheck(50)));

        validateUrl(url, checks);

        return fetchSync(apiClient, url, PlayerHubs.class);
    }

    @Override
    public PlayerTeams getPlayerTeams(String playerId) {
        return fetchSync(apiClient, FACEIT_DATA_API + "players/" + playerId + "/teams", PlayerTeams.class);
    }

    @Override
    public PlayerTeams getPlayerTeams(String playerId, QueryParameters parameters) {
        String url = FACEIT_DATA_API + "players/" + playerId + "/teams?" + parameters;

        Map<String, List<ParameterCheck>> checks = Map.of("offset", List.of(new ParametersContainValueCheck("limit"), new IntegerCheck(), new OffsetDivisibleByLimitCheck(), new NonNegativeCheck()), "limit", List.of(new IntegerCheck(), new NonNegativeCheck(), new LimitCheck(50)));

        validateUrl(url, checks);

        return fetchSync(apiClient, url, PlayerTeams.class);
    }

    @Override
    public PlayerTournaments getPlayerTournaments(String playerId) {
        return fetchSync(apiClient, FACEIT_DATA_API + "players/" + playerId + "/tournaments", PlayerTournaments.class);
    }

    @Override
    public PlayerTournaments getPlayerTournaments(String playerId, QueryParameters parameters) {
        String url = FACEIT_DATA_API + "players/" + playerId + "/tournaments?" + parameters;

        Map<String, List<ParameterCheck>> checks = Map.of("offset", List.of(new ParametersContainValueCheck("limit"), new IntegerCheck(), new OffsetDivisibleByLimitCheck(), new NonNegativeCheck()), "limit", List.of(new IntegerCheck(), new NonNegativeCheck(), new LimitCheck(50)));

        validateUrl(url, checks);

        return fetchSync(apiClient, url, PlayerTournaments.class);
    }

    @Override
    public PlayerStats getPlayerStats(String playerId, String game) {
        return fetchSync(apiClient, FACEIT_DATA_API + "players/" + playerId + "/stats/" + game, PlayerStats.class);
    }
}
