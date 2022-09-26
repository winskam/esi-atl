package g55047.atlg3.asciipaint.model;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Marika Winska 55047
 */
public class CircleTest {

    /**
     * Test of the constructor.
     */
    @Test
    public void testConstr_null() {
        IllegalArgumentException assertThrows;
        assertThrows = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Circle circle = new Circle(null, 1, 'c');
                });
    }

    /**
     * Test of isInside method, of class Circle.
     */
    @Test
    public void testIsInside() {
        Circle circle = new Circle(new Point(2, 3), 3, 'c');
        Point point = new Point(3, 3);
        assertTrue(circle.isInside(point));
    }

    /**
     * Test of isNotInside method, of class Circle.
     */
    @Test
    public void testIsNotInside() {
        Circle circle = new Circle(new Point(2, 3), 2, 'c');
        Point point = new Point(10, 20);
        assertFalse(circle.isInside(point));
    }

}
