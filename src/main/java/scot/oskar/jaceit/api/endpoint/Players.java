package scot.oskar.jaceit.api.endpoint;

import scot.oskar.jaceit.api.entity.*;
import scot.oskar.jaceit.api.request.QueryParameters;
import scot.oskar.jaceit.api.exception.DataFetchException;
import scot.oskar.jaceit.internal.entity.PlayerProfileImpl;
import scot.oskar.jaceit.internal.entity.PlayerResultsImpl;

import java.util.concurrent.CompletableFuture;

/**
 * Represents the players endpoint within the FACEIT Data API.
 * This interface defines the methods to access all endpoints provided in the API.
 * The implementation of this interface is provided by the {@link scot.oskar.jaceit.internal.endpoint.PlayersImpl} class.
 */
public interface Players {

    /**
     * Retrieves player account details by player ID.
     *
     * @param playerId the FACEIT player ID
     * @return a {@link PlayerProfileImpl} object containing the player's details, or null if the player does not exist
     * @throws DataFetchException if the request fails
     */
    PlayerProfile getDetailsById(String playerId);

    /**
     * Retrieves player account details by player ID asynchronously.
     *
     * @param playerId the FACEIT player ID
     * @return a {@link CompletableFuture} that will complete with a {@link PlayerProfileImpl} object containing the player's details, or null if the player does not exist
     */
    CompletableFuture<PlayerProfile> getDetailsByIdAsync(String playerId);

    /**
     * Retrieves player account details by player nickname with query parameters.
     *
     * @param nickname   the FACEIT player nickname
     * @param parameters the query parameters to be used in the request
     *                   Available parameters are:
     *                   game - A game on FACEIT
     *                   game_player_id - The ID of a player on the game's platform
     *                   see {@link QueryParameters}
     * @return a {@link PlayerProfileImpl} object containing the player's details, or null if the player does not exist
     * @throws DataFetchException if the request fails
     */
    PlayerProfile getDetailsByNickname(String nickname, QueryParameters parameters);

    /**
     * Retrieves player account details by player nickname.
     *
     * @param nickname the FACEIT player nickname
     * @return a {@link PlayerProfileImpl} object containing the player's details, or null if the player does not exist
     * @throws DataFetchException if the request fails
     */
    PlayerProfile getDetailsByNickname(String nickname);

    /**
     * Retrieves player account details by player nickname asynchronously with query parameters.
     *
     * @param nickname   the FACEIT player nickname
     * @param parameters the query parameters to be used in the request
     *                   Available parameters are:
     *                   game - A game on FACEIT
     *                   game_player_id - The ID of a player on the game's platform
     *                   see {@link QueryParameters}
     * @return a {@link CompletableFuture} that will complete with a {@link PlayerProfileImpl} object containing the player's details, or null if the player does not exist
     */
    CompletableFuture<PlayerProfile> getDetailsByNicknameAsync(String nickname, QueryParameters parameters);

    /**
     * Retrieves player account details by player nickname asynchronously.
     *
     * @param nickname the FACEIT player nickname
     * @return a {@link CompletableFuture} that will complete with a {@link PlayerProfileImpl} object containing the player's details, or null if the player does not exist
     */
    CompletableFuture<PlayerProfile> getDetailsByNicknameAsync(String nickname);

    /**
     * Retrieves player game results for the specified player ID and game.
     *
     * @param playerId the FACEIT player ID
     * @param game     the FACEIT game
     * @return a {@link PlayerResultsImpl} object containing the player's results, or null if the player does not exist
     * @throws DataFetchException if the request fails
     */
    PlayerResults getLastResultsForGame(String playerId, String game);

    /**
     * Retrieves player game results for the specified player ID and game with query parameters.
     *
     * @param playerId   the FACEIT player ID
     * @param game       the FACEIT game
     * @param parameters the query parameters to be used in the request
     *                   Available parameters are:
     *                   offset - The offset of the results
     *                   limit - The number of results to return
     * @return a {@link PlayerResultsImpl} object containing the player's results, or null if the player does not exist
     * @throws DataFetchException if the request fails
     */
    PlayerResults getLastResultsForGame(String playerId, String game, QueryParameters parameters);

    /**
     * Retrieves player game results for the specified player ID and game asynchronously with query parameters.
     *
     * @param playerId   the FACEIT player ID
     * @param game       the FACEIT game
     * @param parameters the query parameters to be used in the request
     *                   Available parameters are:
     *                   offset - The offset of the results
     *                   limit - The number of results to return
     * @return a {@link CompletableFuture} that will complete with a {@link PlayerResults} interface containing the player's results, or null if the player does not exist
     */
    CompletableFuture<PlayerResults> getResultsForGameAsync(String playerId, String game, QueryParameters parameters);

    /**
     * Retrieves player game results for the specified player ID and game asynchronously.
     *
     * @param playerId the FACEIT player ID
     * @param game     the FACEIT game
     * @return a {@link CompletableFuture} that will complete with a {@link PlayerResults} interface containing the player's results, or null if the player does not exist
     */
    CompletableFuture<PlayerResults> getResultsForGameAsync(String playerId, String game);

    /**
     * Retrieves player bans for the specified player ID.
     *
     * @param playerId the FACEIT player ID
     * @return a {@link PlayerBans} object containing the player's bans, or null if the player does not exist
     * @throws DataFetchException if the request fails
     */
    PlayerBans getPlayerBans(String playerId);

    /**
     * Retrieves player bans for the specified player ID asynchronously.
     *
     * @param playerId the FACEIT player ID
     * @return a {@link CompletableFuture} that will complete with a {@link PlayerBans} object containing the player's bans, or null if the player does not exist
     */
    CompletableFuture<PlayerBans> getPlayerBansAsync(String playerId);

    /**
     * Retrieves player match history for the specified player ID and game.
     *
     * @param playerId the FACEIT player ID
     * @param game     the FACEIT game
     * @return a {@link PlayerMatchHistory} object containing the player's match history, or null if the player does not exist
     * @throws DataFetchException if the request fails
     */
    PlayerMatchHistory getMatchHistory(String playerId, String game);

    /**
     * Retrieves player match history for the specified player ID and game with query parameters.
     *
     * @param playerId   the FACEIT player ID
     * @param game       the FACEIT game
     * @param parameters the query parameters to be used in the request
     *                   Available parameters are:
     *                   offset - The offset of the results
     *                   limit  - The number of results to return
     *                   from   - The start date of the results
     *                   to     - The end date of the results
     * @return a {@link PlayerMatchHistory} object containing the player's match history, or null if the player does not exist
     * @throws DataFetchException if the request fails
     */
    PlayerMatchHistory getMatchHistory(String playerId, String game, QueryParameters parameters);

    /**
     * Retrieves player hubs for the specified player ID.
     *
     * @param playerId the FACEIT player ID
     * @return a {@link PlayerHubs} object containing the player's hubs, or null if the player does not exist
     * @throws DataFetchException if the request fails
     */
    PlayerHubs getPlayerHubs(String playerId);

    /**
     * Retrieves player hubs for the specified player ID with query parameters.
     *
     * @param playerId   the FACEIT player ID
     * @param parameters the query parameters to be used in the request
     * @return a {@link PlayerHubs} object containing the player's hubs, or null if the player does not exist
     * @throws DataFetchException if the request fails
     */
    PlayerHubs getPlayerHubs(String playerId, QueryParameters parameters);
}