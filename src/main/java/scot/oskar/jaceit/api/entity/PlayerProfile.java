package scot.oskar.jaceit.api.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import scot.oskar.jaceit.internal.entity.PlayerProfileImpl;

import java.util.List;
import java.util.Map;

/**
 * Represents the structure of a player's profile information.
 * This interface defines the methods to access the details of the player's profile.
 * The implementation class for this interface is {@link PlayerProfileImpl}.
 */
@JsonDeserialize(as = PlayerProfileImpl.class)
public interface PlayerProfile {

    /**
     * Retrieves the player's unique identifier.
     *
     * @return a string representing the player's ID.
     */
    String getPlayerId();

    /**
     * Retrieves the player's nickname.
     *
     * @return a string representing the player's nickname.
     */
    String getNickname();

    /**
     * Retrieves the URL of the player's avatar.
     *
     * @return a string representing the avatar URL.
     */
    String getAvatar();

    /**
     * Retrieves the player's country.
     *
     * @return a string representing the player's country.
     */
    String getCountry();

    /**
     * Retrieves the URL of the player's cover image.
     *
     * @return a string representing the cover image URL.
     */
    String getCoverImage();

    /**
     * Retrieves the player's platform information.
     *
     * @return a {@link Platforms} instance representing the player's platforms.
     */
    Platforms getPlatforms();

    /**
     * Retrieves the player's game information.
     *
     * @return a map where the key is the game identifier and the value is the {@link Game} instance.
     */
    Map<String, Game> getGames();

    /**
     * Retrieves the player's settings.
     *
     * @return a {@link Settings} instance representing the player's settings.
     */
    Settings getSettings();

    /**
     * Retrieves the list of IDs of the player's friends.
     *
     * @return a list of strings representing the friends' IDs.
     */
    List<String> getFriendsIds();

    /**
     * Retrieves the player's new Steam ID.
     *
     * @return a string representing the new Steam ID.
     */
    String getNewSteamId();

    /**
     * Retrieves the player's 64-bit Steam ID.
     *
     * @return a string representing the 64-bit Steam ID.
     */
    String getSteamId64();

    /**
     * Retrieves the player's Steam nickname.
     *
     * @return a string representing the Steam nickname.
     */
    String getSteamNickname();

    /**
     * Retrieves the list of the player's memberships.
     *
     * @return a list of strings representing the memberships.
     */
    List<String> getMemberships();

    /**
     * Retrieves the URL to the player's profile on Faceit.
     *
     * @return a string representing the Faceit URL.
     */
    String getFaceitUrl();

    /**
     * Retrieves the type of membership the player has.
     *
     * @return a string representing the membership type.
     */
    String getMembershipType();

    /**
     * Retrieves the URL of the player's featured cover image.
     *
     * @return a string representing the featured cover image URL.
     */
    String getCoverFeaturedImage();

    /**
     * Retrieves the player's infractions.
     *
     * @return a map where the key is the infraction identifier and the value is the infraction details.
     */
    Map<String, Object> getInfractions();

    /**
     * Checks if the player's profile is verified.
     *
     * @return true if the profile is verified, false otherwise.
     */
    boolean isVerified();

    /**
     * Retrieves the activation date of the player's profile.
     *
     * @return a string representing the activation date.
     */
    String getActivatedAt();

    /**
     * Represents the platforms associated with the player's profile.
     * This interface defines the methods to access the platform details.
     * The implementation class for this interface is {@link PlayerProfileImpl.PlatformsImpl}.
     */
    @JsonDeserialize(as = PlayerProfileImpl.PlatformsImpl.class)
    interface Platforms {
        /**
         * Retrieves the player's Steam ID.
         *
         * @return a string representing the Steam ID.
         */
        String getSteam();
    }

    /**
     * Represents the game details associated with the player's profile.
     * This interface defines the methods to access the game properties.
     * The implementation class for this interface is {@link PlayerProfileImpl.GameImpl}.
     */
    @JsonDeserialize(as = PlayerProfileImpl.GameImpl.class)
    interface Game {
        /**
         * Retrieves the region associated with the game.
         *
         * @return a string representing the region.
         */
        String getRegion();

        /**
         * Retrieves the player's ID in the game.
         *
         * @return a string representing the game player ID.
         */
        String getGamePlayerId();

        /**
         * Retrieves the player's skill level in the game.
         *
         * @return an integer representing the skill level.
         */
        int getSkillLevel();

        /**
         * Retrieves the player's Faceit Elo rating in the game.
         *
         * @return an integer representing the Faceit Elo rating.
         */
        int getFaceitElo();

        /**
         * Retrieves the player's name in the game.
         *
         * @return a string representing the game player name.
         */
        String getGamePlayerName();

        /**
         * Retrieves the label of the player's skill level.
         *
         * @return a string representing the skill level label.
         */
        String getSkillLevelLabel();

        /**
         * Retrieves the regions associated with the game.
         *
         * @return a map where the key is the region identifier and the value is the region details.
         */
        Map<String, Object> getRegions();

        /**
         * Retrieves the game profile ID.
         *
         * @return a string representing the game profile ID.
         */
        String getGameProfileId();
    }

    /**
     * Represents the settings associated with the player's profile.
     * This interface defines the methods to access the settings properties.
     * The implementation class for this interface is {@link PlayerProfileImpl.SettingsImpl}.
     */
    @JsonDeserialize(as = PlayerProfileImpl.SettingsImpl.class)
    interface Settings {
        /**
         * Retrieves the player's preferred language.
         *
         * @return a string representing the language.
         */
        String getLanguage();
    }
}