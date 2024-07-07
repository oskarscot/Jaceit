package scot.oskar.jaceit.internal.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import scot.oskar.jaceit.api.entity.PlayerTeams;

import java.util.List;

/**
 * Implementation class for the PlayerTeams interface.
 */
public class PlayerTeamsImpl implements PlayerTeams {

    private int end;

    @JsonProperty("items")
    private List<TeamDetails> items;

    private int start;

    @Override
    public int getEnd() {
        return end;
    }

    @Override
    public List<TeamDetails> getTeamDetails() {
        return items;
    }

    @Override
    public int getStart() {
        return start;
    }

    /**
     * Implementation class for the TeamDetails interface.
     */
    public static class TeamDetailsImpl implements TeamDetails {

        private String avatar;

        @JsonProperty("chat_room_id")
        private String chatRoomId;

        @JsonProperty("cover_image")
        private String coverImage;

        private String description;

        private String facebook;

        @JsonProperty("faceit_url")
        private String faceitUrl;

        private String game;

        private String leader;

        private List<Member> members;

        private String name;

        private String nickname;

        @JsonProperty("team_id")
        private String teamId;

        @JsonProperty("team_type")
        private String teamType;

        private String twitter;

        private String website;

        private String youtube;

        @Override
        public String getAvatar() {
            return avatar;
        }

        @Override
        public String getChatRoomId() {
            return chatRoomId;
        }

        @Override
        public String getCoverImage() {
            return coverImage;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public String getFacebook() {
            return facebook;
        }

        @Override
        public String getFaceitUrl() {
            return faceitUrl;
        }

        @Override
        public String getGame() {
            return game;
        }

        @Override
        public String getLeader() {
            return leader;
        }

        @Override
        public List<Member> getMembers() {
            return members;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getNickname() {
            return nickname;
        }

        @Override
        public String getTeamId() {
            return teamId;
        }

        @Override
        public String getTeamType() {
            return teamType;
        }

        @Override
        public String getTwitter() {
            return twitter;
        }

        @Override
        public String getWebsite() {
            return website;
        }

        @Override
        public String getYoutube() {
            return youtube;
        }

        /**
         * Implementation class for the Member interface.
         */
        public static class MemberImpl implements Member {

            private String avatar;

            private String country;

            @JsonProperty("faceit_url")
            private String faceitUrl;

            @JsonProperty("membership_type")
            private String membershipType;

            private List<String> memberships;

            private String nickname;

            @JsonProperty("skill_level")
            private int skillLevel;

            @JsonProperty("user_id")
            private String userId;

            @Override
            public String getAvatar() {
                return avatar;
            }

            @Override
            public String getCountry() {
                return country;
            }

            @Override
            public String getFaceitUrl() {
                return faceitUrl;
            }

            @Override
            public String getMembershipType() {
                return membershipType;
            }

            @Override
            public List<String> getMemberships() {
                return memberships;
            }

            @Override
            public String getNickname() {
                return nickname;
            }

            @Override
            public int getSkillLevel() {
                return skillLevel;
            }

            @Override
            public String getUserId() {
                return userId;
            }
        }
    }
}