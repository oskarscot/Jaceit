package scot.oskar.jaceit.api.entity.championship;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import scot.oskar.jaceit.internal.entity.championship.GameChampionshipDetailImpl;

import java.util.List;
import java.util.Map;

@JsonDeserialize(as = GameChampionshipDetailImpl.class)
public interface GameChampionshipDetail {

    boolean isAntiCheatRequired();

    String getAvatar();

    String getBackgroundImage();

    String getChampionshipId();

    long getChampionshipStart();

    long getCheckinClear();

    boolean isCheckinEnabled();

    long getCheckinStart();

    String getCoverImage();

    int getCurrentSubscriptions();

    String getDescription();

    String getFaceitUrl();

    boolean isFeatured();

    boolean isFull();

    GameData getGameData();

    String getGameId();

    String getId();

    String getName();

    String getOrganizerId();

    List<Prize> getPrizes();

    String getRegion();

    String getRulesId();

    Screening getScreening();

    String getSeedingStrategy();

    int getSlots();

    String getStatus();

    Stream getStream();

    long getSubscriptionEnd();

    long getSubscriptionStart();

    boolean isSubscriptionsLocked();

    SubstitutionConfiguration getSubstitutionConfiguration();

    int getTotalGroups();

    int getTotalPrizes();

    int getTotalRounds();

    String getType();

    interface GameData {

        Assets getAssets();

        String getGameId();

        String getLongLabel();

        int getOrder();

        String getParentGameId();

        List<String> getPlatforms();

        List<String> getRegions();

        String getShortLabel();

        interface Assets {

            String getCover();

            String getFeaturedImgL();

            String getFeaturedImgM();

            String getFeaturedImgS();

            String getFlagImgIcon();

            String getFlagImgL();

            String getFlagImgM();

            String getFlagImgS();

            String getLandingPage();
        }
    }

    interface JoinChecks {

        List<String> getAllowedTeamTypes();

        List<String> getBlacklistGeoCountries();

        String getJoinPolicy();

        int getMaxSkillLevel();

        String getMembershipType();

        int getMinSkillLevel();

        List<String> getWhitelistGeoCountries();

        int getWhitelistGeoCountriesMinPlayers();
    }

    interface OrganizerData {

        String getAvatar();

        String getCover();

        String getDescription();

        String getFacebook();

        String getFaceitUrl();

        int getFollowersCount();

        String getName();

        String getOrganizerId();

        String getTwitch();

        String getTwitter();

        String getType();

        String getVk();

        String getWebsite();

        String getYoutube();
    }

    interface Prize {

        int getFaceitPoints();

        int getRank();
    }

    interface Schedule {

        Map<String, MatchSchedule> getSchedule();

        interface MatchSchedule {

            long getDate();

            String getStatus();
        }
    }

    interface Screening {

        boolean isEnabled();

        String getId();
    }

    interface Stream {

        boolean isActive();

        String getPlatform();

        String getSource();

        String getTitle();
    }

    interface SubstitutionConfiguration {

        int getMaxSubstitutes();

        int getMaxSubstitutions();
    }
}
