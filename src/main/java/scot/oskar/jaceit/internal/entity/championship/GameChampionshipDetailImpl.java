package scot.oskar.jaceit.internal.entity.championship;

import com.fasterxml.jackson.annotation.JsonProperty;
import scot.oskar.jaceit.api.entity.championship.GameChampionshipDetail;

import java.util.List;

public class GameChampionshipDetailImpl implements GameChampionshipDetail {

    @JsonProperty("anticheat_required")
    private boolean isAntiCheatRequired;

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
    private boolean isCheckinEnabled;

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
    private boolean isFeatured;

    @JsonProperty("full")
    private boolean isFull;

    @Override
    public boolean isAntiCheatRequired() {
        return isAntiCheatRequired;
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
        return isCheckinEnabled;
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
        return isFeatured;
    }

    @Override
    public boolean isFull() {
        return isFull;
    }

    @Override
    public GameData getGameData() {
        return null;
    }

    @Override
    public String getGameId() {
        return "";
    }

    @Override
    public String getId() {
        return "";
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getOrganizerId() {
        return "";
    }

    @Override
    public List<Prize> getPrizes() {
        return List.of();
    }

    @Override
    public String getRegion() {
        return "";
    }

    @Override
    public String getRulesId() {
        return "";
    }

    @Override
    public Screening getScreening() {
        return null;
    }

    @Override
    public String getSeedingStrategy() {
        return "";
    }

    @Override
    public int getSlots() {
        return 0;
    }

    @Override
    public String getStatus() {
        return "";
    }

    @Override
    public Stream getStream() {
        return null;
    }

    @Override
    public long getSubscriptionEnd() {
        return 0;
    }

    @Override
    public long getSubscriptionStart() {
        return 0;
    }

    @Override
    public boolean isSubscriptionsLocked() {
        return false;
    }

    @Override
    public SubstitutionConfiguration getSubstitutionConfiguration() {
        return null;
    }

    @Override
    public int getTotalGroups() {
        return 0;
    }

    @Override
    public int getTotalPrizes() {
        return 0;
    }

    @Override
    public int getTotalRounds() {
        return 0;
    }

    @Override
    public String getType() {
        return "";
    }
}
