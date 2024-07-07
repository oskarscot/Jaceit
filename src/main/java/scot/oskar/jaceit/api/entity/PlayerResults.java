package scot.oskar.jaceit.api.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import scot.oskar.jaceit.internal.entity.PlayerResultsImpl;

import java.util.List;

@JsonDeserialize(as = PlayerResultsImpl.class)
public interface PlayerResults {

    List<Stats> getStats();

    int getOffset();
    int getLimit();

    @JsonDeserialize(as = PlayerResultsImpl.StatsImpl.class)
    interface Stats {
        String getGameMode();

        String getFlashSuccesses();

        String getMatchId();

        String getZeusKills();

        String getNickname();

        String getOvertimeScore();

        String getSecondHalfScore();

        String getPentaKills();

        String getHeadshots();

        String getMatchRound();

        String getFinalScore();

        String getRounds();

        String getPlayerId();

        String getClutchKills();

        String getOneVoneWins();

        String getPistolKills();

        String getKnifeKills();

        String getDoubleKills();

        String getGame();

        String getFirstHalfScore();

        String getResult();

        String getUtilityDamage();

        String getScore();

        String getOneVtwoCount();

        String getKdRatio();

        String getOneVtwoWins();

        String getHeadshotsPercentage();

        String getAssists();

        String getTripleKills();

        String getKrRatio();

        String getUpdatedAt();

        String getEnemiesFlashed();

        String getDeaths();

        String getUtilityCount();

        String getWinner();

        String getFirstKills();

        String getBestOf();

        String getDamage();

        String getTeam();

        String getQuadroKills();

        String getEntryWins();

        String getKills();

        String getMvps();

        String getUtilityEnemies();

        String getEntryCount();

        String getFlashCount();

        String getRegion();

        String getUtilitySuccesses();

        String getCreatedAt();

        String getMap();

        String getADR();

        String getCompetitionId();

        String getSniperKills();

        String getOneVoneCount();
    }
}