package scot.oskar.jaceit.api.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import scot.oskar.jaceit.internal.entity.PlayerMatchHistoryImpl;

import java.util.List;
import java.util.Map;

/**
 * Represents the structure of a response containing a player's match history.
 * This interface defines the methods to access the details of the matches included in the response.
 * The implementation class for this interface is {@link PlayerMatchHistoryImpl}.
 */
@JsonDeserialize(as = PlayerMatchHistoryImpl.class)
public interface PlayerMatchHistory {

    /**
     * Retrieves the list of matches in the player's history.
     *
     * @return a list of {@link Match} instances.
     */
    List<Match> getMatches();

    /**
     * Retrieves the offset for the list of matches.
     *
     * @return an integer representing the offset.
     */
    int getOffset();

    /**
     * Retrieves the limit on the number of matches returned.
     *
     * @return an integer representing the limit.
     */
    int getLimit();

    /**
     * Retrieves the start timestamp for the match history query.
     *
     * @return an integer representing the start timestamp.
     */
    int getFrom();

    /**
     * Retrieves the end timestamp for the match history query.
     *
     * @return an integer representing the end timestamp.
     */
    int getTo();

    /**
     * Represents the details of an individual match in the player's history.
     * This interface defines the methods to access the properties of a match.
     * The implementation class for this interface is {@link PlayerMatchHistoryImpl.MatchImpl}.
     */
    @JsonDeserialize(as = PlayerMatchHistoryImpl.MatchImpl.class)
    interface Match {
        /**
         * Retrieves the match ID.
         *
         * @return a string representing the match ID.
         */
        String getMatchId();

        /**
         * Retrieves the game ID associated with the match.
         *
         * @return a string representing the game ID.
         */
        String getGameId();

        /**
         * Retrieves the region where the match took place.
         *
         * @return a string representing the region.
         */
        String getRegion();

        /**
         * Retrieves the type of match.
         *
         * @return a string representing the match type.
         */
        String getMatchType();

        /**
         * Retrieves the game mode of the match.
         *
         * @return a string representing the game mode.
         */
        String getGameMode();

        /**
         * Retrieves the maximum number of players in the match.
         *
         * @return an integer representing the maximum number of players.
         */
        int getMaxPlayers();

        /**
         * Retrieves the size of the teams in the match.
         *
         * @return an integer representing the teams' size.
         */
        int getTeamsSize();

        /**
         * Retrieves the teams that participated in the match.
         *
         * @return a map where the key is the team identifier and the value is the {@link Team} instance.
         */
        Map<String, Team> getTeams();

        /**
         * Retrieves the list of players who played in the match.
         *
         * @return a list of strings representing the player IDs.
         */
        List<String> getPlayingPlayers();

        /**
         * Retrieves the competition ID associated with the match.
         *
         * @return a string representing the competition ID.
         */
        String getCompetitionId();

        /**
         * Retrieves the name of the competition.
         *
         * @return a string representing the competition name.
         */
        String getCompetitionName();

        /**
         * Retrieves the type of competition.
         *
         * @return a string representing the competition type.
         */
        String getCompetitionType();

        /**
         * Retrieves the organizer ID of the competition.
         *
         * @return a string representing the organizer ID.
         */
        String getOrganizerId();

        /**
         * Retrieves the status of the match.
         *
         * @return a string representing the status.
         */
        String getStatus();

        /**
         * Retrieves the start time of the match.
         *
         * @return a long representing the start time in milliseconds since epoch.
         */
        long getStartedAt();

        /**
         * Retrieves the end time of the match.
         *
         * @return a long representing the end time in milliseconds since epoch.
         */
        long getFinishedAt();

        /**
         * Retrieves the results of the match.
         *
         * @return a {@link Results} instance representing the match results.
         */
        Results getResults();

        /**
         * Retrieves the URL to the match on Faceit.
         *
         * @return a string representing the Faceit URL.
         */
        String getFaceitUrl();

        /**
         * Represents the results of a match.
         * This interface defines the methods to access the properties of the match results.
         * The implementation class for this interface is {@link PlayerMatchHistoryImpl.MatchImpl.ResultsImpl}.
         */
        @JsonDeserialize(as = PlayerMatchHistoryImpl.MatchImpl.ResultsImpl.class)
        interface Results {
            /**
             * Retrieves the ID of the winning team.
             *
             * @return a string representing the winner's team ID.
             */
            String getWinner();

            /**
             * Retrieves the score of the match.
             *
             * @return a {@link Score} instance representing the match score.
             */
            Score getScore();

            /**
             * Represents the score of a match.
             * This interface defines the methods to access the properties of the score.
             * The implementation class for this interface is {@link PlayerMatchHistoryImpl.MatchImpl.ResultsImpl.ScoreImpl}.
             */
            @JsonDeserialize(as = PlayerMatchHistoryImpl.MatchImpl.ResultsImpl.ScoreImpl.class)
            interface Score {
                /**
                 * Retrieves the score of the first faction.
                 *
                 * @return an integer representing the first faction's score.
                 */
                int getFaction1();

                /**
                 * Retrieves the score of the second faction.
                 *
                 * @return an integer representing the second faction's score.
                 */
                int getFaction2();
            }
        }

        /**
         * Represents a team participating in a match.
         * This interface defines the methods to access the properties of a team.
         * The implementation class for this interface is {@link PlayerMatchHistoryImpl.MatchImpl.TeamImpl}.
         */
        @JsonDeserialize(as = PlayerMatchHistoryImpl.MatchImpl.TeamImpl.class)
        interface Team {
            /**
             * Retrieves the team ID.
             *
             * @return a string representing the team ID.
             */
            String getTeamId();

            /**
             * Retrieves the team's nickname.
             *
             * @return a string representing the team's nickname.
             */
            String getNickname();

            /**
             * Retrieves the URL of the team's avatar.
             *
             * @return a string representing the avatar URL.
             */
            String getAvatar();

            /**
             * Retrieves the type of the team.
             *
             * @return a string representing the team type.
             */
            String getType();

            /**
             * Retrieves the list of players in the team.
             *
             * @return a list of {@link Player} instances representing the team's players.
             */
            List<Player> getPlayers();
        }

        /**
         * Represents a player participating in a match.
         * This interface defines the methods to access the properties of a player.
         * The implementation class for this interface is {@link PlayerMatchHistoryImpl.MatchImpl.PlayerImpl}.
         */
        @JsonDeserialize(as = PlayerMatchHistoryImpl.MatchImpl.PlayerImpl.class)
        interface Player {
            /**
             * Retrieves the player ID.
             *
             * @return a string representing the player ID.
             */
            String getPlayerId();

            /**
             * Retrieves the player's nickname.
             *
             * @return a string representing the player's nickname.
             */
            String getNickname();

            /**
             * Retrieves the URL of the player's avatar.
             *
             * @return a string representing the avatar URL.
             */
            String getAvatar();

            /**
             * Retrieves the player's skill level.
             *
             * @return an integer representing the skill level.
             */
            int getSkillLevel();

            /**
             * Retrieves the game-specific player ID.
             *
             * @return a string representing the game-specific player ID.
             */
            String getGamePlayerId();

            /**
             * Retrieves the game-specific player name.
             *
             * @return a string representing the game-specific player name.
             */
            String getGamePlayerName();

            /**
             * Retrieves the URL to the player's profile on Faceit.
             *
             * @return a string representing the Faceit profile URL.
             */
            String getFaceitUrl();
        }
    }
}