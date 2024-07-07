package scot.oskar.jaceit.api.entity.player;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import scot.oskar.jaceit.internal.entity.player.PlayerTeamsImpl;

import java.util.List;

/**
 * Represents the structure of team details information.
 * This interface defines the methods to access the team details.
 * The implementation class for this interface is {@link PlayerTeamsImpl}.
 */
@JsonDeserialize(as = PlayerTeamsImpl.class)
public interface PlayerTeams {

    /**
     * Retrieves the end value.
     *
     * @return an integer representing the end value.
     */
    int getEnd();

    /**
     * Retrieves the list of items associated with the team details.
     *
     * @return a list of {@link TeamDetails} instances representing the teams.
     */
    List<TeamDetails> getTeamDetails();

    /**
     * Retrieves the start value.
     *
     * @return an integer representing the start value.
     */
    int getStart();

    /**
     * Represents an item associated with the team details.
     * This interface defines the methods to access the item details.
     * The implementation class for this interface is {@link PlayerTeamsImpl.TeamDetailsImpl}.
     */
    @JsonDeserialize(as = PlayerTeamsImpl.TeamDetailsImpl.class)
    interface TeamDetails {

        /**
         * Retrieves the avatar URL.
         *
         * @return a string representing the avatar URL.
         */
        String getAvatar();

        /**
         * Retrieves the chat room ID.
         *
         * @return a string representing the chat room ID.
         */
        String getChatRoomId();

        /**
         * Retrieves the cover image URL.
         *
         * @return a string representing the cover image URL.
         */
        String getCoverImage();

        /**
         * Retrieves the description.
         *
         * @return a string representing the description.
         */
        String getDescription();

        /**
         * Retrieves the Facebook URL.
         *
         * @return a string representing the Facebook URL.
         */
        String getFacebook();

        /**
         * Retrieves the Faceit URL.
         *
         * @return a string representing the Faceit URL.
         */
        String getFaceitUrl();

        /**
         * Retrieves the game.
         *
         * @return a string representing the game.
         */
        String getGame();

        /**
         * Retrieves the leader.
         *
         * @return a string representing the leader.
         */
        String getLeader();

        /**
         * Retrieves the list of members.
         *
         * @return a list of {@link Member} instances representing the members.
         */
        List<Member> getMembers();

        /**
         * Retrieves the name.
         *
         * @return a string representing the name.
         */
        String getName();

        /**
         * Retrieves the nickname.
         *
         * @return a string representing the nickname.
         */
        String getNickname();

        /**
         * Retrieves the team ID.
         *
         * @return a string representing the team ID.
         */
        String getTeamId();

        /**
         * Retrieves the team type.
         *
         * @return a string representing the team type.
         */
        String getTeamType();

        /**
         * Retrieves the Twitter URL.
         *
         * @return a string representing the Twitter URL.
         */
        String getTwitter();

        /**
         * Retrieves the website URL.
         *
         * @return a string representing the website URL.
         */
        String getWebsite();

        /**
         * Retrieves the YouTube URL.
         *
         * @return a string representing the YouTube URL.
         */
        String getYoutube();

        /**
         * Represents a member associated with the item.
         * This interface defines the methods to access the member details.
         * The implementation class for this interface is {@link PlayerTeamsImpl.TeamDetailsImpl.MemberImpl}.
         */
        @JsonDeserialize(as = PlayerTeamsImpl.TeamDetailsImpl.MemberImpl.class)
        interface Member {

            /**
             * Retrieves the avatar URL.
             *
             * @return a string representing the avatar URL.
             */
            String getAvatar();

            /**
             * Retrieves the country.
             *
             * @return a string representing the country.
             */
            String getCountry();

            /**
             * Retrieves the Faceit URL.
             *
             * @return a string representing the Faceit URL.
             */
            String getFaceitUrl();

            /**
             * Retrieves the membership type.
             *
             * @return a string representing the membership type.
             */
            String getMembershipType();

            /**
             * Retrieves the list of memberships.
             *
             * @return a list of strings representing the memberships.
             */
            List<String> getMemberships();

            /**
             * Retrieves the nickname.
             *
             * @return a string representing the nickname.
             */
            String getNickname();

            /**
             * Retrieves the skill level.
             *
             * @return an integer representing the skill level.
             */
            int getSkillLevel();

            /**
             * Retrieves the user ID.
             *
             * @return a string representing the user ID.
             */
            String getUserId();
        }
    }
}