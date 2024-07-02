import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import scot.oskar.jaceit.api.Jaceit;
import scot.oskar.jaceit.api.JaceitBuilder;
import scot.oskar.jaceit.api.entity.PlayerProfile;
import scot.oskar.jaceit.api.entity.PlayerResults;
import scot.oskar.jaceit.api.request.QueryParameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JaceitTest {

    private static Jaceit jaceit;

    @BeforeAll
    public static void createJaceit() {
        jaceit = JaceitBuilder
                .createDefault(System.getenv("FACEIT_KEY"))
                .build();
    }

    @Test
    public void testCreateJaceitNullKey() {
        final JaceitBuilder nullKey = JaceitBuilder.createDefault(null);
        assertThrows(IllegalArgumentException.class, nullKey::build);
    }

    @Test
    public void testCreateJaceitNoKey() {
        final JaceitBuilder noKey = JaceitBuilder.createDefault("");
        assertThrows(IllegalArgumentException.class, noKey::build);
    }

    @Test
    public void testGetPlayerById() {
        PlayerProfile playerById = jaceit.players().getDetailsById("460dc92d-8af4-4260-8780-45758fa688f0");
        assertEquals(playerById.getNickname(), "ITB_nexa");
    }

    @Test
    public void testGetPlayerByIdAsync() {
        PlayerProfile playerById = jaceit.players().getDetailsByIdAsync("460dc92d-8af4-4260-8780-45758fa688f0").join();
        assertEquals(playerById.getNickname(), "ITB_nexa");
    }

    @Test
    public void testGetPlayerByName() {
        PlayerProfile playerByName = jaceit.players().getDetailsByNickname("ITB_nexa");
        assertEquals(playerByName.getNickname(), "ITB_nexa");
    }

    @Test
    public void testGetPlayerByNameWithParams() {
        PlayerProfile playerByName = jaceit.players().getDetailsByNickname("ITB_nexa", QueryParameters.of("game", "cs2"));
        assertEquals(playerByName.getNickname(), "ITB_nexa");
    }

    @Test
    public void testGetPlayerByNameWithParamsAsync() {
        PlayerProfile playerByName = jaceit.players().getDetailsByNicknameAsync("ITB_nexa", QueryParameters.of("game", "cs2")).join();
        assertEquals(playerByName.getNickname(), "ITB_nexa");
    }

    @Test
    public void testGetPlayerByNameAsync() {
        PlayerProfile playerByName = jaceit.players().getDetailsByNicknameAsync("ITB_nexa").join();
        assertEquals(playerByName.getNickname(), "ITB_nexa");
    }

    @Test
    public void testGetResultsForPlayer() {
        PlayerResults playerResults = jaceit.players().getLastResultsForGame("460dc92d-8af4-4260-8780-45758fa688f0", "cs2", QueryParameters.of("limit", "5"));
        assertEquals(playerResults.getItems().size(), 5);
    }

    @Test
    public void testGetResultsForPlayerInvalidLimit() {
        assertThrows(IllegalArgumentException.class, () -> jaceit.players()
                .getLastResultsForGame("460dc92d-8af4-4260-8780-45758fa688f0", "cs2",
                        QueryParameters.of("limit", "five")));
    }
}
