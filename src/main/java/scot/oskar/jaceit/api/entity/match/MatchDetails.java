package scot.oskar.jaceit.api.entity.match;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import scot.oskar.jaceit.internal.entity.match.MatchDetailsImpl;

import java.util.List;
import java.util.Map;

@JsonDeserialize(as = MatchDetailsImpl.class)
public interface MatchDetails {

    String getMatchId();

    int getVersion();

    String getGame();

    String getRegion();

    String getCompetitionId();

    String getCompetitionType();

    String getCompetitionName();

    String getOrganizerId();

    Map<String, Team> getTeams();

    Voting getVoting();

    boolean isCalculateElo();

    long getConfiguredAt();

    long getStartedAt();

    long getFinishedAt();

    List<String> getDemoUrl();

    String getChatRoomId();

    int getBestOf();

    Results getResults();

    List<DetailedResult> getDetailedResults();

    String getStatus();

    String getFaceitUrl();

    @JsonDeserialize(as = MatchDetailsImpl.TeamImpl.class)
    interface Team {

        String getFactionId();

        String getLeader();

        String getAvatar();

        List<Player> getRoster();

        Stats getStats();

        boolean isSubstituted();

        String getName();

        String getType();

        @JsonDeserialize(as = MatchDetailsImpl.TeamImpl.PlayerImpl.class)
        interface Player {

            String getPlayerId();

            String getNickname();

            String getAvatar();

            String getMembership();

            String getGamePlayerId();

            String getGamePlayerName();

            int getGameSkillLevel();

            boolean isAnticheatRequired();
        }

        @JsonDeserialize(as = MatchDetailsImpl.TeamImpl.StatsImpl.class)
        interface Stats {

            double getWinProbability();

            SkillLevel getSkillLevel();

            int getRating();

            @JsonDeserialize(as = MatchDetailsImpl.TeamImpl.StatsImpl.SkillLevelImpl.class)
            interface SkillLevel {

                int getAverage();

                Range getRange();

                @JsonDeserialize(as = MatchDetailsImpl.TeamImpl.StatsImpl.SkillLevelImpl.RangeImpl.class)
                interface Range {

                    int getMin();

                    int getMax();
                }
            }
        }
    }

    @JsonDeserialize(as = MatchDetailsImpl.VotingImpl.class)
    interface Voting {

        MapVoting getMapVoting();

        List<String> getVotedEntityTypes();

        LocationVoting getLocationVoting();

        @JsonDeserialize(as = MatchDetailsImpl.VotingImpl.MapVotingImpl.class)
        interface MapVoting {

            List<MapEntity> getEntities();

            List<String> getPick();

            @JsonDeserialize(as = MatchDetailsImpl.VotingImpl.MapVotingImpl.MapEntityImpl.class)
            interface MapEntity {

                String getGuid();

                String getImageLarge();

                String getImageSmall();

                String getName();

                String getClassName();

                String getGameMapId();
            }
        }

        @JsonDeserialize(as = MatchDetailsImpl.VotingImpl.LocationVotingImpl.class)
        interface LocationVoting {

            List<LocationEntity> getEntities();

            List<String> getPick();

            @JsonDeserialize(as = MatchDetailsImpl.VotingImpl.LocationVotingImpl.LocationEntityImpl.class)
            interface LocationEntity {

                String getImageLarge();

                String getImageSmall();

                String getName();

                String getClassName();

                String getGameLocationId();

                String getGuid();
            }
        }
    }

    @JsonDeserialize(as = MatchDetailsImpl.ResultsImpl.class)
    interface Results {

        String getWinner();

        Map<String, Integer> getScore();
    }

    @JsonDeserialize(as = MatchDetailsImpl.DetailedResultImpl.class)
    interface DetailedResult {

        boolean isAscScore();

        String getWinner();

        Map<String, Faction> getFactions();
    }

    @JsonDeserialize(as = MatchDetailsImpl.FactionImpl.class)
    interface Faction {

        int getScore();
    }
}