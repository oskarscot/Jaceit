import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import scot.oskar.jaceit.api.Jaceit;
import scot.oskar.jaceit.api.JaceitBuilder;
import scot.oskar.jaceit.api.entity.PlayerProfile;

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
}
