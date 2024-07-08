package scot.oskar.jaceit.api.endpoint;

import scot.oskar.jaceit.api.entity.match.MatchDetails;
import scot.oskar.jaceit.api.entity.match.MatchStats;

import java.util.concurrent.CompletableFuture;

public interface Matches {
    MatchDetails getMatchDetails(String matchId);

    CompletableFuture<MatchDetails> getMatchDetailsAsync(String matchId);

    MatchStats getMatchStats(String matchId);

}
