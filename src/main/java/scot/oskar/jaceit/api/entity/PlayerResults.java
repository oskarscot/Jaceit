package scot.oskar.jaceit.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class PlayerResults {

    @JsonProperty("items")
    private List<Item> items;

    // Offset must be a multiple of limit, limit has to be specified if offset is specified
    @JsonProperty("start")
    private int offset;

    @JsonProperty("end")
    private int limit;

    public List<Item> getItems() {
        return items;
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public static class Item {

        @JsonProperty("stats")
        private Stats stats;

        public Stats getStats() {
            return stats;
        }
    }

    public static class Stats {

        @JsonProperty("Game Mode")
        private String gameMode;

        @JsonProperty("Flash Successes")
        private String flashSuccesses;

        @JsonProperty("Match Id")
        private String matchId;

        @JsonProperty("Zeus Kills")
        private String zeusKills;

        @JsonProperty("Nickname")
        private String nickname;

        @JsonProperty("Overtime score")
        private String overtimeScore;

        @JsonProperty("Second Half Score")
        private String secondHalfScore;

        @JsonProperty("Penta Kills")
        private String pentaKills;

        @JsonProperty("Headshots")
        private String headshots;

        @JsonProperty("Match Round")
        private String matchRound;

        @JsonProperty("Final Score")
        private String finalScore;

        @JsonProperty("Rounds")
        private String rounds;

        @JsonProperty("Player Id")
        private String playerId;

        @JsonProperty("Clutch Kills")
        private String clutchKills;

        @JsonProperty("1v1Wins")
        private String oneVoneWins;

        @JsonProperty("Pistol Kills")
        private String pistolKills;

        @JsonProperty("Knife Kills")
        private String knifeKills;

        @JsonProperty("Double Kills")
        private String doubleKills;

        @JsonProperty("Game")
        private String game;

        @JsonProperty("First Half Score")
        private String firstHalfScore;

        @JsonProperty("Result")
        private String result;

        @JsonProperty("Utility Damage")
        private String utilityDamage;

        @JsonProperty("Score")
        private String score;

        @JsonProperty("1v2Count")
        private String oneVtwoCount;

        @JsonProperty("K/D Ratio")
        private String kdRatio;

        @JsonProperty("1v2Wins")
        private String oneVtwoWins;

        @JsonProperty("Headshots %")
        private String headshotsPercentage;

        @JsonProperty("Assists")
        private String assists;

        @JsonProperty("Triple Kills")
        private String tripleKills;

        @JsonProperty("K/R Ratio")
        private String krRatio;

        @JsonProperty("Updated At")
        private String updatedAt;

        @JsonProperty("Enemies Flashed")
        private String enemiesFlashed;

        @JsonProperty("Deaths")
        private String deaths;

        @JsonProperty("Utility Count")
        private String utilityCount;

        @JsonProperty("Winner")
        private String winner;

        @JsonProperty("First Kills")
        private String firstKills;

        @JsonProperty("Best Of")
        private String bestOf;

        @JsonProperty("Damage")
        private String damage;

        @JsonProperty("Team")
        private String team;

        @JsonProperty("Quadro Kills")
        private String quadroKills;

        @JsonProperty("Entry Wins")
        private String entryWins;

        @JsonProperty("Kills")
        private String kills;

        @JsonProperty("MVPs")
        private String mvps;

        @JsonProperty("Utility Enemies")
        private String utilityEnemies;

        @JsonProperty("Entry Count")
        private String entryCount;

        @JsonProperty("Flash Count")
        private String flashCount;

        @JsonProperty("Region")
        private String region;

        @JsonProperty("Utility Successes")
        private String utilitySuccesses;

        @JsonProperty("Created At")
        private String createdAt;

        @JsonProperty("Map")
        private String map;

        @JsonProperty("ADR")
        private String adr;

        @JsonProperty("Competition Id")
        private String competitionId;

        @JsonProperty("Sniper Kills")
        private String sniperKills;

        @JsonProperty("1v1Count")
        private String oneVoneCount;

        public String getGameMode() {
            return gameMode;
        }

        public String getFlashSuccesses() {
            return flashSuccesses;
        }

        public String getMatchId() {
            return matchId;
        }

        public String getZeusKills() {
            return zeusKills;
        }

        public String getNickname() {
            return nickname;
        }

        public String getOvertimeScore() {
            return overtimeScore;
        }

        public String getSecondHalfScore() {
            return secondHalfScore;
        }

        public String getPentaKills() {
            return pentaKills;
        }

        public String getHeadshots() {
            return headshots;
        }

        public String getMatchRound() {
            return matchRound;
        }

        public String getFinalScore() {
            return finalScore;
        }

        public String getRounds() {
            return rounds;
        }

        public String getPlayerId() {
            return playerId;
        }

        public String getClutchKills() {
            return clutchKills;
        }

        public String getOneVoneWins() {
            return oneVoneWins;
        }

        public String getPistolKills() {
            return pistolKills;
        }

        public String getKnifeKills() {
            return knifeKills;
        }

        public String getDoubleKills() {
            return doubleKills;
        }

        public String getGame() {
            return game;
        }

        public String getFirstHalfScore() {
            return firstHalfScore;
        }

        public String getResult() {
            return result;
        }

        public String getUtilityDamage() {
            return utilityDamage;
        }

        public String getScore() {
            return score;
        }

        public String getOneVtwoCount() {
            return oneVtwoCount;
        }

        public String getKdRatio() {
            return kdRatio;
        }

        public String getOneVtwoWins() {
            return oneVtwoWins;
        }

        public String getHeadshotsPercentage() {
            return headshotsPercentage;
        }

        public String getAssists() {
            return assists;
        }

        public String getTripleKills() {
            return tripleKills;
        }

        public String getKrRatio() {
            return krRatio;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public String getEnemiesFlashed() {
            return enemiesFlashed;
        }

        public String getDeaths() {
            return deaths;
        }

        public String getUtilityCount() {
            return utilityCount;
        }

        public String getWinner() {
            return winner;
        }

        public String getFirstKills() {
            return firstKills;
        }

        public String getBestOf() {
            return bestOf;
        }

        public String getDamage() {
            return damage;
        }

        public String getTeam() {
            return team;
        }

        public String getQuadroKills() {
            return quadroKills;
        }

        public String getEntryWins() {
            return entryWins;
        }

        public String getKills() {
            return kills;
        }

        public String getMvps() {
            return mvps;
        }

        public String getUtilityEnemies() {
            return utilityEnemies;
        }

        public String getEntryCount() {
            return entryCount;
        }

        public String getFlashCount() {
            return flashCount;
        }

        public String getRegion() {
            return region;
        }

        public String getUtilitySuccesses() {
            return utilitySuccesses;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getMap() {
            return map;
        }

        public String getAdr() {
            return adr;
        }

        public String getCompetitionId() {
            return competitionId;
        }

        public String getSniperKills() {
            return sniperKills;
        }

        public String getOneVoneCount() {
            return oneVoneCount;
        }
    }
}
