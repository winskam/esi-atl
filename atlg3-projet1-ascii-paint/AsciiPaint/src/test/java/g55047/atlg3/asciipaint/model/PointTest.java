package g55047.atlg3.asciipaint.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Marika Winska 55047
 */
public class PointTest {

    /**
     * Test of the constructor.
     */
    @Test
    public void testConstr_null() {
        IllegalArgumentException assertThrows;
        assertThrows = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Point point = new Point(-5, 1);
                });
    }

    /**
     * Test of the constructor.
     */
    @Test
    public void testConstr2_null() {
        IllegalArgumentException assertThrows;
        assertThrows = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Point point = new Point(5, -1);
                });
    }

}
