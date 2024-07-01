package scot.oskar.jaceit.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class MatchDetails {

    @JsonProperty("match_id")
    private String matchId;

    @JsonProperty("version")
    private int version;

    @JsonProperty("game")
    private String game;

    @JsonProperty("region")
    private String region;

    @JsonProperty("competition_id")
    private String competitionId;

    @JsonProperty("competition_type")
    private String competitionType;

    @JsonProperty("competition_name")
    private String competitionName;

    @JsonProperty("organizer_id")
    private String organizerId;

    @JsonProperty("teams")
    private Map<String, Team> teams;

    @JsonProperty("voting")
    private Voting voting;

    @JsonProperty("calculate_elo")
    private boolean calculateElo;

    @JsonProperty("configured_at")
    private long configuredAt;

    @JsonProperty("started_at")
    private long startedAt;

    @JsonProperty("finished_at")
    private long finishedAt;

    @JsonProperty("demo_url")
    private List<String> demoUrl;

    @JsonProperty("chat_room_id")
    private String chatRoomId;

    @JsonProperty("best_of")
    private int bestOf;

    @JsonProperty("results")
    private Results results;

    @JsonProperty("detailed_results")
    private List<DetailedResult> detailedResults;

    @JsonProperty("status")
    private String status;

    @JsonProperty("faceit_url")
    private String faceitUrl;

    // Getters only
    public String getMatchId() { return matchId; }
    public int getVersion() { return version; }
    public String getGame() { return game; }
    public String getRegion() { return region; }
    public String getCompetitionId() { return competitionId; }
    public String getCompetitionType() { return competitionType; }
    public String getCompetitionName() { return competitionName; }
    public String getOrganizerId() { return organizerId; }
    public Map<String, Team> getTeams() { return teams; }
    public Voting getVoting() { return voting; }
    public boolean isCalculateElo() { return calculateElo; }
    public long getConfiguredAt() { return configuredAt; }
    public long getStartedAt() { return startedAt; }
    public long getFinishedAt() { return finishedAt; }
    public List<String> getDemoUrl() { return demoUrl; }
    public String getChatRoomId() { return chatRoomId; }
    public int getBestOf() { return bestOf; }
    public Results getResults() { return results; }
    public List<DetailedResult> getDetailedResults() { return detailedResults; }
    public String getStatus() { return status; }
    public String getFaceitUrl() { return faceitUrl; }

    public static class Team {

        @JsonProperty("faction_id")
        private String factionId;

        @JsonProperty("leader")
        private String leader;

        @JsonProperty("avatar")
        private String avatar;

        @JsonProperty("roster")
        private List<Player> roster;

        @JsonProperty("stats")
        private Stats stats;

        @JsonProperty("substituted")
        private boolean substituted;

        @JsonProperty("name")
        private String name;

        @JsonProperty("type")
        private String type;

        // Getters only
        public String getFactionId() { return factionId; }
        public String getLeader() { return leader; }
        public String getAvatar() { return avatar; }
        public List<Player> getRoster() { return roster; }
        public Stats getStats() { return stats; }
        public boolean isSubstituted() { return substituted; }
        public String getName() { return name; }
        public String getType() { return type; }

        public static class Player {

            @JsonProperty("player_id")
            private String playerId;

            @JsonProperty("nickname")
            private String nickname;

            @JsonProperty("avatar")
            private String avatar;

            @JsonProperty("membership")
            private String membership;

            @JsonProperty("game_player_id")
            private String gamePlayerId;

            @JsonProperty("game_player_name")
            private String gamePlayerName;

            @JsonProperty("game_skill_level")
            private int gameSkillLevel;

            @JsonProperty("anticheat_required")
            private boolean anticheatRequired;

            // Getters only
            public String getPlayerId() { return playerId; }
            public String getNickname() { return nickname; }
            public String getAvatar() { return avatar; }
            public String getMembership() { return membership; }
            public String getGamePlayerId() { return gamePlayerId; }
            public String getGamePlayerName() { return gamePlayerName; }
            public int getGameSkillLevel() { return gameSkillLevel; }
            public boolean isAnticheatRequired() { return anticheatRequired; }
        }

        public static class Stats {

            @JsonProperty("winProbability")
            private double winProbability;

            @JsonProperty("skillLevel")
            private SkillLevel skillLevel;

            @JsonProperty("rating")
            private int rating;

            // Getters only
            public double getWinProbability() { return winProbability; }
            public SkillLevel getSkillLevel() { return skillLevel; }
            public int getRating() { return rating; }

            public static class SkillLevel {

                @JsonProperty("average")
                private int average;

                @JsonProperty("range")
                private Range range;

                // Getters only
                public int getAverage() { return average; }
                public Range getRange() { return range; }

                public static class Range {

                    @JsonProperty("min")
                    private int min;

                    @JsonProperty("max")
                    private int max;

                    // Getters only
                    public int getMin() { return min; }
                    public int getMax() { return max; }
                }
            }
        }
    }

    public static class Voting {

        @JsonProperty("map")
        private MapVoting mapVoting;

        @JsonProperty("voted_entity_types")
        private List<String> votedEntityTypes;

        @JsonProperty("location")
        private LocationVoting locationVoting;

        // Getters only
        public MapVoting getMapVoting() { return mapVoting; }
        public List<String> getVotedEntityTypes() { return votedEntityTypes; }
        public LocationVoting getLocationVoting() { return locationVoting; }

        public static class MapVoting {

            @JsonProperty("entities")
            private List<MapEntity> entities;

            @JsonProperty("pick")
            private List<String> pick;

            // Getters only
            public List<MapEntity> getEntities() { return entities; }
            public List<String> getPick() { return pick; }

            public static class MapEntity {

                @JsonProperty("guid")
                private String guid;

                @JsonProperty("image_lg")
                private String imageLg;

                @JsonProperty("image_sm")
                private String imageSm;

                @JsonProperty("name")
                private String name;

                @JsonProperty("class_name")
                private String className;

                @JsonProperty("game_map_id")
                private String gameMapId;

                public String getGuid() {
                    return guid;
                }

                public String getImageLarge() {
                    return imageLg;
                }

                public String getImageSmall() {
                    return imageSm;
                }

                public String getName() {
                    return name;
                }

                public String getClassName() {
                    return className;
                }

                public String getGameMapId() {
                    return gameMapId;
                }
            }
        }

        public static class LocationVoting {

            @JsonProperty("entities")
            private List<LocationEntity> entities;

            @JsonProperty("pick")
            private List<String> pick;

            public List<LocationEntity> getEntities() {
                return entities;
            }
            public List<String> getPick() {
                return pick;
            }

            public static class LocationEntity {

                @JsonProperty("image_lg")
                private String imageLg;

                @JsonProperty("image_sm")
                private String imageSm;

                @JsonProperty("name")
                private String name;

                @JsonProperty("class_name")
                private String className;

                @JsonProperty("game_location_id")
                private String gameLocationId;

                @JsonProperty("guid")
                private String guid;

                public String getImageLarge() {
                    return imageLg;
                }
                public String getImageSmall() {
                    return imageSm;
                }
                public String getName() {
                    return name;
                }
                public String getClassName() {
                    return className;
                }
                public String getGameLocationId() {
                    return gameLocationId;
                }
                public String getGuid() {
                    return guid;
                }
            }
        }
    }

    public static class Results {

        @JsonProperty("winner")
        private String winner;

        @JsonProperty("score")
        private Map<String, Integer> score;

        public String getWinner() {
            return winner;
        }
        public Map<String, Integer> getScore() {
            return score;
        }
    }

    public static class DetailedResult {

        @JsonProperty("asc_score")
        private boolean ascScore;

        @JsonProperty("winner")
        private String winner;

        @JsonProperty("factions")
        private Map<String, Faction> factions;

        public boolean isAscScore() {
            return ascScore;
        }

        public String getWinner() {
            return winner;
        }

        public Map<String, Faction> getFactions() {
            return factions;
        }
    }

    public static class Faction {

        @JsonProperty("score")
        private int score;

        public int getScore() {
            return score;
        }
    }
}
