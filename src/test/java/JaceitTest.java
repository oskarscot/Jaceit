import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import scot.oskar.jaceit.api.Jaceit;
import scot.oskar.jaceit.api.JaceitBuilder;
import scot.oskar.jaceit.api.entity.PlayerBans;
import scot.oskar.jaceit.api.entity.PlayerMatchHistory;
import scot.oskar.jaceit.api.entity.PlayerProfile;
import scot.oskar.jaceit.api.entity.PlayerResults;
import scot.oskar.jaceit.api.request.QueryParameters;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testGetResultsForPlayerNegativeLimit() {
        assertThrows(IllegalArgumentException.class, () -> jaceit.players()
                .getLastResultsForGame("460dc92d-8af4-4260-8780-45758fa688f0", "cs2",
                        QueryParameters.of("limit", "-1")));
    }

    @Test
    public void testGetResultsForPlayerOffsetNotMultiple() {
        assertThrows(IllegalArgumentException.class, () -> jaceit.players()
                .getLastResultsForGame("460dc92d-8af4-4260-8780-45758fa688f0", "cs2",
                        QueryParameters.of("limit", "3", "offset", "2")));
    }

    @Test
    public void testGetResultsForPlayerInvalidOffset() {
        assertThrows(IllegalArgumentException.class, () -> jaceit.players()
                .getLastResultsForGame("460dc92d-8af4-4260-8780-45758fa688f0", "cs2",
                        QueryParameters.of("offset", "two")));
    }

    @Test
    public void testGetResultsForPlayerNegativeOffset() {
        assertThrows(IllegalArgumentException.class, () -> jaceit.players()
                .getLastResultsForGame("460dc92d-8af4-4260-8780-45758fa688f0", "cs2",
                        QueryParameters.of("offset", "-1")));
    }

    @Test
    public void testGetResultsForPlayerOffsetNoLimit() {
        assertThrows(IllegalArgumentException.class, () -> jaceit.players()
                .getLastResultsForGame("460dc92d-8af4-4260-8780-45758fa688f0", "cs2",
                        QueryParameters.of("offset", "2")));
    }

    @Test
    public void testGetPlayerBans() {
        final PlayerBans playerBans = jaceit.players().getPlayerBans("ca130ed0-aec4-4823-970f-8e153ce190cf");
        assertEquals(playerBans.getBans().size(), 1);
    }

    @Test
    public void testGetMatchHistoryOffsetNotMultiple() {
        assertThrows(IllegalArgumentException.class, () -> jaceit.players().getMatchHistory(
                "460dc92d-8af4-4260-8780-45758fa688f0", "cs2",
                QueryParameters.of("limit", "3", "offset", "2")));
    }

    @Test
    public void testGetMatchHistoryInvalidOffset() {
        assertThrows(IllegalArgumentException.class, () -> jaceit.players().getMatchHistory(
                "460dc92d-8af4-4260-8780-45758fa688f0", "cs2",
                QueryParameters.of("offset", "two")));
    }

    @Test
    public void testGetMatchHistoryNegativeOffset() {
        assertThrows(IllegalArgumentException.class, () -> jaceit.players().getMatchHistory(
                "460dc92d-8af4-4260-8780-45758fa688f0", "cs2",
                QueryParameters.of("offset", "-1")));
    }

    @Test
    public void testGetMatchHistoryOffsetNoLimit() {
        assertThrows(IllegalArgumentException.class, () -> jaceit.players().getMatchHistory(
                "460dc92d-8af4-4260-8780-45758fa688f0", "cs2",
                QueryParameters.of("offset", "2")));
    }

    @Test
    public void testGetMatchHistoryLimitExceedsMax() {
        assertThrows(IllegalArgumentException.class, () -> jaceit.players().getMatchHistory(
                "460dc92d-8af4-4260-8780-45758fa688f0", "cs2",
                QueryParameters.of("limit", "101")));
    }

    @Test
    public void testGetMatchHistoryInvalidLimit() {
        assertThrows(IllegalArgumentException.class, () -> jaceit.players().getMatchHistory(
                "460dc92d-8af4-4260-8780-45758fa688f0", "cs2",
                QueryParameters.of("limit", "one")));
    }

    @Test
    public void testGetMatchHistoryNegativeLimit() {
        assertThrows(IllegalArgumentException.class, () -> jaceit.players().getMatchHistory(
                "460dc92d-8af4-4260-8780-45758fa688f0", "cs2",
                QueryParameters.of("limit", "-1")));
    }

    @Test
    public void testGetMatchHistoryInvalidFrom() {
        assertThrows(IllegalArgumentException.class, () -> jaceit.players().getMatchHistory(
                "460dc92d-8af4-4260-8780-45758fa688f0", "cs2",
                QueryParameters.of("from", "abc")));
    }

    @Test
    public void testGetMatchHistoryNegativeFrom() {
        assertThrows(IllegalArgumentException.class, () -> jaceit.players().getMatchHistory(
                "460dc92d-8af4-4260-8780-45758fa688f0", "cs2",
                QueryParameters.of("from", "-1")));
    }

    @Test
    public void testGetMatchHistoryInvalidTo() {
        assertThrows(IllegalArgumentException.class, () -> jaceit.players().getMatchHistory(
                "460dc92d-8af4-4260-8780-45758fa688f0", "cs2",
                QueryParameters.of("to", "abc")));
    }

    @Test
    public void testGetMatchHistoryNegativeTo() {
        assertThrows(IllegalArgumentException.class, () -> jaceit.players().getMatchHistory(
                "460dc92d-8af4-4260-8780-45758fa688f0", "cs2",
                QueryParameters.of("to", "-1")));
    }

    @Test
    public void testGetMatchHistoryFromAfterTo() {
        assertThrows(IllegalArgumentException.class, () -> jaceit.players().getMatchHistory(
                "460dc92d-8af4-4260-8780-45758fa688f0", "cs2",
                QueryParameters.of("from", "1625097600", "to", "1622505600")));
    }

    @Test
    public void testGetMatchHistoryValidParameters() {
        PlayerMatchHistory matchHistory = jaceit.players().getMatchHistory(
                "460dc92d-8af4-4260-8780-45758fa688f0", "cs2",
                QueryParameters.of("offset", "10", "limit", "5", "from", "1720002882", "to", "1720179282"));
        assertNotNull(matchHistory, "Match history should not be null");
    }
}
