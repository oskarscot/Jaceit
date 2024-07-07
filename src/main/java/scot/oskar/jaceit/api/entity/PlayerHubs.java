package scot.oskar.jaceit.api.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import scot.oskar.jaceit.internal.entity.PlayerHubsImpl;

import java.util.List;

@JsonDeserialize(as = PlayerHubsImpl.class)
public interface PlayerHubs {

    List<Hub> getHubs();

    int getLimit();

    int getOffset();

    @JsonDeserialize(as = PlayerHubsImpl.HubImpl.class)
    interface Hub {
        String getAvatar();
        String getFaceitUrl();
        String getGameId();
        String getHubId();
        String getName();
        String getOrganizerId();
    }
}
