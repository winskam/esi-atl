package g55047.atlg3.asciipaint.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Marika Winska 55047
 */
public class SquareTest {

    /**
     * Test of the constructor.
     */
    @Test
    public void testConstr_null() {
        IllegalArgumentException assertThrows;
        assertThrows = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Square square = new Square(new Point(9, 2), -1, 's');
                });
    }

}
