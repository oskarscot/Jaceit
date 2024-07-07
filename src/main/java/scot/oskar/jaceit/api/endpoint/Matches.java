package scot.oskar.jaceit.api.endpoint;

import scot.oskar.jaceit.api.entity.match.MatchDetails;

public interface Matches {
    MatchDetails getMatchDetails(String matchId);
}
