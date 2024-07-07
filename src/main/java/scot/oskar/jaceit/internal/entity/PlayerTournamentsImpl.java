package scot.oskar.jaceit.internal.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import scot.oskar.jaceit.api.entity.PlayerTournaments;

import java.util.List;

public class PlayerTournamentsImpl implements PlayerTournaments {

    @JsonProperty("end")
    private int end;

    @JsonProperty("items")
    private List<TournamentDetails> items;

    @JsonProperty("start")
    private int start;

    @Override
    public int getEnd() {
        return end;
    }

    @Override
    public List<TournamentDetails> getTournamentDetails() {
        return items;
    }

    @Override
    public int getStart() {
        return start;
    }

    public static class TournamentDetailsImpl implements TournamentDetails {

        @JsonProperty("anticheat_required")
        private boolean anticheatRequired;

        @JsonProperty("custom")
        private boolean custom;

        @JsonProperty("faceit_url")
        private String faceitUrl;

        @JsonProperty("featured_image")
        private String featuredImage;

        @JsonProperty("game_id")
        private String gameId;

        @JsonProperty("invite_type")
        private String inviteType;

        @JsonProperty("match_type")
        private String matchType;

        @JsonProperty("max_skill")
        private int maxSkill;

        @JsonProperty("membership_type")
        private String membershipType;

        @JsonProperty("min_skill")
        private int minSkill;

        @JsonProperty("name")
        private String name;

        @JsonProperty("number_of_players")
        private int numberOfPlayers;

        @JsonProperty("number_of_players_checkedin")
        private int numberOfPlayersCheckedIn;

        @JsonProperty("number_of_players_joined")
        private int numberOfPlayersJoined;

        @JsonProperty("number_of_players_participants")
        private int numberOfPlayersParticipants;

        @JsonProperty("organizer_id")
        private String organizerId;

        @JsonProperty("prize_type")
        private String prizeType;

        @JsonProperty("region")
        private String region;

        @JsonProperty("started_at")
        private long startedAt;

        @JsonProperty("status")
        private String status;

        @JsonProperty("subscriptions_count")
        private int subscriptionsCount;

        @JsonProperty("team_size")
        private int teamSize;

        @JsonProperty("total_prize")
        private Object totalPrize;

        @JsonProperty("tournament_id")
        private String tournamentId;

        @JsonProperty("whitelist_countries")
        private List<String> whitelistCountries;

        @Override
        public boolean isAnticheatRequired() {
            return anticheatRequired;
        }

        @Override
        public boolean isCustom() {
            return custom;
        }

        @Override
        public String getFaceitUrl() {
            return faceitUrl;
        }

        @Override
        public String getFeaturedImage() {
            return featuredImage;
        }

        @Override
        public String getGameId() {
            return gameId;
        }

        @Override
        public String getInviteType() {
            return inviteType;
        }

        @Override
        public String getMatchType() {
            return matchType;
        }

        @Override
        public int getMaxSkill() {
            return maxSkill;
        }

        @Override
        public String getMembershipType() {
            return membershipType;
        }

        @Override
        public int getMinSkill() {
            return minSkill;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public int getNumberOfPlayers() {
            return numberOfPlayers;
        }

        @Override
        public int getNumberOfPlayersCheckedIn() {
            return numberOfPlayersCheckedIn;
        }

        @Override
        public int getNumberOfPlayersJoined() {
            return numberOfPlayersJoined;
        }

        @Override
        public int getNumberOfPlayersParticipants() {
            return numberOfPlayersParticipants;
        }

        @Override
        public String getOrganizerId() {
            return organizerId;
        }

        @Override
        public String getPrizeType() {
            return prizeType;
        }

        @Override
        public String getRegion() {
            return region;
        }

        @Override
        public long getStartedAt() {
            return startedAt;
        }

        @Override
        public String getStatus() {
            return status;
        }

        @Override
        public int getSubscriptionsCount() {
            return subscriptionsCount;
        }

        @Override
        public int getTeamSize() {
            return teamSize;
        }

        @Override
        public Object getTotalPrize() {
            return totalPrize;
        }

        @Override
        public String getTournamentId() {
            return tournamentId;
        }

        @Override
        public List<String> getWhitelistCountries() {
            return whitelistCountries;
        }
    }
}