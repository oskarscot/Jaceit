package scot.oskar.jaceit.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

public class PlayerMatchHistory {

    public List<Match> items;

    // Offset must be a multiple of limit, limit has to be specified if offset is specified
    @JsonProperty("start")
    private int offset;

    @JsonProperty("end")
    private int limit;

    private int from;
    private int to;

    public static class Match {
        @JsonProperty("match_id")
        private String matchId;

        @JsonProperty("game_id")
        private String gameId;

        private String region;

        @JsonProperty("match_type")
        private String matchType;

        @JsonProperty("game_mode")
        private String gameMode;

        @JsonProperty("max_players")
        private int maxPlayers;

        @JsonProperty("teams_size")
        private int teamsSize;

        private Map<String, Team> teams;

        @JsonProperty("playing_players")
        private List<String> playingPlayers;

        @JsonProperty("competition_id")
        private String competitionId;

        @JsonProperty("competition_name")
        private String competitionName;

        @JsonProperty("competition_type")
        private String competitionType;

        @JsonProperty("organizer_id")
        private String organizerId;

        private String status;

        @JsonProperty("started_at")
        private long startedAt;

        @JsonProperty("finished_at")
        private long finishedAt;

        private Results results;

        @JsonProperty("faceit_url")
        private String faceitUrl;

        public String getMatchId() {
            return matchId;
        }

        public String getGameId() {
            return gameId;
        }

        public String getRegion() {
            return region;
        }

        public String getMatchType() {
            return matchType;
        }

        public String getGameMode() {
            return gameMode;
        }

        public int getMaxPlayers() {
            return maxPlayers;
        }

        public int getTeamsSize() {
            return teamsSize;
        }

        public Map<String, Team> getTeams() {
            return teams;
        }

        public List<String> getPlayingPlayers() {
            return playingPlayers;
        }

        public String getCompetitionId() {
            return competitionId;
        }

        public String getCompetitionName() {
            return competitionName;
        }

        public String getCompetitionType() {
            return competitionType;
        }

        public String getOrganizerId() {
            return organizerId;
        }

        public String getStatus() {
            return status;
        }

        public long getStartedAt() {
            return startedAt;
        }

        public long getFinishedAt() {
            return finishedAt;
        }

        public Results getResults() {
            return results;
        }

        public String getFaceitUrl() {
            return faceitUrl;
        }

        public static class Team {
            @JsonProperty("team_id")
            private String teamId;

            private String nickname;
            private String avatar;
            private String type;
            private List<Player> players;

            public String getTeamId() {
                return teamId;
            }

            public String getNickname() {
                return nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public String getType() {
                return type;
            }

            public List<Player> getPlayers() {
                return players;
            }
        }

        public static class Player {
            @JsonProperty("player_id")
            private String playerId;

            private String nickname;
            private String avatar;

            @JsonProperty("skill_level")
            private int skillLevel;

            @JsonProperty("game_player_id")
            private String gamePlayerId;

            @JsonProperty("game_player_name")
            private String gamePlayerName;

            @JsonProperty("faceit_url")
            private String faceitUrl;

            public String getPlayerId() {
                return playerId;
            }

            public String getNickname() {
                return nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public int getSkillLevel() {
                return skillLevel;
            }

            public String getGamePlayerId() {
                return gamePlayerId;
            }

            public String getGamePlayerName() {
                return gamePlayerName;
            }

            public String getFaceitUrl() {
                return faceitUrl;
            }
        }

        public static class Results {
            private String winner;
            private Score score;

            public String getWinner() {
                return winner;
            }

            public Score getScore() {
                return score;
            }

            public static class Score {
                private int faction1;
                private int faction2;

                public int getFaction1() {
                    return faction1;
                }

                public int getFaction2() {
                    return faction2;
                }
            }
        }
    }

    public List<Match> getMatches() {
        return items;
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}