package scot.oskar.jaceit.api.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import scot.oskar.jaceit.internal.entity.PlayerTournamentsImpl;

import java.util.List;

/**
 * Interface representing the player tournaments.
 */
@JsonDeserialize(as = PlayerTournamentsImpl.class)
public interface PlayerTournaments {

    /**
     * Gets the end value.
     *
     * @return the end value.
     */
    int getEnd();

    /**
     * Gets the list of tournament details.
     *
     * @return the list of tournament details.
     */
    List<TournamentDetails> getTournamentDetails();

    /**
     * Gets the start value.
     *
     * @return the start value.
     */
    int getStart();

    /**
     * Interface representing the tournament details.
     */
    @JsonDeserialize(as = PlayerTournamentsImpl.TournamentDetailsImpl.class)
    interface TournamentDetails {

        /**
         * Checks if anti-cheat is required.
         *
         * @return true if anti-cheat is required, false otherwise.
         */
        boolean isAnticheatRequired();

        /**
         * Checks if the tournament is custom.
         *
         * @return true if the tournament is custom, false otherwise.
         */
        boolean isCustom();

        /**
         * Gets the Faceit URL.
         *
         * @return the Faceit URL.
         */
        String getFaceitUrl();

        /**
         * Gets the featured image URL.
         *
         * @return the featured image URL.
         */
        String getFeaturedImage();

        /**
         * Gets the game ID.
         *
         * @return the game ID.
         */
        String getGameId();

        /**
         * Gets the invite type.
         *
         * @return the invite type.
         */
        String getInviteType();

        /**
         * Gets the match type.
         *
         * @return the match type.
         */
        String getMatchType();

        /**
         * Gets the maximum skill level.
         *
         * @return the maximum skill level.
         */
        int getMaxSkill();

        /**
         * Gets the membership type.
         *
         * @return the membership type.
         */
        String getMembershipType();

        /**
         * Gets the minimum skill level.
         *
         * @return the minimum skill level.
         */
        int getMinSkill();

        /**
         * Gets the name of the tournament.
         *
         * @return the name of the tournament.
         */
        String getName();

        /**
         * Gets the number of players.
         *
         * @return the number of players.
         */
        int getNumberOfPlayers();

        /**
         * Gets the number of players checked in.
         *
         * @return the number of players checked in.
         */
        int getNumberOfPlayersCheckedIn();

        /**
         * Gets the number of players joined.
         *
         * @return the number of players joined.
         */
        int getNumberOfPlayersJoined();

        /**
         * Gets the number of participants.
         *
         * @return the number of participants.
         */
        int getNumberOfPlayersParticipants();

        /**
         * Gets the organizer ID.
         *
         * @return the organizer ID.
         */
        String getOrganizerId();

        /**
         * Gets the prize type.
         *
         * @return the prize type.
         */
        String getPrizeType();

        /**
         * Gets the region.
         *
         * @return the region.
         */
        String getRegion();

        /**
         * Gets the start time.
         *
         * @return the start time.
         */
        long getStartedAt();

        /**
         * Gets the status.
         *
         * @return the status.
         */
        String getStatus();

        /**
         * Gets the subscription count.
         *
         * @return the subscription count.
         */
        int getSubscriptionsCount();

        /**
         * Gets the team size.
         *
         * @return the team size.
         */
        int getTeamSize();

        /**
         * Gets the total prize.
         *
         * @return the total prize.
         */
        Object getTotalPrize();

        /**
         * Gets the tournament ID.
         *
         * @return the tournament ID.
         */
        String getTournamentId();

        /**
         * Gets the list of whitelisted countries.
         *
         * @return the list of whitelisted countries.
         */
        List<String> getWhitelistCountries();
    }
}