package scot.oskar.jaceit.api.entity.match;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import scot.oskar.jaceit.internal.entity.match.MatchStatsImpl;

import java.util.List;

/**
 * Interface representing match details for a series of rounds.
 */
@JsonDeserialize(as = MatchStatsImpl.class)
public interface MatchStats {

    /**
     * Gets the list of rounds.
     *
     * @return the list of rounds.
     */
    List<Round> getRounds();

    /**
     * Interface representing a single round.
     */
    @JsonDeserialize(as = MatchStatsImpl.RoundImpl.class)
    interface Round {

        /**
         * Gets the number of rounds (best of).
         *
         * @return the number of rounds.
         */
        String getBestOf();

        /**
         * Gets the competition ID.
         *
         * @return the competition ID.
         */
        String getCompetitionId();

        /**
         * Gets the game ID.
         *
         * @return the game ID.
         */
        String getGameId();

        /**
         * Gets the game mode.
         *
         * @return the game mode.
         */
        String getGameMode();

        /**
         * Gets the match ID.
         *
         * @return the match ID.
         */
        String getMatchId();

        /**
         * Gets the round number.
         *
         * @return the round number.
         */
        String getMatchRound();

        /**
         * Gets the played status.
         *
         * @return the played status.
         */
        String getPlayed();

        /**
         * Gets the round statistics.
         *
         * @return the round statistics.
         */
        RoundStats getRoundStats();

        /**
         * Gets the list of teams.
         *
         * @return the list of teams.
         */
        List<Team> getTeams();

        /**
         * Interface representing the round statistics.
         */
        @JsonDeserialize(as = MatchStatsImpl.RoundImpl.RoundStatsImpl.class)
        interface RoundStats {

            /**
             * Gets the map.
             *
             * @return the map.
             */
            String getMap();

            /**
             * Gets the score.
             *
             * @return the score.
             */
            String getScore();

            /**
             * Gets the winner.
             *
             * @return the winner.
             */
            String getWinner();

            /**
             * Gets the number of rounds.
             *
             * @return the number of rounds.
             */
            String getRounds();

            /**
             * Gets the region.
             *
             * @return the region.
             */
            String getRegion();
        }

        /**
         * Interface representing a team.
         */
        @JsonDeserialize(as = MatchStatsImpl.RoundImpl.TeamImpl.class)
        interface Team {

            /**
             * Gets the team ID.
             *
             * @return the team ID.
             */
            String getTeamId();

            /**
             * Gets the premade status.
             *
             * @return true if premade, false otherwise.
             */
            boolean isPremade();

            /**
             * Gets the team statistics.
             *
             * @return the team statistics.
             */
            TeamStats getTeamStats();

            /**
             * Gets the list of players.
             *
             * @return the list of players.
             */
            List<Player> getPlayers();

            /**
             * Interface representing the team statistics.
             */
            @JsonDeserialize(as = MatchStatsImpl.RoundImpl.TeamImpl.TeamStatsImpl.class)
            interface TeamStats {

                /**
                 * Gets the team win status.
                 *
                 * @return the team win status.
                 */
                String getTeamWin();

                /**
                 * Gets the final score.
                 *
                 * @return the final score.
                 */
                String getFinalScore();

                /**
                 * Gets the number of team headshots.
                 *
                 * @return the number of team headshots.
                 */
                String getTeamHeadshots();

                /**
                 * Gets the overtime score.
                 *
                 * @return the overtime score.
                 */
                String getOvertimeScore();

                /**
                 * Gets the second half score.
                 *
                 * @return the second half score.
                 */
                String getSecondHalfScore();

                /**
                 * Gets the first half score.
                 *
                 * @return the first half score.
                 */
                String getFirstHalfScore();

                /**
                 * Gets the team name.
                 *
                 * @return the team name.
                 */
                String getTeam();
            }

            /**
             * Interface representing a player.
             */
            @JsonDeserialize(as = MatchStatsImpl.RoundImpl.TeamImpl.PlayerImpl.class)
            interface Player {

                /**
                 * Gets the player ID.
                 *
                 * @return the player ID.
                 */
                String getPlayerId();

                /**
                 * Gets the nickname of the player.
                 *
                 * @return the nickname.
                 */
                String getNickname();

                /**
                 * Gets the player statistics.
                 *
                 * @return the player statistics.
                 */
                PlayerStats getPlayerStats();

                /**
                 * Interface representing the statistics of a player in a match.
                 */
                @JsonDeserialize(as = MatchStatsImpl.RoundImpl.TeamImpl.PlayerImpl.PlayerStatsImpl.class)
                interface PlayerStats {

                    /**
                     * Gets the number of enemies affected by utility.
                     *
                     * @return the number of utility enemies.
                     */
                    String getUtilityEnemies();

                    /**
                     * Gets the success rate of match entries.
                     *
                     * @return the match entry success rate.
                     */
                    String getMatchEntrySuccessRate();

                    /**
                     * Gets the number of MVP awards.
                     *
                     * @return the number of MVPs.
                     */
                    String getMVPs();

                    /**
                     * Gets the count of utility usages.
                     *
                     * @return the utility count.
                     */
                    String getUtilityCount();

                    /**
                     * Gets the rate of match entries.
                     *
                     * @return the match entry rate.
                     */
                    String getMatchEntryRate();

                    /**
                     * Gets the number of flashes per round in a match.
                     *
                     * @return the flashes per round in a match.
                     */
                    String getFlashesPerRoundInMatch();

                    /**
                     * Gets the number of entry wins.
                     *
                     * @return the number of entry wins.
                     */
                    String getEntryWins();

                    /**
                     * Gets the number of quadruple kills.
                     *
                     * @return the number of quadro kills.
                     */
                    String getQuadroKills();

                    /**
                     * Gets the kill ratio (K/R ratio).
                     *
                     * @return the K/R ratio.
                     */
                    String getKRRation();

                    /**
                     * Gets the number of pentakills.
                     *
                     * @return the number of pentakills.
                     */
                    String getPentaKills();

                    /**
                     * Gets the average damage per round (ADR).
                     *
                     * @return the ADR.
                     */
                    String getADR();

                    /**
                     * Gets the count of 1v2 situations.
                     *
                     * @return the count of 1v2 situations.
                     */
                    String get1v2Count();

                    /**
                     * Gets the number of successful utility uses.
                     *
                     * @return the number of utility successes.
                     */
                    String getUtilitySuccesses();

                    /**
                     * Gets the win rate in 1v1 situations in matches.
                     *
                     * @return the match 1v1 win rate.
                     */
                    String getMatch1v1WinRate();

                    /**
                     * Gets the number of headshots.
                     *
                     * @return the number of headshots.
                     */
                    String getHeadshots();

                    /**
                     * Gets the number of deaths.
                     *
                     * @return the number of deaths.
                     */
                    String getDeaths();

                    /**
                     * Gets the sniper kill rate per round.
                     *
                     * @return the sniper kill rate per round.
                     */
                    String getSniperKillRatePerRound();

                    /**
                     * Gets the number of successful flashes.
                     *
                     * @return the number of flash successes.
                     */
                    String getFlashSuccesses();

                    /**
                     * Gets the number of wins in 1v2 situations.
                     *
                     * @return the number of 1v2 wins.
                     */
                    String get1v2Wins();

                    /**
                     * Gets the kill/death ratio (K/D ratio).
                     *
                     * @return the K/D ratio.
                     */
                    String getKDRatio();

                    /**
                     * Gets the count of 1v1 situations.
                     *
                     * @return the count of 1v1 situations.
                     */
                    String get1v1Count();

                    /**
                     * Gets the match result.
                     *
                     * @return the match result.
                     */
                    String getResult();

                    /**
                     * Gets the success rate of utility damage per match.
                     *
                     * @return the utility damage success rate per match.
                     */
                    String getUtilityDamageSuccessRatePerMatch();

                    /**
                     * Gets the number of kills.
                     *
                     * @return the number of kills.
                     */
                    String getKills();

                    /**
                     * Gets the number of triple kills.
                     *
                     * @return the number of triple kills.
                     */
                    String getTripleKills();

                    /**
                     * Gets the amount of damage dealt.
                     *
                     * @return the amount of damage.
                     */
                    String getDamage();

                    /**
                     * Gets the success rate of flashes per match.
                     *
                     * @return the flash success rate per match.
                     */
                    String getFlashSuccessRatePerMatch();

                    /**
                     * Gets the number of wins in 1v1 situations.
                     *
                     * @return the number of 1v1 wins.
                     */
                    String get1v1Wins();

                    /**
                     * Gets the amount of utility damage per round in a match.
                     *
                     * @return the utility damage per round in a match.
                     */
                    String getUtilityDamagePerRoundInMatch();

                    /**
                     * Gets the number of knife kills.
                     *
                     * @return the number of knife kills.
                     */
                    String getKnifeKills();

                    /**
                     * Gets the number of double kills.
                     *
                     * @return the number of double kills.
                     */
                    String getDoubleKills();

                    /**
                     * Gets the number of enemies flashed.
                     *
                     * @return the number of enemies flashed.
                     */
                    String getEnemiesFlashed();

                    /**
                     * Gets the count of entries.
                     *
                     * @return the entry count.
                     */
                    String getEntryCount();

                    /**
                     * Gets the sniper kill rate per match.
                     *
                     * @return the sniper kill rate per match.
                     */
                    String getSniperKillRatePerMatch();

                    /**
                     * Gets the win rate in 1v2 situations in matches.
                     *
                     * @return the match 1v2 win rate.
                     */
                    String getMatch1v2WinRate();

                    /**
                     * Gets the success rate of utility usage per match.
                     *
                     * @return the utility success rate per match.
                     */
                    String getUtilitySuccessRatePerMatch();

                    /**
                     * Gets the number of enemies flashed per round in a match.
                     *
                     * @return the enemies flashed per round in a match.
                     */
                    String getEnemiesFlashedPerRoundInMatch();

                    /**
                     * Gets the number of first kills.
                     *
                     * @return the number of first kills.
                     */
                    String getFirstKills();

                    /**
                     * Gets the utility usage per round.
                     *
                     * @return the utility usage per round.
                     */
                    String getUtilityUsagePerRound();

                    /**
                     * Gets the amount of utility damage.
                     *
                     * @return the amount of utility damage.
                     */
                    String getUtilityDamage();

                    /**
                     * Gets the number of pistol kills.
                     *
                     * @return the number of pistol kills.
                     */
                    String getPistolKills();

                    /**
                     * Gets the number of Zeus kills.
                     *
                     * @return the number of Zeus kills.
                     */
                    String getZeusKills();

                    /**
                     * Gets the number of sniper kills.
                     *
                     * @return the number of sniper kills.
                     */
                    String getSniperKills();

                    /**
                     * Gets the number of clutch kills.
                     *
                     * @return the number of clutch kills.
                     */
                    String getClutchKills();

                    /**
                     * Gets the number of assists.
                     *
                     * @return the number of assists.
                     */
                    String getAssists();

                    /**
                     * Gets the percentage of headshots.
                     *
                     * @return the headshots percentage.
                     */
                    String getHeadshotsPercentage();

                    /**
                     * Gets the count of flashes.
                     *
                     * @return the flash count.
                     */
                    String getFlashCount();
                }
            }
        }
    }
}