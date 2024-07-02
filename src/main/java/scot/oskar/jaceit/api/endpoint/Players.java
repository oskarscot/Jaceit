package scot.oskar.jaceit.api.endpoint;

import scot.oskar.jaceit.api.entity.PlayerProfile;
import scot.oskar.jaceit.api.entity.PlayerResults;
import scot.oskar.jaceit.api.request.QueryParameters;

import java.util.concurrent.CompletableFuture;

public interface Players {

    PlayerProfile getDetailsById(String number);
    CompletableFuture<PlayerProfile> getDetailsByIdAsync(String number);

    PlayerProfile getDetailsByNickname(String nickname, QueryParameters parameters);
    PlayerProfile getDetailsByNickname(String nickname);
    CompletableFuture<PlayerProfile> getDetailsByNicknameAsync(String nickname, QueryParameters parameters);
    CompletableFuture<PlayerProfile> getDetailsByNicknameAsync(String nickname);


    PlayerResults getLastResultsForGame(String playerId, String game, QueryParameters parameters);
}
