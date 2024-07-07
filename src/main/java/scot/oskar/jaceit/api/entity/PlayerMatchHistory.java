package scot.oskar.jaceit.api.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import scot.oskar.jaceit.internal.entity.PlayerMatchHistoryImpl;

import java.util.List;
import java.util.Map;

@JsonDeserialize(as = PlayerMatchHistoryImpl.class)
public interface PlayerMatchHistory {

    List<Match> getMatches();

    int getOffset();

    int getLimit();

    int getFrom();

    int getTo();

    @JsonDeserialize(as = PlayerMatchHistoryImpl.MatchImpl.class)
    interface Match {
        String getMatchId();
        String getGameId();

        String getRegion();

        String getMatchType();

        String getGameMode();

        int getMaxPlayers();

        int getTeamsSize();
        Map<String, Team> getTeams();

        List<String> getPlayingPlayers();

        String getCompetitionId();

        String getCompetitionName();

        String getCompetitionType();

        String getOrganizerId();
        String getStatus();
        long getStartedAt();

        long getFinishedAt();

        Results getResults();

        String getFaceitUrl();

        @JsonDeserialize(as = PlayerMatchHistoryImpl.MatchImpl.ResultsImpl.class)
        interface Results {
            String getWinner();
            Score getScore();

            @JsonDeserialize(as = PlayerMatchHistoryImpl.MatchImpl.ResultsImpl.ScoreImpl.class)
            interface Score {
                int getFaction1();
                int getFaction2();
            }
        }

        @JsonDeserialize(as = PlayerMatchHistoryImpl.MatchImpl.TeamImpl.class)
        interface Team {
            String getTeamId();
            String getNickname();
            String getAvatar();
            String getType();
            List<Player> getPlayers();
        }

        @JsonDeserialize(as = PlayerMatchHistoryImpl.MatchImpl.PlayerImpl.class)
        interface Player {
            String getPlayerId();
            String getNickname();
            String getAvatar();
            int getSkillLevel();
            String getGamePlayerId();
            String getGamePlayerName();
            String getFaceitUrl();
        }
    }

}
