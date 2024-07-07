package scot.oskar.jaceit.api.endpoint;

import scot.oskar.jaceit.api.entity.*;
import scot.oskar.jaceit.api.request.QueryParameters;
import scot.oskar.jaceit.internal.entity.PlayerProfileImpl;
import scot.oskar.jaceit.internal.entity.PlayerResultsImpl;

import java.util.concurrent.CompletableFuture;

/**
 * Represents the players endpoint within the FACEIT Data API
 * This interface defines the methods to access all endpoints provided in the API.
 * The implementation of this interface is provided by the {@link scot.oskar.jaceit.internal.endpoint.PlayersImpl} class
 */
public interface Players {

    /**
     * Retrieves player account details by player id
     *
     * @param playerId is the FACEIT player id
     * @return a {@link PlayerProfileImpl} object containing the player's details or null if the player does not exist
     */
    PlayerProfile getDetailsById(String playerId);

    /**
     * Retrieves player account details by player id
     *
     * @param playerId is the FACEIT player id
     * @return a {@link CompletableFuture} that will complete with a
     * {@link PlayerProfileImpl} object containing the player's details or null if the player does not exist
     */
    CompletableFuture<PlayerProfile> getDetailsByIdAsync(String playerId);

    /**
     * Retrieves player account details by player nickname
     *
     * @param nickname   is the faceit player nickname
     * @param parameters are the query parameters to be used in the request
     *                   Available parameters are:
     *                   game - A game on FACEIT
     *                   game_player_id - The ID of a player on game's platform
     *                   see {@link QueryParameters}
     * @return a {@link PlayerProfileImpl} object containing the player's details or null if the player does not exist
     */
    PlayerProfile getDetailsByNickname(String nickname, QueryParameters parameters);

    /**
     * Retrieves player account details by player nickname
     *
     * @param nickname is the FACEIT player nickname
     * @return a {@link PlayerProfileImpl} object containing the player's details or null if the player does not exist
     */
    PlayerProfile getDetailsByNickname(String nickname);

    /**
     * Retrieves player account details by player nickname
     *
     * @param nickname   is the FACEIT player nickname
     * @param parameters are the query parameters to be used in the request
     *                   Available parameters are:
     *                   game - A game on FACEIT
     *                   game_player_id - The ID of a player on game's platform
     *                   see {@link QueryParameters}
     * @return a {@link CompletableFuture} that will complete
     * with a {@link PlayerProfileImpl} object containing the player's details or null if the player does not exist
     */
    CompletableFuture<PlayerProfile> getDetailsByNicknameAsync(String nickname, QueryParameters parameters);

    /**
     * Retrieves player account details by player nickname
     *
     * @param nickname is the FACEIT player nickname
     * @return a {@link CompletableFuture} that will complete
     * with a {@link PlayerProfileImpl} object containing the player's details or null if the player does not exist
     */
    CompletableFuture<PlayerProfile> getDetailsByNicknameAsync(String nickname);

    /**
     * Retrieves player game results for the specified playerid and game
     *
     * @param playerId is the FACEIT player id
     * @param game     is the FACEIT game
     * @return a {@link PlayerResultsImpl} object containing the player's results or null if the player does not exist
     */
    PlayerResults getLastResultsForGame(String playerId, String game);

    /**
     * @param playerId
     * @param game
     * @param parameters
     * @return
     */
    PlayerResults getLastResultsForGame(String playerId, String game, QueryParameters parameters);

    /**
     * @param playerId
     * @param game
     * @param parameters
     * @return
     */
    CompletableFuture<PlayerResults> getResultsForGameAsync(String playerId, String game, QueryParameters parameters);

    /**
     * @param playerId
     * @param game
     * @return
     */
    CompletableFuture<PlayerResults> getResultsForGameAsync(String playerId, String game);

    /**
     *
     * @param playerId
     * @return
     */
    PlayerBans getPlayerBans(String playerId);

    /**
     *
     * @param playerId
     * @return
     */
    CompletableFuture<PlayerBans> getPlayerBansAsync(String playerId);

    /**
     *
     * @param playerId
     * @param game
     * @return
     */
    PlayerMatchHistory getMatchHistory(String playerId, String game);

    /**
     *
     * @param playerId
     * @param game
     * @param parameters
     * @return
     */
    PlayerMatchHistory getMatchHistory(String playerId, String game, QueryParameters parameters);

    /**
     *
     * @param playerId
     * @return
     */
    PlayerHubs getPlayerHubs(String playerId);

    /**
     *
     * @param playerId
     * @param parameters
     * @return
     */
    PlayerHubs getPlayerHubs(String playerId, QueryParameters parameters);
}
