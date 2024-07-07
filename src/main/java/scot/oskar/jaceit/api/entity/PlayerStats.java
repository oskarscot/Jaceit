package scot.oskar.jaceit.api.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import scot.oskar.jaceit.internal.entity.PlayerStatsImpl;

import java.util.List;

/**
 * Represents the structure of player statistics information.
 * This interface defines the methods to access the player statistics.
 * The implementation class for this interface is {@link PlayerStatsImpl}.
 */
@JsonDeserialize(as = PlayerStatsImpl.class)
public interface PlayerStats {

    /**
     * Retrieves the player ID.
     *
     * @return a string representing the player ID.
     */
    String getPlayerId();

    /**
     * Retrieves the game ID.
     *
     * @return a string representing the game ID.
     */
    String getGameId();

    /**
     * Retrieves the lifetime statistics of the player.
     *
     * @return a {@link LifetimeStats} instance representing the lifetime stats of the player.
     */
    LifetimeStats getLifetime();

    /**
     * Retrieves the list of map segments with associated statistics.
     *
     * @return a list of {@link MapStats} instances representing the map segments.
     */
    List<MapStats> getSegments();

    /**
     * Represents the lifetime statistics of the player.
     * This interface defines the methods to access lifetime statistics details.
     * The implementation class for this interface is {@link PlayerStatsImpl.LifetimeStatsImpl}.
     */
    @JsonDeserialize(as = PlayerStatsImpl.LifetimeStatsImpl.class)
    interface LifetimeStats {

        /**
         * Retrieves the total number of utility successes.
         *
         * @return a string representing the total number of utility successes.
         */
        String getTotalUtilitySuccesses();

        /**
         * Retrieves the total number of utilities used.
         *
         * @return a string representing the total number of utility counts.
         */
        String getTotalUtilityCount();

        /**
         * Retrieves the average damage per round.
         *
         * @return a string representing the average damage per round (ADR).
         */
        String getAdr();

        /**
         * Retrieves the total number of flashes used.
         *
         * @return a string representing the total number of flash counts.
         */
        String getTotalFlashCount();

        /**
         * Retrieves the utility success rate.
         *
         * @return a string representing the utility success rate.
         */
        String getUtilitySuccessRate();

        /**
         * Retrieves the utility damage success rate.
         *
         * @return a string representing the utility damage success rate.
         */
        String getUtilityDamageSuccessRate();

        /**
         * Retrieves the number of enemies flashed per round.
         *
         * @return a string representing the enemies flashed per round.
         */
        String getEnemiesFlashedPerRound();

        /**
         * Retrieves the total number of entry wins.
         *
         * @return a string representing the total number of entry wins.
         */
        String getTotalEntryWins();

        /**
         * Retrieves the utility usage per round.
         *
         * @return a string representing the utility usage per round.
         */
        String getUtilityUsagePerRound();

        /**
         * Retrieves the recent results.
         *
         * @return a list of strings representing recent results.
         */
        List<String> getRecentResults();

        /**
         * Retrieves the total number of 1v1 wins.
         *
         * @return a string representing the total number of 1v1 wins.
         */
        String getTotal1v1Wins();

        /**
         * Retrieves the total damage dealt.
         *
         * @return a string representing the total damage dealt.
         */
        String getTotalDamage();

        /**
         * Retrieves the entry rate.
         *
         * @return a string representing the entry rate.
         */
        String getEntryRate();

        /**
         * Retrieves the total rounds with extended stats.
         *
         * @return a string representing the total rounds with extended stats.
         */
        String getTotalRoundsWithExtendedStats();

        /**
         * Retrieves the 1v1 win rate.
         *
         * @return a string representing the 1v1 win rate.
         */
        String get1v1WinRate();

        /**
         * Retrieves the utility damage per round.
         *
         * @return a string representing the utility damage per round.
         */
        String getUtilityDamagePerRound();

        /**
         * Retrieves the average K/D ratio.
         *
         * @return a string representing the average K/D ratio.
         */
        String getAverageKdRatio();

        /**
         * Retrieves the total number of kills with extended stats.
         *
         * @return a string representing the total number of kills with extended stats.
         */
        String getTotalKillsWithExtendedStats();

        /**
         * Retrieves the total number of 1v1 counts.
         *
         * @return a string representing the total number of 1v1 counts.
         */
        String getTotal1v1Count();

        /**
         * Retrieves the current win streak.
         *
         * @return a string representing the current win streak.
         */
        String getCurrentWinStreak();

        /**
         * Retrieves the total number of sniper kills.
         *
         * @return a string representing the total number of sniper kills.
         */
        String getTotalSniperKills();

        /**
         * Retrieves the entry success rate.
         *
         * @return a string representing the entry success rate.
         */
        String getEntrySuccessRate();

        /**
         * Retrieves the total number of 1v2 wins.
         *
         * @return a string representing the total number of 1v2 wins.
         */
        String getTotal1v2Wins();

        /**
         * Retrieves the sniper kill rate.
         *
         * @return a string representing the sniper kill rate.
         */
        String getSniperKillRate();

        /**
         * Retrieves the total number of enemies flashed.
         *
         * @return a string representing the total number of enemies flashed.
         */
        String getTotalEnemiesFlashed();

        /**
         * Retrieves the average headshots percentage.
         *
         * @return a string representing the average headshots percentage.
         */
        String getAverageHeadshotsPercentage();

        /**
         * Retrieves the total utility damage.
         *
         * @return a string representing the total utility damage.
         */
        String getTotalUtilityDamage();

        /**
         * Retrieves the total entry count.
         *
         * @return a string representing the total entry count.
         */
        String getTotalEntryCount();

        /**
         * Retrieves the flashes per round.
         *
         * @return a string representing the flashes per round.
         */
        String getFlashesPerRound();

        /**
         * Retrieves the total number of 1v2 counts.
         *
         * @return a string representing the total number of 1v2 counts.
         */
        String getTotal1v2Count();

        /**
         * Retrieves the total number of wins.
         *
         * @return a string representing the total number of wins.
         */
        String getWins();

        /**
         * Retrieves the total number of matches.
         *
         * @return a string representing the total number of matches.
         */
        String getTotalMatches();

        /**
         * Retrieves the flash success rate.
         *
         * @return a string representing the flash success rate.
         */
        String getFlashSuccessRate();

        /**
         * Retrieves the win rate percentage.
         *
         * @return a string representing the win rate percentage.
         */
        String getWinRatePercentage();

        /**
         * Retrieves the K/D ratio.
         *
         * @return a string representing the K/D ratio.
         */
        String getKdRatio();

        /**
         * Retrieves the total number of flash successes.
         *
         * @return a string representing the total number of flash successes.
         */
        String getTotalFlashSuccesses();

        /**
         * Retrieves the total number of matches.
         *
         * @return a string representing the total number of matches.
         */
        String getMatches();

        /**
         * Retrieves the total number of headshots percentage.
         *
         * @return a string representing the total number of headshots percentage.
         */
        String getTotalHeadshotsPercentage();

        /**
         * Retrieves the longest win streak.
         *
         * @return a string representing the longest win streak.
         */
        String getLongestWinStreak();

        /**
         * Retrieves the sniper kill rate per round.
         *
         * @return a string representing the sniper kill rate per round.
         */
        String getSniperKillRatePerRound();

        /**
         * Retrieves the 1v2 win rate.
         *
         * @return a string representing the 1v2 win rate.
         */
        String get1v2WinRate();
    }

    /**
     * Represents a map segment with associated statistics.
     * This interface defines the methods to access map segment details.
     * The implementation class for this interface is {@link PlayerStatsImpl.MapStatsImpl}.
     */
    @JsonDeserialize(as = PlayerStatsImpl.MapStatsImpl.class)
    interface MapStats {

        /**
         * Retrieves the label of the map segment.
         *
         * @return a string representing the label of the map segment.
         */
        String getLabel();

        /**
         * Retrieves the small image URL of the map segment.
         *
         * @return a string representing the small image URL of the map segment.
         */
        String getImgSmall();

        /**
         * Retrieves the regular image URL of the map segment.
         *
         * @return a string representing the regular image URL of the map segment.
         */
        String getImgRegular();

        /**
         * Retrieves the statistics for the map segment.
         *
         * @return a map where the key is a statistic name and the value is the corresponding statistic value.
         */
        Stats getStats();

        /**
         * Retrieves the type of the map segment.
         *
         * @return a string representing the type of the map segment.
         */
        String getType();

        /**
         * Retrieves the mode of the map segment.
         *
         * @return a string representing the mode of the map segment.
         */
        String getMode();

        /**
         * Represents the player statistics for a game.
         * This interface defines the methods to access various player statistics.
         * The implementation class for this interface is {@link PlayerStatsImpl}.
         */
        @JsonDeserialize(as = PlayerStatsImpl.MapStatsImpl.StatsImpl.class)
        interface Stats {

            /**
             * Retrieves the Sniper Kill Rate of the player.
             *
             * @return a string representing the Sniper Kill Rate.
             */
            String getSniperKillRate();

            /**
             * Retrieves the total number of 1v2 Wins.
             *
             * @return a string representing the total 1v2 Wins.
             */
            String getTotal1v2Wins();

            /**
             * Retrieves the number of Assists.
             *
             * @return a string representing the number of Assists.
             */
            String getAssists();

            /**
             * Retrieves the total number of Flash Successes.
             *
             * @return a string representing the total Flash Successes.
             */
            String getTotalFlashSuccesses();

            /**
             * Retrieves the average number of Triple Kills.
             *
             * @return a string representing the average Triple Kills.
             */
            String getAverageTripleKills();

            /**
             * Retrieves the total number of Triple Kills.
             *
             * @return a string representing the total Triple Kills.
             */
            String getTripleKills();

            /**
             * Retrieves the total number of Kills.
             *
             * @return a string representing the total Kills.
             */
            String getKills();

            /**
             * Retrieves the total number of Deaths.
             *
             * @return a string representing the total Deaths.
             */
            String getDeaths();

            /**
             * Retrieves the total number of rounds with extended stats.
             *
             * @return a string representing the total number of rounds with extended stats.
             */
            String getTotalRoundsWithExtendedStats();

            /**
             * Retrieves the Average Damage per Round (ADR).
             *
             * @return a string representing the ADR.
             */
            String getADR();

            /**
             * Retrieves the Utility Damage Success Rate.
             *
             * @return a string representing the Utility Damage Success Rate.
             */
            String getUtilityDamageSuccessRate();

            /**
             * Retrieves the 1v2 Win Rate.
             *
             * @return a string representing the 1v2 Win Rate.
             */
            String get1v2WinRate();

            /**
             * Retrieves the Utility Damage per Round.
             *
             * @return a string representing the Utility Damage per Round.
             */
            String getUtilityDamagePerRound();

            /**
             * Retrieves the total number of Entry Counts.
             *
             * @return a string representing the total Entry Counts.
             */
            String getTotalEntryCount();

            /**
             * Retrieves the Entry Success Rate.
             *
             * @return a string representing the Entry Success Rate.
             */
            String getEntrySuccessRate();

            /**
             * Retrieves the Entry Rate.
             *
             * @return a string representing the Entry Rate.
             */
            String getEntryRate();

            /**
             * Retrieves the Sniper Kill Rate per Round.
             *
             * @return a string representing the Sniper Kill Rate per Round.
             */
            String getSniperKillRatePerRound();

            /**
             * Retrieves the average number of Deaths.
             *
             * @return a string representing the average number of Deaths.
             */
            String getAverageDeaths();

            /**
             * Retrieves the total number of Sniper Kills.
             *
             * @return a string representing the total Sniper Kills.
             */
            String getTotalSniperKills();

            /**
             * Retrieves the Utility Success Rate.
             *
             * @return a string representing the Utility Success Rate.
             */
            String getUtilitySuccessRate();

            /**
             * Retrieves the total number of Matches played.
             *
             * @return a string representing the total number of Matches played.
             */
            String getTotalMatches();

            /**
             * Retrieves the average Kill-to-Death Ratio (K/D Ratio).
             *
             * @return a string representing the average K/D Ratio.
             */
            String getAverageKDRatio();

            /**
             * Retrieves the average number of Quadro Kills.
             *
             * @return a string representing the average number of Quadro Kills.
             */
            String getAverageQuadroKills();

            /**
             * Retrieves the total Damage dealt.
             *
             * @return a string representing the total Damage.
             */
            String getTotalDamage();

            /**
             * Retrieves the total number of 1v1 Counts.
             *
             * @return a string representing the total 1v1 Counts.
             */
            String getTotal1v1Count();

            /**
             * Retrieves the number of MVPs.
             *
             * @return a string representing the number of MVPs.
             */
            String getMVPs();

            /**
             * Retrieves the total number of Kills with extended stats.
             *
             * @return a string representing the total Kills with extended stats.
             */
            String getTotalKillsWithExtendedStats();

            /**
             * Retrieves the total number of Utility Successes.
             *
             * @return a string representing the total Utility Successes.
             */
            String getTotalUtilitySuccesses();

            /**
             * Retrieves the total number of Enemies Flashed.
             *
             * @return a string representing the total Enemies Flashed.
             */
            String getTotalEnemiesFlashed();

            /**
             * Retrieves the total number of Quadro Kills.
             *
             * @return a string representing the total Quadro Kills.
             */
            String getQuadroKills();

            /**
             * Retrieves the average Kill-to-Round Ratio (K/R Ratio).
             *
             * @return a string representing the average K/R Ratio.
             */
            String getAverageKRRatio();

            /**
             * Retrieves the Flash Success Rate.
             *
             * @return a string representing the Flash Success Rate.
             */
            String getFlashSuccessRate();

            /**
             * Retrieves the total number of 1v1 Wins.
             *
             * @return a string representing the total 1v1 Wins.
             */
            String getTotal1v1Wins();

            /**
             * Retrieves the number of Wins.
             *
             * @return a string representing the number of Wins.
             */
            String getWins();

            /**
             * Retrieves the total number of Matches.
             *
             * @return a string representing the total number of Matches.
             */
            String getMatches();

            /**
             * Retrieves the total number of Rounds played.
             *
             * @return a string representing the total Rounds.
             */
            String getRounds();

            /**
             * Retrieves the Utility Usage per Round.
             *
             * @return a string representing the Utility Usage per Round.
             */
            String getUtilityUsagePerRound();

            /**
             * Retrieves the total number of 1v2 Counts.
             *
             * @return a string representing the total 1v2 Counts.
             */
            String getTotal1v2Count();

            /**
             * Retrieves the total number of Flash Counts.
             *
             * @return a string representing the total Flash Counts.
             */
            String getTotalFlashCount();

            /**
             * Retrieves the Kill-to-Round Ratio (K/R Ratio).
             *
             * @return a string representing the K/R Ratio.
             */
            String getKRRatio();

            /**
             * Retrieves the number of Flashes per Round.
             *
             * @return a string representing the Flashes per Round.
             */
            String getFlashesPerRound();

            /**
             * Retrieves the number of Enemies Flashed per Round.
             *
             * @return a string representing the Enemies Flashed per Round.
             */
            String getEnemiesFlashedPerRound();

            /**
             * Retrieves the K/D Ratio.
             *
             * @return a string representing the K/D Ratio.
             */
            String getKDRatio();

            /**
             * Retrieves the average number of Kills.
             *
             * @return a string representing the average number of Kills.
             */
            String getAverageKills();

            /**
             * Retrieves the average number of Headshots per Match.
             *
             * @return a string representing the average number of Headshots per Match.
             */
            String getHeadshotsPerMatch();

            /**
             * Retrieves the average number of Penta Kills.
             *
             * @return a string representing the average number of Penta Kills.
             */
            String getAveragePentaKills();

            /**
             * Retrieves the total number of Entry Wins.
             *
             * @return a string representing the total Entry Wins.
             */
            String getTotalEntryWins();

            /**
             * Retrieves the total Utility Damage.
             *
             * @return a string representing the total Utility Damage.
             */
            String getTotalUtilityDamage();

            /**
             * Retrieves the average number of Assists.
             *
             * @return a string representing the average number of Assists.
             */
            String getAverageAssists();

            /**
             * Retrieves the total number of Utility Counts.
             *
             * @return a string representing the total Utility Counts.
             */
            String getTotalUtilityCount();

            /**
             * Retrieves the average number of MVPs.
             *
             * @return a string representing the average number of MVPs.
             */
            String getAverageMVPs();

            /**
             * Retrieves the 1v1 Win Rate.
             *
             * @return a string representing the 1v1 Win Rate.
             */
            String get1v1WinRate();

            /**
             * Retrieves the total percentage of Headshots.
             *
             * @return a string representing the total percentage of Headshots.
             */
            String getTotalHeadshotsPercentage();

            /**
             * Retrieves the average percentage of Headshots.
             *
             * @return a string representing the average percentage of Headshots.
             */
            String getAverageHeadshotsPercentage();

            /**
             * Retrieves the total number of Headshots.
             *
             * @return a string representing the total number of Headshots.
             */
            String getHeadshots();

            /**
             * Retrieves the Win Rate percentage.
             *
             * @return a string representing the Win Rate percentage.
             */
            String getWinRatePercentage();

            /**
             * Retrieves the total number of Penta Kills.
             *
             * @return a string representing the total number of Penta Kills.
             */
            String getPentaKills();

        }
    }
}