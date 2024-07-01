package scot.oskar.jaceit.internal.endpoint;

import scot.oskar.jaceit.api.endpoint.Players;
import scot.oskar.jaceit.api.entity.PlayerProfile;
import scot.oskar.jaceit.api.exception.ApiException;
import scot.oskar.jaceit.api.request.ApiCallback;
import scot.oskar.jaceit.api.request.ApiClient;
import scot.oskar.jaceit.api.request.QueryParameters;

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
}
