package scot.oskar.jaceit.api.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import scot.oskar.jaceit.internal.entity.PlayerBansImpl;
import java.util.List;

/**
 * Represents the structure of a response containing player ban information.
 * This interface defines the methods to access the details of the bans included in the response.
 * The implementation class for this interface is {@link PlayerBansImpl}.
 */
@JsonDeserialize(as = PlayerBansImpl.class)
public interface PlayerBans {

    /**
     * Retrieves the list of bans associated with the player.
     *
     * @return a list of {@link Ban} instances.
     */
    List<Ban> getBans();

    /**
     * Retrieves the end offset of the bans.
     *
     * @return an integer representing the end offset.
     */
    int getEnd();

    /**
     * Retrieves the start offset of the bans.
     *
     * @return an integer representing the start offset.
     */
    int getStart();

    /**
     * Represents the details of an individual ban associated with a player.
     * This interface defines the methods to access the properties of a ban.
     * The implementation class for this interface is {@link PlayerBansImpl.BanImpl}.
     */
    @JsonDeserialize(as = PlayerBansImpl.BanImpl.class)
    interface Ban {

        /**
         * Retrieves the end date and time of the ban.
         *
         * @return a string representing the end date and time.
         */
        String getEndsAt();

        /**
         * Retrieves the game associated with the ban.
         *
         * @return a string representing the game.
         */
        String getGame();

        /**
         * Retrieves the nickname of the player who is banned.
         *
         * @return a string representing the player's nickname.
         */
        String getNickname();

        /**
         * Retrieves the reason for the ban.
         *
         * @return a string representing the reason for the ban.
         */
        String getReason();

        /**
         * Retrieves the start date and time of the ban.
         *
         * @return a string representing the start date and time.
         */
        String getStartsAt();

        /**
         * Retrieves the type of the ban.
         *
         * @return a string representing the type of the ban.
         */
        String getType();

        /**
         * Retrieves the user ID of the banned player.
         *
         * @return a string representing the user ID.
         */
        String getUserId();
    }
}