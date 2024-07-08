import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import scot.oskar.jaceit.api.Jaceit;
import scot.oskar.jaceit.api.JaceitBuilder;
import scot.oskar.jaceit.api.entity.match.MatchDetails;
import scot.oskar.jaceit.api.entity.match.MatchStats;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MatchTest {

    private static Jaceit jaceit;

    @BeforeAll
    public static void createJaceit() {
        jaceit = JaceitBuilder
                .createDefault(System.getenv("FACEIT_KEY"))
                .build();
    }

    @Test
    public void testGetMatchDetails() {
        MatchDetails match = jaceit.matches().getMatchDetails("1-9ad24cbd-6bd5-4839-b8de-3bf56eb8e69c");
        assertNotNull(match, "Match should not be null");
    }

    @Test
    public void testGetMatchStats() {
        MatchStats matchStats = jaceit.matches().getMatchStats("1-9ad24cbd-6bd5-4839-b8de-3bf56eb8e69c");
        assertNotNull(matchStats, "Match stats should not be null");
    }
}
