package scot.oskar.jaceit.internal.endpoint;

import scot.oskar.jaceit.api.endpoint.Players;
import scot.oskar.jaceit.api.entity.PlayerBans;
import scot.oskar.jaceit.api.entity.PlayerProfile;
import scot.oskar.jaceit.api.entity.PlayerResults;
import scot.oskar.jaceit.api.exception.ApiException;
import scot.oskar.jaceit.api.request.ApiCallback;
import scot.oskar.jaceit.api.request.ApiClient;
import scot.oskar.jaceit.api.request.QueryParameters;
import scot.oskar.jaceit.internal.web.QueryValidator;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class PlayerEndpoint implements Players {

    private final ApiClient apiClient;
    private final String FACEIT_DATA_API = "https://open.faceit.com/data/v4/";

    public PlayerEndpoint(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public PlayerProfile getDetailsById(String faceitId) {
        CompletableFuture<PlayerProfile> futureProfile = new CompletableFuture<>();

        apiClient.getBlocking(FACEIT_DATA_API + "players/" + faceitId, PlayerProfile.class, new ApiCallback<>() {

            @Override
            public void onSuccess(PlayerProfile result) {
                futureProfile.complete(result);
            }

            @Override
            public void onFailure(ApiException exception) {
                futureProfile.completeExceptionally(exception);
            }
        });

        try {
            return futureProfile.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Failed to fetch player profile", e);
        }
    }


    @Override
    public CompletableFuture<PlayerProfile> getDetailsByIdAsync(String faceitId) {
        return apiClient.getAsync(FACEIT_DATA_API + "players/" + faceitId, PlayerProfile.class);
    }

    @Override
    public PlayerProfile getDetailsByNickname(String nickname, QueryParameters parameters) {
        CompletableFuture<PlayerProfile> futureProfile = new CompletableFuture<>();
        parameters.add("nickname", nickname);

        apiClient.getBlocking(FACEIT_DATA_API + "players?" + parameters , PlayerProfile.class, new ApiCallback<>() {

            @Override
            public void onSuccess(PlayerProfile result) {
                futureProfile.complete(result);
            }

            @Override
            public void onFailure(ApiException exception) {
                futureProfile.completeExceptionally(exception);
            }
        });

        try {
            return futureProfile.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Failed to fetch player profile for nickname: " + nickname, e);
        }
    }

    @Override
    public PlayerProfile getDetailsByNickname(String nickname) {
        CompletableFuture<PlayerProfile> futureProfile = new CompletableFuture<>();

        apiClient.getBlocking(FACEIT_DATA_API + "players?nickname=" + nickname, PlayerProfile.class, new ApiCallback<>() {

            @Override
            public void onSuccess(PlayerProfile result) {
                futureProfile.complete(result);
            }

            @Override
            public void onFailure(ApiException exception) {
                futureProfile.completeExceptionally(exception);
            }
        });

        try {
            return futureProfile.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Failed to fetch player profile for nickname: " + nickname, e);
        }
    }

    @Override
    public CompletableFuture<PlayerProfile> getDetailsByNicknameAsync(String nickname, QueryParameters parameters) {
        parameters.add("nickname", nickname);
        return apiClient.getAsync( FACEIT_DATA_API + "players?" + parameters, PlayerProfile.class);
    }

    @Override
    public CompletableFuture<PlayerProfile> getDetailsByNicknameAsync(String nickname) {
        return apiClient.getAsync(FACEIT_DATA_API + "players?nickname=" + nickname, PlayerProfile.class);
    }

    @Override
    public PlayerResults getLastResultsForGame(String playerId, String game) {
        CompletableFuture<PlayerResults> futureResults = new CompletableFuture<>();

        apiClient.getBlocking(FACEIT_DATA_API + "players/" + playerId + "/games/" + game + "/stats", PlayerResults.class, new ApiCallback<>() {

            @Override
            public void onSuccess(PlayerResults result) {
                futureResults.complete(result);
            }

            @Override
            public void onFailure(ApiException exception) {
                futureResults.completeExceptionally(exception);
            }
        });

        try {
            return futureResults.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Failed to fetch player results for id: " + playerId, e);
        }
    }

    @Override
    public PlayerResults getLastResultsForGame(String playerId, String game, QueryParameters parameters) {
        CompletableFuture<PlayerResults> futureResults = new CompletableFuture<>();
        String url = FACEIT_DATA_API + "players/" + playerId + "/games/" + game + "/stats?" + parameters;
        QueryValidator validator = new QueryValidator();
        validator.addCheck("offset", param -> parameters.contains("limit"));
        validator.addCheck("offset", param -> param.matches("\\d+"));
        validator.addCheck(params -> {
            if (params.containsKey("offset")) {
                if (!params.containsKey("limit")) {
                    return false;
                }
                try {
                    int offset = Integer.parseInt(params.get("offset"));
                    int limit = Integer.parseInt(params.get("limit"));
                    return offset % limit == 0;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            return true;
        });

        validator.addCheck("limit", param -> Integer.parseInt(param) >= 0);
        validator.addCheck("limit", param -> param.matches("\\d+"));
        validator.addCheck(params -> {
            if (params.containsKey("limit")) {
                try {
                    int limit = Integer.parseInt(params.get("limit"));
                    return limit <= 100;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            return true;
        });

        if (!validator.validate(url)) {
            System.out.println("The URL is invalid: " + url);
            System.out.println(validator.getErrors());
            throw new IllegalArgumentException("Invalid query parameters: " + validator.getErrors());
        }

        apiClient.getBlocking(url, PlayerResults.class, new ApiCallback<>() {

            @Override
            public void onSuccess(PlayerResults result) {
                futureResults.complete(result);
            }

            @Override
            public void onFailure(ApiException exception) {
                futureResults.completeExceptionally(exception);
            }
        });

        try {
            return futureResults.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Failed to fetch player results for id: " + playerId, e);
        }
    }

    @Override
    public CompletableFuture<PlayerResults> getResultsForGameAsync(String playerId, String game, QueryParameters parameters) {
        String url = FACEIT_DATA_API + "players/" + playerId + "/games/" + game + "/stats?" + parameters;
        QueryValidator validator = new QueryValidator();
        validator.addCheck("offset", param -> parameters.contains("limit"));
        validator.addCheck("offset", param -> param.matches("\\d+"));
        validator.addCheck(params -> {
            if (params.containsKey("offset")) {
                if (!params.containsKey("limit")) {
                    return false;
                }
                try {
                    int offset = Integer.parseInt(params.get("offset"));
                    int limit = Integer.parseInt(params.get("limit"));
                    return offset % limit == 0;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            return true;
        });

        validator.addCheck("limit", param -> Integer.parseInt(param) >= 0);
        validator.addCheck("limit", param -> param.matches("\\d+"));
        validator.addCheck(params -> {
            if (params.containsKey("limit")) {
                try {
                    int limit = Integer.parseInt(params.get("limit"));
                    return limit <= 100;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            return true;
        });

        if (!validator.validate(url)) {
            System.out.println("The URL is invalid: " + url);
            System.out.println(validator.getErrors());
            throw new IllegalArgumentException("Invalid query parameters: " + validator.getErrors());
        }

        return apiClient.getAsync(url, PlayerResults.class);
    }

    @Override
    public CompletableFuture<PlayerResults> getResultsForGameAsync(String playerId, String game) {
        return apiClient.getAsync(FACEIT_DATA_API + "players/" + playerId + "/games/" + game + "/stats", PlayerResults.class);
    }

    @Override
    public PlayerBans getPlayerBans(String playerId) {
        CompletableFuture<PlayerBans> futureBans = new CompletableFuture<>();

        apiClient.getBlocking(FACEIT_DATA_API + "players/" + playerId + "/bans", PlayerBans.class, new ApiCallback<>() {

            @Override
            public void onSuccess(PlayerBans result) {
                futureBans.complete(result);
            }

            @Override
            public void onFailure(ApiException exception) {
                futureBans.completeExceptionally(exception);
            }
        });

        try {
            return futureBans.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Failed to fetch player bans for id: " + playerId, e);
        }
    }

    @Override
    public CompletableFuture<PlayerBans> getPlayerBansAsync(String playerId) {
        return apiClient.getAsync(FACEIT_DATA_API + "players/" + playerId + "/bans", PlayerBans.class);
    }
}
