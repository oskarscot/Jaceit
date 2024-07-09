import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import scot.oskar.jaceit.api.Jaceit;
import scot.oskar.jaceit.api.JaceitBuilder;
import scot.oskar.jaceit.api.entity.championship.AllChampionships;
import scot.oskar.jaceit.api.entity.championship.ChampionshipType;
import scot.oskar.jaceit.api.request.QueryParameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ChampionshipTest {

    private static Jaceit jaceit;

    @BeforeAll
    public static void createJaceit() {
        jaceit = JaceitBuilder
                .createDefault(System.getenv("FACEIT_KEY"))
                .build();
    }

    @Test
    public void testGetChampionships() {
        AllChampionships championships = jaceit.championships().getAll("cs2");
        assertNotNull(championships, "Championships should not be null");
    }

    @Test
    public void testGetChampionshipsType() {
        AllChampionships championships = jaceit.championships().getAll("cs2", ChampionshipType.UPCOMING);
        assertNotNull(championships, "Championships should not be null");
    }

    @Test
    public void testGetChampionshipsTypeWithQuery() {
        AllChampionships championships = jaceit.championships().getAll("cs2", ChampionshipType.UPCOMING, QueryParameters.of("limit", "1"));
        assertEquals(championships.getItems().size(), 1);
    }


}
