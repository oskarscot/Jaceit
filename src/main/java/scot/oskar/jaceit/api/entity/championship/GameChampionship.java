package scot.oskar.jaceit.api.entity.championship;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import scot.oskar.jaceit.internal.entity.championship.GameChampionshipImpl;

import java.util.List;
import java.util.Map;

@JsonDeserialize(as = GameChampionshipImpl.class)
public interface GameChampionship {

    long getEnd();

    List<Championship> getItems();

    long getStart();

    @JsonDeserialize(as = GameChampionshipImpl.ChampionshipImpl.class)
    interface Championship {

        boolean isAnticheatRequired();

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

        JoinChecks getJoinChecks();

        String getName();

        OrganizerData getOrganizerData();

        String getOrganizerId();

        List<Prize> getPrizes();

        String getRegion();

        String getRulesId();

        Schedule getSchedule();

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

        @JsonDeserialize(as = GameChampionshipImpl.ChampionshipImpl.GameDataImpl.class)
        interface GameData {

            Assets getAssets();

            String getGameId();

            String getLongLabel();

            int getOrder();

            String getParentGameId();

            List<String> getPlatforms();

            List<String> getRegions();

            String getShortLabel();

            @JsonDeserialize(as = GameChampionshipImpl.ChampionshipImpl.GameDataImpl.AssetsImpl.class)
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

        @JsonDeserialize(as = GameChampionshipImpl.ChampionshipImpl.JoinChecksImpl.class)
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

        @JsonDeserialize(as = GameChampionshipImpl.ChampionshipImpl.OrganizerDataImpl.class)
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

        @JsonDeserialize(as = GameChampionshipImpl.ChampionshipImpl.PrizeImpl.class)
        interface Prize {

            int getFaceitPoints();

            int getRank();
        }

        @JsonDeserialize(as = GameChampionshipImpl.ChampionshipImpl.ScheduleImpl.class)
        interface Schedule {

            Map<String, MatchSchedule> getSchedule();

            interface MatchSchedule {

                long getDate();

                String getStatus();
            }
        }

        @JsonDeserialize(as = GameChampionshipImpl.ChampionshipImpl.ScreeningImpl.class)
        interface Screening {

            boolean isEnabled();

            String getId();
        }

        @JsonDeserialize(as = GameChampionshipImpl.ChampionshipImpl.StreamImpl.class)
        interface Stream {

            boolean isActive();

            String getPlatform();

            String getSource();

            String getTitle();
        }

        @JsonDeserialize(as = GameChampionshipImpl.ChampionshipImpl.SubstitutionConfigurationImpl.class)
        interface SubstitutionConfiguration {

            int getMaxSubstitutes();

            int getMaxSubstitutions();
        }
    }
}