import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import scot.oskar.jaceit.api.Jaceit;
import scot.oskar.jaceit.api.JaceitBuilder;

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
        JaceitBuilder nullKey = JaceitBuilder.createDefault(null);
        assertThrows(IllegalArgumentException.class, nullKey::build);
    }

    @Test
    public void testCreateJaceitNoKey() {
        JaceitBuilder noKey = JaceitBuilder.createDefault("");
        assertThrows(IllegalArgumentException.class, noKey::build);
    }
}
