package scot.oskar.jaceit.internal.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import scot.oskar.jaceit.api.entity.PlayerStats;

import java.util.List;


public class PlayerStatsImpl implements PlayerStats {

    @JsonProperty("player_id")
    private String playerId;

    @JsonProperty("game_id")
    private String gameId;

    @JsonProperty("lifetime")
    private LifetimeStats lifetime;

    @JsonProperty("segments")
    private List<MapStats> segments;

    @Override
    public String getPlayerId() {
        return playerId;
    }

    @Override
    public String getGameId() {
        return gameId;
    }

    @Override
    public LifetimeStats getLifetime() {
        return lifetime;
    }

    @Override
    public List<MapStats> getSegments() {
        return segments;
    }

    public static class LifetimeStatsImpl implements LifetimeStats {

        @JsonProperty("Total Utility Successes")
        private String totalUtilitySuccesses;

        @JsonProperty("Total Utility Count")
        private String totalUtilityCount;

        @JsonProperty("ADR")
        private String adr;

        @JsonProperty("Total Flash Count")
        private String totalFlashCount;

        @JsonProperty("Utility Success Rate")
        private String utilitySuccessRate;

        @JsonProperty("Utility Damage Success Rate")
        private String utilityDamageSuccessRate;

        @JsonProperty("Enemies Flashed per Round")
        private String enemiesFlashedPerRound;

        @JsonProperty("Total Entry Wins")
        private String totalEntryWins;

        @JsonProperty("Utility Usage per Round")
        private String utilityUsagePerRound;

        @JsonProperty("Recent Results")
        private List<String> recentResults;

        @JsonProperty("Total 1v1 Wins")
        private String total1v1Wins;

        @JsonProperty("Total Damage")
        private String totalDamage;

        @JsonProperty("Entry Rate")
        private String entryRate;

        @JsonProperty("Total Rounds with extended stats")
        private String totalRoundsWithExtendedStats;

        @JsonProperty("1v1 Win Rate")
        private String winRate1v1;

        @JsonProperty("Utility Damage per Round")
        private String utilityDamagePerRound;

        @JsonProperty("Average K/D Ratio")
        private String averageKDRatio;

        @JsonProperty("Total Kills with extended stats")
        private String totalKillsWithExtendedStats;

        @JsonProperty("Total 1v1 Count")
        private String total1v1Count;

        @JsonProperty("Current Win Streak")
        private String currentWinStreak;

        @JsonProperty("Total Sniper Kills")
        private String totalSniperKills;

        @JsonProperty("Entry Success Rate")
        private String entrySuccessRate;

        @JsonProperty("Total 1v2 Wins")
        private String total1v2Wins;

        @JsonProperty("Sniper Kill Rate")
        private String sniperKillRate;

        @JsonProperty("Total Enemies Flashed")
        private String totalEnemiesFlashed;

        @JsonProperty("Average Headshots %")
        private String averageHeadshotsPercentage;

        @JsonProperty("Total Utility Damage")
        private String totalUtilityDamage;

        @JsonProperty("Total Entry Count")
        private String totalEntryCount;

        @JsonProperty("Flashes per Round")
        private String flashesPerRound;

        @JsonProperty("Total 1v2 Count")
        private String total1v2Count;

        @JsonProperty("Wins")
        private String wins;

        @JsonProperty("Total Matches")
        private String totalMatches;

        @JsonProperty("Flash Success Rate")
        private String flashSuccessRate;

        @JsonProperty("Win Rate %")
        private String winRatePercentage;

        @JsonProperty("K/D Ratio")
        private String kdRatio;

        @JsonProperty("Total Flash Successes")
        private String totalFlashSuccesses;

        @JsonProperty("Matches")
        private String matches;

        @JsonProperty("Total Headshots %")
        private String totalHeadshotsPercentage;

        @JsonProperty("Longest Win Streak")
        private String longestWinStreak;

        @JsonProperty("Sniper Kill Rate per Round")
        private String sniperKillRatePerRound;

        @JsonProperty("1v2 Win Rate")
        private String winRate1v2;


        @Override
        public String getTotalUtilitySuccesses() {
            return totalUtilitySuccesses;
        }

        @Override
        public String getTotalUtilityCount() {
            return totalUtilityCount;
        }

        @Override
        public String getAdr() {
            return adr;
        }

        @Override
        public String getTotalFlashCount() {
            return totalFlashCount;
        }

        @Override
        public String getUtilitySuccessRate() {
            return utilitySuccessRate;
        }

        @Override
        public String getUtilityDamageSuccessRate() {
            return utilityDamageSuccessRate;
        }

        @Override
        public String getEnemiesFlashedPerRound() {
            return enemiesFlashedPerRound;
        }

        @Override
        public String getTotalEntryWins() {
            return totalEntryWins;
        }

        @Override
        public String getUtilityUsagePerRound() {
            return utilityUsagePerRound;
        }

        @Override
        public List<String> getRecentResults() {
            return recentResults;
        }

        @Override
        public String getTotal1v1Wins() {
            return total1v1Wins;
        }

        @Override
        public String getTotalDamage() {
            return totalDamage;
        }

        @Override
        public String getEntryRate() {
            return entryRate;
        }

        @Override
        public String getTotalRoundsWithExtendedStats() {
            return totalRoundsWithExtendedStats;
        }

        @Override
        public String get1v1WinRate() {
            return winRate1v1;
        }

        @Override
        public String getUtilityDamagePerRound() {
            return utilityDamagePerRound;
        }

        @Override
        public String getAverageKdRatio() {
            return averageKDRatio;
        }

        @Override
        public String getTotalKillsWithExtendedStats() {
            return totalKillsWithExtendedStats;
        }

        @Override
        public String getTotal1v1Count() {
            return total1v1Count;
        }

        @Override
        public String getCurrentWinStreak() {
            return currentWinStreak;
        }

        @Override
        public String getTotalSniperKills() {
            return totalSniperKills;
        }

        @Override
        public String getEntrySuccessRate() {
            return entrySuccessRate;
        }

        @Override
        public String getTotal1v2Wins() {
            return total1v2Wins;
        }

        @Override
        public String getSniperKillRate() {
            return sniperKillRate;
        }

        @Override
        public String getTotalEnemiesFlashed() {
            return totalEnemiesFlashed;
        }

        @Override
        public String getAverageHeadshotsPercentage() {
            return averageHeadshotsPercentage;
        }

        @Override
        public String getTotalUtilityDamage() {
            return totalUtilityDamage;
        }

        @Override
        public String getTotalEntryCount() {
            return totalEntryCount;
        }

        @Override
        public String getFlashesPerRound() {
            return total1v1Count;
        }

        @Override
        public String getTotal1v2Count() {
            return total1v2Count;
        }

        @Override
        public String getWins() {
            return totalEntryWins;
        }

        @Override
        public String getTotalMatches() {
            return totalMatches;
        }

        @Override
        public String getFlashSuccessRate() {
            return flashSuccessRate;
        }

        @Override
        public String getWinRatePercentage() {
            return winRatePercentage;
        }

        @Override
        public String getKdRatio() {
            return kdRatio;
        }

        @Override
        public String getTotalFlashSuccesses() {
            return totalFlashSuccesses;
        }

        @Override
        public String getMatches() {
            return matches;
        }

        @Override
        public String getTotalHeadshotsPercentage() {
            return totalHeadshotsPercentage;
        }

        @Override
        public String getLongestWinStreak() {
            return longestWinStreak;
        }

        @Override
        public String getSniperKillRatePerRound() {
            return sniperKillRatePerRound;
        }

        @Override
        public String get1v2WinRate() {
            return winRate1v2;
        }
    }

    public static class MapStatsImpl implements MapStats {

        private String label;

        @JsonProperty("img_small")
        private String imgSmall;

        @JsonProperty("img_regular")
        private String imgRegular;

        @JsonProperty("stats")
        private Stats stats;

        private String type;

        private String mode;

        @Override
        public String getLabel() {
            return label;
        }

        @Override
        public String getImgSmall() {
            return imgSmall;
        }

        @Override
        public String getImgRegular() {
            return imgRegular;
        }

        @Override
        public Stats getStats() {
            return stats;
        }

        @Override
        public String getType() {
            return type;
        }

        @Override
        public String getMode() {
            return mode;
        }

        public static class StatsImpl implements Stats {

            @JsonProperty("Average Headshots %")
            private String averageHeadshotsPercentage;

            @JsonProperty("Flash Success Rate")
            private String flashSuccessRate;

            @JsonProperty("Total Kills with extended stats")
            private String totalKillsWithExtendedStats;

            @JsonProperty("Total 1v2 Count")
            private String total1v2Count;

            @JsonProperty("Wins")
            private String wins;

            @JsonProperty("Total Entry Wins")
            private String totalEntryWins;

            @JsonProperty("Average Assists")
            private String averageAssists;

            @JsonProperty("Average Penta Kills")
            private String averagePentaKills;

            @JsonProperty("Deaths")
            private String deaths;

            @JsonProperty("Assists")
            private String assists;

            @JsonProperty("Total Flash Count")
            private String totalFlashCount;

            @JsonProperty("Entry Rate")
            private String entryRate;

            @JsonProperty("Utility Usage per Round")
            private String utilityUsagePerRound;

            @JsonProperty("Triple Kills")
            private String tripleKills;

            @JsonProperty("K/D Ratio")
            private String kdRatio;

            @JsonProperty("Flashes per Round")
            private String flashesPerRound;

            @JsonProperty("Total Entry Count")
            private String totalEntryCount;

            @JsonProperty("Sniper Kill Rate")
            private String sniperKillRate;

            @JsonProperty("Total Matches")
            private String totalMatches;

            @JsonProperty("Average MVPs")
            private String averageMVPs;

            @JsonProperty("Total 1v1 Count")
            private String total1v1Count;

            @JsonProperty("Kills")
            private String kills;

            @JsonProperty("Average K/D Ratio")
            private String averageKDRatio;

            @JsonProperty("1v2 Win Rate")
            private String winRate1v2;

            @JsonProperty("Total 1v1 Wins")
            private String total1v1Wins;

            @JsonProperty("Average Kills")
            private String averageKills;

            @JsonProperty("Total Headshots %")
            private String totalHeadshotsPercentage;

            @JsonProperty("Headshots per Match")
            private String headshotsPerMatch;

            @JsonProperty("Quadro Kills")
            private String quadroKills;

            @JsonProperty("Total 1v2 Wins")
            private String total1v2Wins;

            @JsonProperty("1v1 Win Rate")
            private String winRate1v1;

            @JsonProperty("Utility Success Rate")
            private String utilitySuccessRate;

            @JsonProperty("Total Utility Successes")
            private String totalUtilitySuccesses;

            @JsonProperty("Utility Damage per Round")
            private String utilityDamagePerRound;

            @JsonProperty("Enemies Flashed per Round")
            private String enemiesFlashedPerRound;

            @JsonProperty("Total Sniper Kills")
            private String totalSniperKills;

            @JsonProperty("Average K/R Ratio")
            private String averageKRRation;

            @JsonProperty("Headshots")
            private String headshots;

            @JsonProperty("Total Damage")
            private String totalDamage;

            @JsonProperty("Rounds")
            private String rounds;

            @JsonProperty("MVPs")
            private String mvps;

            @JsonProperty("Total Utility Damage")
            private String totalUtilityDamage;

            @JsonProperty("Total Utility Count")
            private String totalUtilityCount;

            @JsonProperty("Penta Kills")
            private String pentaKills;

            @JsonProperty("ADR")
            private String adr;

            @JsonProperty("K/R Ratio")
            private String krRatio;

            @JsonProperty("Total Rounds with extended stats")
            private String totalRoundsWithExtendedStats;

            @JsonProperty("Average Triple Kills")
            private String averageTripleKills;

            @JsonProperty("Average Deaths")
            private String averageDeaths;

            @JsonProperty("Win Rate %")
            private String winRatePercentage;

            @JsonProperty("Utility Damage Success Rate")
            private String utilityDamageSuccessRate;

            @JsonProperty("Entry Success Rate")
            private String entrySuccessRate;

            @JsonProperty("Matches")
            private String matches;

            @JsonProperty("Sniper Kill Rate per Round")
            private String sniperKillRatePerRound;

            @JsonProperty("Average Quadro Kills")
            private String averageQuadroKills;

            @JsonProperty("Total Enemies Flashed")
            private String totalEnemiesFlashed;

            @JsonProperty("Total Flash Successes")
            private String totalFlashSuccesses;

            @Override
            public String getSniperKillRate() {
                return sniperKillRate;
            }

            @Override
            public String getTotal1v2Wins() {
                return total1v2Wins;
            }

            @Override
            public String getAssists() {
                return assists;
            }

            @Override
            public String getTotalFlashSuccesses() {
                return totalFlashSuccesses;
            }

            @Override
            public String getAverageTripleKills() {
                return averageTripleKills;
            }

            @Override
            public String getTripleKills() {
                return tripleKills;
            }

            @Override
            public String getKills() {
                return kills;
            }

            @Override
            public String getDeaths() {
                return deaths;
            }

            @Override
            public String getTotalRoundsWithExtendedStats() {
                return totalRoundsWithExtendedStats;
            }

            @Override
            public String getADR() {
                return adr;
            }

            @Override
            public String getUtilityDamageSuccessRate() {
                return utilityDamageSuccessRate;
            }

            @Override
            public String get1v2WinRate() {
                return winRate1v2;
            }

            @Override
            public String getUtilityDamagePerRound() {
                return utilityDamagePerRound;
            }

            @Override
            public String getTotalEntryCount() {
                return totalEntryCount;
            }

            @Override
            public String getEntrySuccessRate() {
                return entrySuccessRate;
            }

            @Override
            public String getEntryRate() {
                return entryRate;
            }

            @Override
            public String getSniperKillRatePerRound() {
                return sniperKillRatePerRound;
            }

            @Override
            public String getAverageDeaths() {
                return averageDeaths;
            }

            @Override
            public String getTotalSniperKills() {
                return totalSniperKills;
            }

            @Override
            public String getUtilitySuccessRate() {
                return utilitySuccessRate;
            }

            @Override
            public String getTotalMatches() {
                return totalMatches;
            }

            @Override
            public String getAverageKDRatio() {
                return averageKDRatio;
            }

            @Override
            public String getAverageQuadroKills() {
                return averageQuadroKills;
            }

            @Override
            public String getTotalDamage() {
                return totalDamage;
            }

            @Override
            public String getTotal1v1Count() {
                return total1v1Count;
            }

            @Override
            public String getMVPs() {
                return mvps;
            }

            @Override
            public String getTotalKillsWithExtendedStats() {
                return totalKillsWithExtendedStats;
            }

            @Override
            public String getTotalUtilitySuccesses() {
                return totalUtilitySuccesses;
            }

            @Override
            public String getTotalEnemiesFlashed() {
                return totalEnemiesFlashed;
            }

            @Override
            public String getQuadroKills() {
                return quadroKills;
            }

            @Override
            public String getAverageKRRatio() {
                return averageKDRatio;
            }

            @Override
            public String getFlashSuccessRate() {
                return flashSuccessRate;
            }

            @Override
            public String getTotal1v1Wins() {
                return total1v1Wins;
            }

            @Override
            public String getWins() {
                return wins;
            }

            @Override
            public String getMatches() {
                return matches;
            }

            @Override
            public String getRounds() {
                return rounds;
            }

            @Override
            public String getUtilityUsagePerRound() {
                return utilityUsagePerRound;
            }

            @Override
            public String getTotal1v2Count() {
                return total1v2Count;
            }

            @Override
            public String getTotalFlashCount() {
                return totalFlashCount;
            }

            @Override
            public String getKRRatio() {
                return krRatio;
            }

            @Override
            public String getFlashesPerRound() {
                return flashesPerRound;
            }

            @Override
            public String getEnemiesFlashedPerRound() {
                return enemiesFlashedPerRound;
            }

            @Override
            public String getKDRatio() {
                return kdRatio;
            }

            @Override
            public String getAverageKills() {
                return averageKills;
            }

            @Override
            public String getHeadshotsPerMatch() {
                return headshotsPerMatch;
            }

            @Override
            public String getAveragePentaKills() {
                return averagePentaKills;
            }

            @Override
            public String getTotalEntryWins() {
                return totalEntryWins;
            }

            @Override
            public String getTotalUtilityDamage() {
                return totalUtilityDamage;
            }

            @Override
            public String getAverageAssists() {
                return averageAssists;
            }

            @Override
            public String getTotalUtilityCount() {
                return totalUtilityCount;
            }

            @Override
            public String getAverageMVPs() {
                return averageMVPs;
            }

            @Override
            public String get1v1WinRate() {
                return winRate1v1;
            }

            @Override
            public String getTotalHeadshotsPercentage() {
                return totalHeadshotsPercentage;
            }

            @Override
            public String getAverageHeadshotsPercentage() {
                return averageHeadshotsPercentage;
            }

            @Override
            public String getHeadshots() {
                return headshots;
            }

            @Override
            public String getWinRatePercentage() {
                return winRatePercentage;
            }

            @Override
            public String getPentaKills() {
                return pentaKills;
            }
        }
    }

}
