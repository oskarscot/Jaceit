package scot.oskar.jaceit.api.entity.player;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import scot.oskar.jaceit.internal.entity.player.PlayerHubsImpl;

import java.util.List;

/**
 * Represents the structure of a response containing player hub information.
 * This interface defines the methods to access the details of the hubs included in the response.
 * The implementation class for this interface is {@link PlayerHubsImpl}.
 */
@JsonDeserialize(as = PlayerHubsImpl.class)
public interface PlayerHubs {

    /**
     * Retrieves the list of hubs associated with the player.
     *
     * @return a list of {@link Hub} instances.
     */
    List<Hub> getHubs();

    /**
     * Retrieves the limit on the number of hubs returned.
     *
     * @return an integer representing the limit.
     */
    int getLimit();

    /**
     * Retrieves the offset for the list of hubs.
     *
     * @return an integer representing the offset.
     */
    int getOffset();

    /**
     * Represents the details of an individual hub associated with a player.
     * This interface defines the methods to access the properties of a hub.
     * The implementation class for this interface is {@link PlayerHubsImpl.HubImpl}.
     */
    @JsonDeserialize(as = PlayerHubsImpl.HubImpl.class)
    interface Hub {

        /**
         * Retrieves the avatar URL of the hub.
         *
         * @return a string representing the avatar URL.
         */
        String getAvatar();

        /**
         * Retrieves the Faceit URL of the hub.
         *
         * @return a string representing the Faceit URL.
         */
        String getFaceitUrl();

        /**
         * Retrieves the game ID associated with the hub.
         *
         * @return a string representing the game ID.
         */
        String getGameId();

        /**
         * Retrieves the hub ID.
         *
         * @return a string representing the hub ID.
         */
        String getHubId();

        /**
         * Retrieves the name of the hub.
         *
         * @return a string representing the name of the hub.
         */
        String getName();

        /**
         * Retrieves the organizer ID of the hub.
         *
         * @return a string representing the organizer ID.
         */
        String getOrganizerId();
    }
}