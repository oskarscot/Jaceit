package scot.oskar.jaceit.api.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import scot.oskar.jaceit.internal.entity.PlayerProfileImpl;

import java.util.List;
import java.util.Map;

@JsonDeserialize(as = PlayerProfileImpl.class)
public interface PlayerProfile {
    String getPlayerId();
    String getNickname();
    String getAvatar();
    String getCountry();
    String getCoverImage();
    Platforms getPlatforms();
    Map<String, Game> getGames();
    Settings getSettings();
    List<String> getFriendsIds();
    String getNewSteamId();
    String getSteamId64();
    String getSteamNickname();
    List<String> getMemberships();
    String getFaceitUrl();
    String getMembershipType();
    String getCoverFeaturedImage();
    Map<String, Object> getInfractions();
    boolean isVerified();
    String getActivatedAt();

    @JsonDeserialize(as = PlayerProfileImpl.PlatformsImpl.class)
    interface Platforms {
        String getSteam();
    }

    @JsonDeserialize(as = PlayerProfileImpl.GameImpl.class)
    interface Game {
        String getRegion();
        String getGamePlayerId();
        int getSkillLevel();
        int getFaceitElo();
        String getGamePlayerName();
        String getSkillLevelLabel();
        Map<String, Object> getRegions();
        String getGameProfileId();
    }

    @JsonDeserialize(as = PlayerProfileImpl.SettingsImpl.class)
    interface Settings {
        String getLanguage();
    }
}