package g55047.atlg3.asciipaint.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Marika Winska 55047
 */
public class AsciiPaintTest {

    /**
     * Test of the constructor.
     */
    @Test
    public void testConstr_null() {
        IllegalArgumentException assertThrows;
        assertThrows = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    AsciiPaint paint = new AsciiPaint(-3, 5);
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
                    AsciiPaint paint = new AsciiPaint(5, -5);
                });
    }

}
