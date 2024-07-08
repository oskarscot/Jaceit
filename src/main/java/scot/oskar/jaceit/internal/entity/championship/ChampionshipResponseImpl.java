package scot.oskar.jaceit.internal.entity.championship;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import scot.oskar.jaceit.api.entity.championship.ChampionshipResponse;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChampionshipResponseImpl implements ChampionshipResponse {

    @JsonProperty("end")
    private long end;

    @JsonProperty("items")
    private List<Championship> items;

    @JsonProperty("start")
    private long start;

    @Override
    public long getEnd() {
        return end;
    }

    @Override
    public List<Championship> getItems() {
        return items;
    }

    @Override
    public long getStart() {
        return start;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ChampionshipImpl implements Championship {

        @JsonProperty("anticheat_required")
        private boolean anticheatRequired;

        @JsonProperty("avatar")
        private String avatar;

        @JsonProperty("background_image")
        private String backgroundImage;

        @JsonProperty("championship_id")
        private String championshipId;

        @JsonProperty("championship_start")
        private long championshipStart;

        @JsonProperty("checkin_clear")
        private long checkinClear;

        @JsonProperty("checkin_enabled")
        private boolean checkinEnabled;

        @JsonProperty("checkin_start")
        private long checkinStart;

        @JsonProperty("cover_image")
        private String coverImage;

        @JsonProperty("current_subscriptions")
        private int currentSubscriptions;

        @JsonProperty("description")
        private String description;

        @JsonProperty("faceit_url")
        private String faceitUrl;

        @JsonProperty("featured")
        private boolean featured;

        @JsonProperty("full")
        private boolean full;

        @JsonProperty("game_data")
        private GameDataImpl gameData;

        @JsonProperty("game_id")
        private String gameId;

        @JsonProperty("id")
        private String id;

        @JsonProperty("join_checks")
        private JoinChecksImpl joinChecks;

        @JsonProperty("name")
        private String name;

        @JsonProperty("organizer_data")
        private OrganizerDataImpl organizerData;

        @JsonProperty("organizer_id")
        private String organizerId;

        @JsonProperty("prizes")
        private List<Prize> prizes;

        @JsonProperty("region")
        private String region;

        @JsonProperty("rules_id")
        private String rulesId;

        @JsonProperty("schedule")
        private ScheduleImpl schedule;

        @JsonProperty("screening")
        private ScreeningImpl screening;

        @JsonProperty("seeding_strategy")
        private String seedingStrategy;

        @JsonProperty("slots")
        private int slots;

        @JsonProperty("status")
        private String status;

        @JsonProperty("stream")
        private StreamImpl stream;

        @JsonProperty("subscription_end")
        private long subscriptionEnd;

        @JsonProperty("subscription_start")
        private long subscriptionStart;

        @JsonProperty("subscriptions_locked")
        private boolean subscriptionsLocked;

        @JsonProperty("substitution_configuration")
        private SubstitutionConfigurationImpl substitutionConfiguration;

        @JsonProperty("total_groups")
        private int totalGroups;

        @JsonProperty("total_prizes")
        private int totalPrizes;

        @JsonProperty("total_rounds")
        private int totalRounds;

        @JsonProperty("type")
        private String type;

        @Override
        public boolean isAnticheatRequired() {
            return anticheatRequired;
        }

        @Override
        public String getAvatar() {
            return avatar;
        }

        @Override
        public String getBackgroundImage() {
            return backgroundImage;
        }

        @Override
        public String getChampionshipId() {
            return championshipId;
        }

        @Override
        public long getChampionshipStart() {
            return championshipStart;
        }

        @Override
        public long getCheckinClear() {
            return checkinClear;
        }

        @Override
        public boolean isCheckinEnabled() {
            return checkinEnabled;
        }

        @Override
        public long getCheckinStart() {
            return checkinStart;
        }

        @Override
        public String getCoverImage() {
            return coverImage;
        }

        @Override
        public int getCurrentSubscriptions() {
            return currentSubscriptions;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public String getFaceitUrl() {
            return faceitUrl;
        }

        @Override
        public boolean isFeatured() {
            return featured;
        }

        @Override
        public boolean isFull() {
            return full;
        }

        @Override
        public GameDataImpl getGameData() {
            return gameData;
        }

        @Override
        public String getGameId() {
            return gameId;
        }

        @Override
        public String getId() {
            return id;
        }

        @Override
        public JoinChecksImpl getJoinChecks() {
            return joinChecks;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public OrganizerDataImpl getOrganizerData() {
            return organizerData;
        }

        @Override
        public String getOrganizerId() {
            return organizerId;
        }

        @Override
        public List<Prize> getPrizes() {
            return prizes;
        }

        @Override
        public String getRegion() {
            return region;
        }

        @Override
        public String getRulesId() {
            return rulesId;
        }

        @Override
        public ScheduleImpl getSchedule() {
            return schedule;
        }

        @Override
        public ScreeningImpl getScreening() {
            return screening;
        }

        @Override
        public String getSeedingStrategy() {
            return seedingStrategy;
        }

        @Override
        public int getSlots() {
            return slots;
        }

        @Override
        public String getStatus() {
            return status;
        }

        @Override
        public StreamImpl getStream() {
            return stream;
        }

        @Override
        public long getSubscriptionEnd() {
            return subscriptionEnd;
        }

        @Override
        public boolean isSubscriptionsLocked() {
            return subscriptionsLocked;
        }

        @Override
        public long getSubscriptionStart() {
            return subscriptionStart;
        }

        @Override
        public SubstitutionConfigurationImpl getSubstitutionConfiguration() {
            return substitutionConfiguration;
        }

        @Override
        public int getTotalGroups() {
            return totalGroups;
        }

        @Override
        public int getTotalPrizes() {
            return totalPrizes;
        }

        @Override
        public int getTotalRounds() {
            return totalRounds;
        }

        @Override
        public String getType() {
            return type;
        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class GameDataImpl implements GameData {

            @JsonProperty("assets")
            private Assets assets;

            @JsonProperty("game_id")
            private String gameId;

            @JsonProperty("long_label")
            private String longLabel;

            @JsonProperty("order")
            private int order;

            @JsonProperty("parent_game_id")
            private String parentGameId;

            @JsonProperty("platforms")
            private List<String> platforms;

            @JsonProperty("regions")
            private List<String> regions;

            @JsonProperty("short_label")
            private String shortLabel;


            @Override
            public Assets getAssets() {
                return assets;
            }

            @Override
            public String getGameId() {
                return gameId;
            }

            @Override
            public String getLongLabel() {
                return longLabel;
            }

            @Override
            public int getOrder() {
                return order;
            }

            @Override
            public String getParentGameId() {
                return parentGameId;
            }

            @Override
            public List<String> getPlatforms() {
                return platforms;
            }

            @Override
            public List<String> getRegions() {
                return regions;
            }

            @Override
            public String getShortLabel() {
                return shortLabel;
            }

            @JsonInclude(JsonInclude.Include.NON_NULL)
            public static class AssetsImpl implements Assets {

                @JsonProperty("cover")
                private String cover;

                @JsonProperty("featured_img_l")
                private String featuredImgL;

                @JsonProperty("featured_img_m")
                private String featuredImgM;

                @JsonProperty("featured_img_s")
                private String featuredImgS;

                @JsonProperty("flag_img_icon")
                private String flagImgIcon;

                @JsonProperty("flag_img_l")
                private String flagImgL;

                @JsonProperty("flag_img_m")
                private String flagImgM;

                @JsonProperty("flag_img_s")
                private String flagImgS;

                @JsonProperty("landing_page")
                private String landingPage;

                @Override
                public String getCover() {
                    return cover;
                }

                @Override
                public String getFeaturedImgL() {
                    return featuredImgL;
                }

                @Override
                public String getFeaturedImgM() {
                    return featuredImgM;
                }

                @Override
                public String getFeaturedImgS() {
                    return featuredImgS;
                }

                @Override
                public String getFlagImgIcon() {
                    return flagImgIcon;
                }

                @Override
                public String getFlagImgL() {
                    return flagImgL;
                }

                @Override
                public String getFlagImgM() {
                    return flagImgM;
                }

                @Override
                public String getFlagImgS() {
                    return flagImgS;
                }

                @Override
                public String getLandingPage() {
                    return landingPage;
                }
            }
        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class JoinChecksImpl implements JoinChecks {

            @JsonProperty("allowed_team_types")
            private List<String> allowedTeamTypes;

            @JsonProperty("blacklist_geo_countries")
            private List<String> blacklistGeoCountries;

            @JsonProperty("join_policy")
            private String joinPolicy;

            @JsonProperty("max_skill_level")
            private int maxSkillLevel;

            @JsonProperty("membership_type")
            private String membershipType;

            @JsonProperty("min_skill_level")
            private int minSkillLevel;

            @JsonProperty("whitelist_geo_countries")
            private List<String> whitelistGeoCountries;

            @JsonProperty("whitelist_geo_countries_min_players")
            private int whitelistGeoCountriesMinPlayers;

            @Override
            public List<String> getAllowedTeamTypes() {
                return allowedTeamTypes;
            }

            @Override
            public List<String> getBlacklistGeoCountries() {
                return blacklistGeoCountries;
            }

            @Override
            public String getJoinPolicy() {
                return joinPolicy;
            }

            @Override
            public int getMaxSkillLevel() {
                return maxSkillLevel;
            }

            @Override
            public String getMembershipType() {
                return membershipType;
            }

            @Override
            public int getMinSkillLevel() {
                return minSkillLevel;
            }

            @Override
            public List<String> getWhitelistGeoCountries() {
                return whitelistGeoCountries;
            }

            @Override
            public int getWhitelistGeoCountriesMinPlayers() {
                return whitelistGeoCountriesMinPlayers;
            }
        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class OrganizerDataImpl implements OrganizerData {

            @JsonProperty("avatar")
            private String avatar;

            @JsonProperty("cover")
            private String cover;

            @JsonProperty("description")
            private String description;

            @JsonProperty("facebook")
            private String facebook;

            @JsonProperty("faceit_url")
            private String faceitUrl;

            @JsonProperty("followers_count")
            private int followersCount;

            @JsonProperty("name")
            private String name;

            @JsonProperty("organizer_id")
            private String organizerId;

            @JsonProperty("twitch")
            private String twitch;

            @JsonProperty("twitter")
            private String twitter;

            @JsonProperty("type")
            private String type;

            @JsonProperty("vk")
            private String vk;

            @JsonProperty("website")
            private String website;

            @JsonProperty("youtube")
            private String youtube;

            @Override
            public String getAvatar() {
                return avatar;
            }

            @Override
            public String getCover() {
                return cover;
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
            public int getFollowersCount() {
                return followersCount;
            }

            @Override
            public String getName() {
                return name;
            }

            @Override
            public String getOrganizerId() {
                return organizerId;
            }

            @Override
            public String getTwitch() {
                return twitch;
            }

            @Override
            public String getTwitter() {
                return twitter;
            }

            @Override
            public String getType() {
                return type;
            }

            @Override
            public String getVk() {
                return vk;
            }

            @Override
            public String getWebsite() {
                return website;
            }

            @Override
            public String getYoutube() {
                return youtube;
            }
        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class PrizeImpl implements Prize {

            @JsonProperty("faceit_points")
            private int faceitPoints;

            @JsonProperty("rank")
            private int rank;

            @Override
            public int getFaceitPoints() {
                return faceitPoints;
            }

            @Override
            public int getRank() {
                return rank;
            }
        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class ScheduleImpl implements Schedule {

            @JsonProperty("match_schedule")
            private Map<String, MatchSchedule> matchSchedule;


            @Override
            public Map<String, MatchSchedule> getSchedule() {
                return matchSchedule;
            }

        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class ScreeningImpl implements Screening {

            @JsonProperty("enabled")
            private boolean enabled;

            @JsonProperty("id")
            private String id;

            @Override
            public boolean isEnabled() {
                return enabled;
            }

            @Override
            public String getId() {
                return id;
            }
        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class StreamImpl implements Stream {

            @JsonProperty("active")
            private boolean active;

            @JsonProperty("platform")
            private String platform;

            @JsonProperty("source")
            private String source;

            @JsonProperty("title")
            private String title;

            @Override
            public boolean isActive() {
                return active;
            }

            @Override
            public String getPlatform() {
                return platform;
            }

            @Override
            public String getSource() {
                return source;
            }

            @Override
            public String getTitle() {
                return title;
            }
        }

        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class SubstitutionConfigurationImpl implements SubstitutionConfiguration {

            @JsonProperty("max_substitutes")
            private int maxSubstitutes;

            @JsonProperty("max_substitutions")
            private int maxSubstitutions;

            @Override
            public int getMaxSubstitutes() {
                return maxSubstitutes;
            }

            @Override
            public int getMaxSubstitutions() {
                return maxSubstitutions;
            }
        }
    }
}