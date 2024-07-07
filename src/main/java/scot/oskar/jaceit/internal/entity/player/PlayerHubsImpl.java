package scot.oskar.jaceit.internal.entity.player;

import com.fasterxml.jackson.annotation.JsonProperty;
import scot.oskar.jaceit.api.entity.player.PlayerHubs;

import java.util.List;

public class PlayerHubsImpl implements PlayerHubs {

    @JsonProperty("items")
    private List<Hub> hubs;

    // Offset must be a multiple of limit, limit has to be specified if offset is specified
    @JsonProperty("start")
    private int offset;

    @JsonProperty("end")
    private int limit;

    public static class HubImpl implements PlayerHubs.Hub {

        @JsonProperty("hub_id")
        private String hubId;

        private String name;
        private String avatar;

        @JsonProperty("game_id")
        private String gameId;

        @JsonProperty("organizer_id")
        private String organizerId;

        @JsonProperty("faceit_url")
        private String faceitUrl;

        public String getAvatar() {
            return avatar;
        }

        public String getFaceitUrl() {
            return faceitUrl;
        }

        public String getGameId() {
            return gameId;
        }

        public String getHubId() {
            return hubId;
        }

        public String getName() {
            return name;
        }

        public String getOrganizerId() {
            return organizerId;
        }
    }

    public List<Hub> getHubs() {
        return hubs;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }
}
