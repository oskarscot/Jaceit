package scot.oskar.jaceit.internal.entity.match;

import com.fasterxml.jackson.annotation.JsonProperty;
import scot.oskar.jaceit.api.entity.match.MatchStats;

import java.util.List;

public class MatchStatsImpl implements MatchStats {

    @JsonProperty("rounds")
    private List<Round> rounds;

    @Override
    public List<Round> getRounds() {
        return rounds;
    }

    public static class RoundImpl implements Round {

        @JsonProperty("best_of")
        private String bestOf;

        @JsonProperty("competition_id")
        private String competitionId;

        @JsonProperty("game_id")
        private String gameId;

        @JsonProperty("game_mode")
        private String gameMode;

        @JsonProperty("match_id")
        private String matchId;

        @JsonProperty("match_round")
        private String matchRound;

        @JsonProperty("played")
        private String played;

        @JsonProperty("round_stats")
        private RoundStats roundStats;

        @JsonProperty("teams")
        private List<Team> teams;

        @Override
        public String getBestOf() {
            return bestOf;
        }

        @Override
        public String getCompetitionId() {
            return competitionId;
        }

        @Override
        public String getGameId() {
            return gameId;
        }

        @Override
        public String getGameMode() {
            return gameMode;
        }

        @Override
        public String getMatchId() {
            return matchId;
        }

        @Override
        public String getMatchRound() {
            return matchRound;
        }

        @Override
        public String getPlayed() {
            return played;
        }

        @Override
        public RoundStats getRoundStats() {
            return roundStats;
        }

        @Override
        public List<Team> getTeams() {
            return teams;
        }

        public static class RoundStatsImpl implements RoundStats {

            @JsonProperty("Map")
            private String map;

            @JsonProperty("Score")
            private String score;

            @JsonProperty("Winner")
            private String winner;

            @JsonProperty("Rounds")
            private String rounds;

            @JsonProperty("Region")
            private String region;

            @Override
            public String getMap() {
                return map;
            }

            @Override
            public String getRegion() {
                return region;
            }

            @Override
            public String getRounds() {
                return rounds;
            }

            @Override
            public String getScore() {
                return score;
            }

            @Override
            public String getWinner() {
                return winner;
            }
        }

        public static class TeamImpl implements Team {

            @JsonProperty("team_id")
            private String teamId;

            @JsonProperty("premade")
            private boolean premade;

            @JsonProperty("team_stats")
            private TeamStats teamStats;

            @JsonProperty("players")
            private List<Player> players;

            @Override
            public List<Player> getPlayers() {
                return players;
            }

            @Override
            public boolean isPremade() {
                return premade;
            }

            @Override
            public String getTeamId() {
                return teamId;
            }

            @Override
            public TeamStats getTeamStats() {
                return teamStats;
            }

            public static class TeamStatsImpl implements TeamStats {

                @JsonProperty("Team Win")
                private String teamWin;

                @JsonProperty("Final Score")
                private String finalScore;

                @JsonProperty("Team Headshots")
                private String teamHeadshots;

                @JsonProperty("Overtime score")
                private String overtimeScore;

                @JsonProperty("Second Half Score")
                private String secondHalfScore;

                @JsonProperty("First Half Score")
                private String firstHalfScore;

                @JsonProperty("Team")
                private String team;

                public String getFinalScore() {
                    return finalScore;
                }

                public String getFirstHalfScore() {
                    return firstHalfScore;
                }

                public String getOvertimeScore() {
                    return overtimeScore;
                }

                public String getSecondHalfScore() {
                    return secondHalfScore;
                }

                public String getTeam() {
                    return team;
                }

                public String getTeamHeadshots() {
                    return teamHeadshots;
                }

                public String getTeamWin() {
                    return teamWin;
                }
            }

            public static class PlayerImpl implements Player{

                @JsonProperty("player_id")
                private String playerId;

                @JsonProperty("nickname")
                private String nickname;

                @JsonProperty("player_stats")
                private PlayerStats playerStats;

                @Override
                public String getNickname() {
                    return nickname;
                }

                @Override
                public String getPlayerId() {
                    return playerId;
                }

                @Override
                public PlayerStats getPlayerStats() {
                    return playerStats;
                }

                public static class PlayerStatsImpl implements PlayerStats {

                    @JsonProperty("Utility Enemies")
                    private String utilityEnemies;

                    @JsonProperty("Match Entry Success Rate")
                    private String matchEntrySuccessRate;

                    @JsonProperty("MVPs")
                    private String mvps;

                    @JsonProperty("Utility Count")
                    private String utilityCount;

                    @JsonProperty("Match Entry Rate")
                    private String matchEntryRate;

                    @JsonProperty("Flashes per Round in a Match")
                    private String flashesPerRoundInMatch;

                    @JsonProperty("Entry Wins")
                    private String entryWins;

                    @JsonProperty("Quadro Kills")
                    private String quadroKills;

                    @JsonProperty("K/R Ratio")
                    private String krRatio;

                    @JsonProperty("Penta Kills")
                    private String pentaKills;

                    @JsonProperty("ADR")
                    private String adr;

                    @JsonProperty("1v2Count")
                    private String oneV2Count;

                    @JsonProperty("Utility Successes")
                    private String utilitySuccesses;

                    @JsonProperty("Match 1v1 Win Rate")
                    private String matchOneV1WinRate;

                    @JsonProperty("Headshots")
                    private String headshots;

                    @JsonProperty("Deaths")
                    private String deaths;

                    @JsonProperty("Sniper Kill Rate per Round")
                    private String sniperKillRatePerRound;

                    @JsonProperty("Flash Successes")
                    private String flashSuccesses;

                    @JsonProperty("1v2Wins")
                    private String oneV2Wins;

                    @JsonProperty("K/D Ratio")
                    private String kdRatio;

                    @JsonProperty("1v1Count")
                    private String oneV1Count;

                    @JsonProperty("Result")
                    private String result;

                    @JsonProperty("Utility Damage Success Rate per Match")
                    private String utilityDamageSuccessRatePerMatch;

                    @JsonProperty("Kills")
                    private String kills;

                    @JsonProperty("Triple Kills")
                    private String tripleKills;

                    @JsonProperty("Damage")
                    private String damage;

                    @JsonProperty("Flash Success Rate per Match")
                    private String flashSuccessRatePerMatch;

                    @JsonProperty("1v1Wins")
                    private String oneV1Wins;

                    @JsonProperty("Utility Damage per Round in a Match")
                    private String utilityDamagePerRoundInMatch;

                    @JsonProperty("Knife Kills")
                    private String knifeKills;

                    @JsonProperty("Double Kills")
                    private String doubleKills;

                    @JsonProperty("Enemies Flashed")
                    private String enemiesFlashed;

                    @JsonProperty("Entry Count")
                    private String entryCount;

                    @JsonProperty("Sniper Kill Rate per Match")
                    private String sniperKillRatePerMatch;

                    @JsonProperty("Match 1v2 Win Rate")
                    private String matchOneV2WinRate;

                    @JsonProperty("Utility Success Rate per Match")
                    private String utilitySuccessRatePerMatch;

                    @JsonProperty("Enemies Flashed per Round in a Match")
                    private String enemiesFlashedPerRoundInMatch;

                    @JsonProperty("First Kills")
                    private String firstKills;

                    @JsonProperty("Utility Usage per Round")
                    private String utilityUsagePerRound;

                    @JsonProperty("Utility Damage")
                    private String utilityDamage;

                    @JsonProperty("Pistol Kills")
                    private String pistolKills;

                    @JsonProperty("Zeus Kills")
                    private String zeusKills;

                    @JsonProperty("Sniper Kills")
                    private String sniperKills;

                    @JsonProperty("Clutch Kills")
                    private String clutchKills;

                    @JsonProperty("Assists")
                    private String assists;

                    @JsonProperty("Headshots %")
                    private String headshotsPercentage;

                    @JsonProperty("Flash Count")
                    private String flashCount;

                    @Override
                    public String getUtilityEnemies() {
                        return utilityEnemies;
                    }

                    @Override
                    public String getMatchEntrySuccessRate() {
                        return matchEntrySuccessRate;
                    }

                    @Override
                    public String getMVPs() {
                        return mvps;
                    }

                    @Override
                    public String getUtilityCount() {
                        return utilityCount;
                    }

                    @Override
                    public String getMatchEntryRate() {
                        return matchEntryRate;
                    }

                    @Override
                    public String getFlashesPerRoundInMatch() {
                        return flashesPerRoundInMatch;
                    }

                    @Override
                    public String getEntryWins() {
                        return entryWins;
                    }

                    @Override
                    public String getQuadroKills() {
                        return quadroKills;
                    }

                    @Override
                    public String getKRRation() {
                        return krRatio;
                    }

                    @Override
                    public String getPentaKills() {
                        return pentaKills;
                    }

                    @Override
                    public String getADR() {
                        return adr;
                    }

                    @Override
                    public String get1v2Count() {
                        return oneV2Count;
                    }

                    @Override
                    public String getUtilitySuccesses() {
                        return utilitySuccesses;
                    }

                    @Override
                    public String getMatch1v1WinRate() {
                        return matchOneV1WinRate;
                    }

                    @Override
                    public String getHeadshots() {
                        return headshots;
                    }

                    @Override
                    public String getDeaths() {
                        return deaths;
                    }

                    @Override
                    public String getSniperKillRatePerRound() {
                        return sniperKillRatePerRound;
                    }

                    @Override
                    public String getFlashSuccesses() {
                        return flashSuccesses;
                    }

                    @Override
                    public String get1v2Wins() {
                        return oneV2Wins;
                    }

                    @Override
                    public String getKDRatio() {
                        return kdRatio;
                    }

                    @Override
                    public String get1v1Count() {
                        return oneV1Count;
                    }

                    @Override
                    public String getResult() {
                        return result;
                    }

                    @Override
                    public String getUtilityDamageSuccessRatePerMatch() {
                        return utilityDamageSuccessRatePerMatch;
                    }

                    @Override
                    public String getKills() {
                        return kills;
                    }

                    @Override
                    public String getTripleKills() {
                        return tripleKills;
                    }

                    @Override
                    public String getDamage() {
                        return damage;
                    }

                    @Override
                    public String getFlashSuccessRatePerMatch() {
                        return flashSuccessRatePerMatch;
                    }

                    @Override
                    public String get1v1Wins() {
                        return oneV1Wins;
                    }

                    @Override
                    public String getUtilityDamagePerRoundInMatch() {
                        return utilityDamagePerRoundInMatch;
                    }

                    @Override
                    public String getKnifeKills() {
                        return knifeKills;
                    }

                    @Override
                    public String getDoubleKills() {
                        return doubleKills;
                    }

                    @Override
                    public String getEnemiesFlashed() {
                        return enemiesFlashed;
                    }

                    @Override
                    public String getEntryCount() {
                        return entryCount;
                    }

                    @Override
                    public String getSniperKillRatePerMatch() {
                        return sniperKillRatePerMatch;
                    }

                    @Override
                    public String getMatch1v2WinRate() {
                        return matchOneV2WinRate;
                    }

                    @Override
                    public String getUtilitySuccessRatePerMatch() {
                        return utilitySuccessRatePerMatch;
                    }

                    @Override
                    public String getEnemiesFlashedPerRoundInMatch() {
                        return enemiesFlashedPerRoundInMatch;
                    }

                    @Override
                    public String getFirstKills() {
                        return firstKills;
                    }

                    @Override
                    public String getUtilityUsagePerRound() {
                        return utilityUsagePerRound;
                    }

                    @Override
                    public String getUtilityDamage() {
                        return utilityDamage;
                    }

                    @Override
                    public String getPistolKills() {
                        return pistolKills;
                    }

                    @Override
                    public String getZeusKills() {
                        return zeusKills;
                    }

                    @Override
                    public String getSniperKills() {
                        return sniperKills;
                    }

                    @Override
                    public String getClutchKills() {
                        return clutchKills;
                    }

                    @Override
                    public String getAssists() {
                        return assists;
                    }

                    @Override
                    public String getHeadshotsPercentage() {
                        return headshotsPercentage;
                    }

                    @Override
                    public String getFlashCount() {
                        return flashCount;
                    }
                }
            }
        }
    }
}