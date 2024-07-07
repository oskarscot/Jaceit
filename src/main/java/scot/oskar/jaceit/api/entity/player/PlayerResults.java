package scot.oskar.jaceit.api.entity.player;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import scot.oskar.jaceit.internal.entity.player.PlayerResultsImpl;

import java.util.List;

/**
 * Represents the structure of player results information.
 * This interface defines the methods to access the player's results.
 * The implementation class for this interface is {@link PlayerResultsImpl}.
 */
@JsonDeserialize(as = PlayerResultsImpl.class)
public interface PlayerResults {

    /**
     * Retrieves the list of stats associated with the player results.
     *
     * @return a list of {@link Stats} instances representing the player's stats.
     */
    List<Stats> getStats();

    /**
     * Retrieves the offset for the results.
     *
     * @return an integer representing the offset.
     */
    int getOffset();

    /**
     * Retrieves the limit for the results.
     *
     * @return an integer representing the limit.
     */
    int getLimit();

    /**
     * Represents the stats associated with the player results.
     * This interface defines the methods to access the stats details.
     * The implementation class for this interface is {@link PlayerResultsImpl.StatsImpl}.
     */
    @JsonDeserialize(as = PlayerResultsImpl.StatsImpl.class)
    interface Stats {

        /**
         * Retrieves the game mode.
         *
         * @return a string representing the game mode.
         */
        String getGameMode();

        /**
         * Retrieves the number of flash successes.
         *
         * @return a string representing the flash successes.
         */
        String getFlashSuccesses();

        /**
         * Retrieves the match ID.
         *
         * @return a string representing the match ID.
         */
        String getMatchId();

        /**
         * Retrieves the number of Zeus kills.
         *
         * @return a string representing the Zeus kills.
         */
        String getZeusKills();

        /**
         * Retrieves the player's nickname.
         *
         * @return a string representing the nickname.
         */
        String getNickname();

        /**
         * Retrieves the overtime score.
         *
         * @return a string representing the overtime score.
         */
        String getOvertimeScore();

        /**
         * Retrieves the second half score.
         *
         * @return a string representing the second half score.
         */
        String getSecondHalfScore();

        /**
         * Retrieves the number of penta kills.
         *
         * @return a string representing the penta kills.
         */
        String getPentaKills();

        /**
         * Retrieves the number of headshots.
         *
         * @return a string representing the headshots.
         */
        String getHeadshots();

        /**
         * Retrieves the match round.
         *
         * @return a string representing the match round.
         */
        String getMatchRound();

        /**
         * Retrieves the final score.
         *
         * @return a string representing the final score.
         */
        String getFinalScore();

        /**
         * Retrieves the number of rounds.
         *
         * @return a string representing the rounds.
         */
        String getRounds();

        /**
         * Retrieves the player's ID.
         *
         * @return a string representing the player ID.
         */
        String getPlayerId();

        /**
         * Retrieves the number of clutch kills.
         *
         * @return a string representing the clutch kills.
         */
        String getClutchKills();

        /**
         * Retrieves the number of one-v-one wins.
         *
         * @return a string representing the one-v-one wins.
         */
        String getOneVoneWins();

        /**
         * Retrieves the number of pistol kills.
         *
         * @return a string representing the pistol kills.
         */
        String getPistolKills();

        /**
         * Retrieves the number of knife kills.
         *
         * @return a string representing the knife kills.
         */
        String getKnifeKills();

        /**
         * Retrieves the number of double kills.
         *
         * @return a string representing the double kills.
         */
        String getDoubleKills();

        /**
         * Retrieves the game.
         *
         * @return a string representing the game.
         */
        String getGame();

        /**
         * Retrieves the first half score.
         *
         * @return a string representing the first half score.
         */
        String getFirstHalfScore();

        /**
         * Retrieves the result.
         *
         * @return a string representing the result.
         */
        String getResult();

        /**
         * Retrieves the utility damage.
         *
         * @return a string representing the utility damage.
         */
        String getUtilityDamage();

        /**
         * Retrieves the score.
         *
         * @return a string representing the score.
         */
        String getScore();

        /**
         * Retrieves the one-v-two count.
         *
         * @return a string representing the one-v-two count.
         */
        String getOneVtwoCount();

        /**
         * Retrieves the kill-death ratio (KD ratio).
         *
         * @return a string representing the KD ratio.
         */
        String getKdRatio();

        /**
         * Retrieves the number of one-v-two wins.
         *
         * @return a string representing the one-v-two wins.
         */
        String getOneVtwoWins();

        /**
         * Retrieves the headshots percentage.
         *
         * @return a string representing the headshots percentage.
         */
        String getHeadshotsPercentage();

        /**
         * Retrieves the number of assists.
         *
         * @return a string representing the assists.
         */
        String getAssists();

        /**
         * Retrieves the number of triple kills.
         *
         * @return a string representing the triple kills.
         */
        String getTripleKills();

        /**
         * Retrieves the kill-round ratio (KR ratio).
         *
         * @return a string representing the KR ratio.
         */
        String getKrRatio();

        /**
         * Retrieves the last updated time.
         *
         * @return a string representing the updated time.
         */
        String getUpdatedAt();

        /**
         * Retrieves the number of enemies flashed.
         *
         * @return a string representing the enemies flashed.
         */
        String getEnemiesFlashed();

        /**
         * Retrieves the number of deaths.
         *
         * @return a string representing the deaths.
         */
        String getDeaths();

        /**
         * Retrieves the utility count.
         *
         * @return a string representing the utility count.
         */
        String getUtilityCount();

        /**
         * Retrieves the winner.
         *
         * @return a string representing the winner.
         */
        String getWinner();

        /**
         * Retrieves the number of first kills.
         *
         * @return a string representing the first kills.
         */
        String getFirstKills();

        /**
         * Retrieves the best of rounds.
         *
         * @return a string representing the best of rounds.
         */
        String getBestOf();

        /**
         * Retrieves the damage dealt.
         *
         * @return a string representing the damage.
         */
        String getDamage();

        /**
         * Retrieves the team.
         *
         * @return a string representing the team.
         */
        String getTeam();

        /**
         * Retrieves the number of quadro kills.
         *
         * @return a string representing the quadro kills.
         */
        String getQuadroKills();

        /**
         * Retrieves the number of entry wins.
         *
         * @return a string representing the entry wins.
         */
        String getEntryWins();

        /**
         * Retrieves the number of kills.
         *
         * @return a string representing the kills.
         */
        String getKills();

        /**
         * Retrieves the number of MVPs.
         *
         * @return a string representing the MVPs.
         */
        String getMvps();

        /**
         * Retrieves the number of utility enemies.
         *
         * @return a string representing the utility enemies.
         */
        String getUtilityEnemies();

        /**
         * Retrieves the number of entry attempts.
         *
         * @return a string representing the entry attempts.
         */
        String getEntryCount();

        /**
         * Retrieves the number of flash attempts.
         *
         * @return a string representing the flash attempts.
         */
        String getFlashCount();

        /**
         * Retrieves the region.
         *
         * @return a string representing the region.
         */
        String getRegion();

        /**
         * Retrieves the number of utility successes.
         *
         * @return a string representing the utility successes.
         */
        String getUtilitySuccesses();

        /**
         * Retrieves the creation date.
         *
         * @return a string representing the creation date.
         */
        String getCreatedAt();

        /**
         * Retrieves the map.
         *
         * @return a string representing the map.
         */
        String getMap();

        /**
         * Retrieves the average damage per round (ADR).
         *
         * @return a string representing the ADR.
         */
        String getADR();

        /**
         * Retrieves the competition ID.
         *
         * @return a string representing the competition ID.
         */
        String getCompetitionId();

        /**
         * Retrieves the number of sniper kills.
         *
         * @return a string representing the sniper kills.
         */
        String getSniperKills();

        /**
         * Retrieves the number of one-v-one attempts.
         *
         * @return a string representing the one-v-one attempts.
         */
        String getOneVoneCount();
    }
}