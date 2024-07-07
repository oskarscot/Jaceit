package scot.oskar.jaceit.internal.entity.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import scot.oskar.jaceit.api.entity.player.PlayerProfile;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerProfileImpl implements PlayerProfile {

    @JsonProperty("player_id")
    private String playerId;

    private String nickname;
    private String avatar;
    private String country;

    @JsonProperty("cover_image")
    private String coverImage;

    private Platforms platforms;
    private Map<String, Game> games;
    private Settings settings;

    @JsonProperty("friends_ids")
    private List<String> friendsIds;

    @JsonProperty("new_steam_id")
    private String newSteamId;

    @JsonProperty("steam_id_64")
    private String steamId64;

    @JsonProperty("steam_nickname")
    private String steamNickname;

    private List<String> memberships;

    @JsonProperty("faceit_url")
    private String faceitUrl;

    @JsonProperty("membership_type")
    private String membershipType;

    @JsonProperty("cover_featured_image")
    private String coverFeaturedImage;

    private Map<String, Object> infractions;
    private boolean verified;

    @JsonProperty("activated_at")
    private String activatedAt;

    public String getPlayerId() {
        return playerId;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getCountry() {
        return country;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public Platforms getPlatforms() {
        return platforms;
    }

    public Map<String, Game> getGames() {
        return games;
    }

    public Settings getSettings() {
        return settings;
    }

    public List<String> getFriendsIds() {
        return friendsIds;
    }

    public String getNewSteamId() {
        return newSteamId;
    }

    public String getSteamId64() {
        return steamId64;
    }

    public String getSteamNickname() {
        return steamNickname;
    }

    public List<String> getMemberships() {
        return memberships;
    }

    public String getFaceitUrl() {
        return faceitUrl;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public String getCoverFeaturedImage() {
        return coverFeaturedImage;
    }

    public Map<String, Object> getInfractions() {
        return infractions;
    }

    public boolean isVerified() {
        return verified;
    }

    public String getActivatedAt() {
        return activatedAt;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PlatformsImpl implements Platforms {
        private String steam;

        public String getSteam() {
            return steam;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GameImpl implements Game {
        private String region;

        @JsonProperty("game_player_id")
        private String gamePlayerId;

        @JsonProperty("skill_level")
        private int skillLevel;

        @JsonProperty("faceit_elo")
        private int faceitElo;

        @JsonProperty("game_player_name")
        private String gamePlayerName;

        @JsonProperty("skill_level_label")
        private String skillLevelLabel;

        private Map<String, Object> regions;

        @JsonProperty("game_profile_id")
        private String gameProfileId;

        public String getRegion() {
            return region;
        }

        public String getGamePlayerId() {
            return gamePlayerId;
        }

        public int getSkillLevel() {
            return skillLevel;
        }

        public int getFaceitElo() {
            return faceitElo;
        }

        public String getGamePlayerName() {
            return gamePlayerName;
        }

        public String getSkillLevelLabel() {
            return skillLevelLabel;
        }

        public Map<String, Object> getRegions() {
            return regions;
        }

        public String getGameProfileId() {
            return gameProfileId;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SettingsImpl implements Settings {
        private String language;

        public String getLanguage() {
            return language;
        }
    }
}