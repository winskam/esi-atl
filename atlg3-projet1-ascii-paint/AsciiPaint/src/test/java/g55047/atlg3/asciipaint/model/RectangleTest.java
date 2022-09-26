package g55047.atlg3.asciipaint.model;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Marika Winska 55047
 */
public class RectangleTest {

    /**
     * Test of the constructor.
     */
    @Test
    public void testConstr_null() {
        IllegalArgumentException assertThrows;
        assertThrows = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Rectangle rectangle = new Rectangle(new Point(9, 2), -8, 1, 'r');
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
                    Rectangle rectangle = new Rectangle(new Point(9, 2), 8, 0, 'r');
                });
    }

    /**
     * Test of isInside method, of class Circle.
     */
    @Test
    public void testIsInside() {
        Rectangle rectangle = new Rectangle(new Point(2, 3), 4, 3, 'r');
        Point point = new Point(3, 3);
        assertTrue(rectangle.isInside(point));
    }

    /**
     * Test of isNotInside method, of class Circle.
     */
    @Test
    public void testIsNotInside() {
        Rectangle rectangle = new Rectangle(new Point(2, 3), 4, 3, 'r');
        Point point = new Point(10, 20);
        assertFalse(rectangle.isInside(point));
    }
    
}
