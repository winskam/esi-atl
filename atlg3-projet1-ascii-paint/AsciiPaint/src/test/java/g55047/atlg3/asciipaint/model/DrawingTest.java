package g55047.atlg3.asciipaint.model;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Marika Winska 55047
 */
public class DrawingTest {
    
    /**
     * Test of the constructor.
     */
    @Test
    public void testConstr_null() {
        IllegalArgumentException assertThrows;
        assertThrows = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Drawing sheet = new Drawing(-5, 1);
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
                    Drawing sheet = new Drawing(5, -3);
                });
    }
    
    /**
     * Test of addShape method, of class Drawing.
     */
    @Test
    public void testAddShape() {
    }

    /**
     * Test of getShapeAt method, of class Drawing.
     */
    @Test
    public void testGetShapeAt() {
        Drawing drawing = new Drawing(30, 40);
        Shape shape = new Square(new Point(15, 15), 5, 's');
        drawing.addShape(shape);
        Shape expResult = shape;
        Shape result = drawing.getShapeAt(new Point(20, 17));
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getShapeAt method, of class Drawing.
     */
    @Test
    public void testGetShapeNotAt() {
        Drawing drawing = new Drawing(30, 40);
        Shape shape = new Rectangle(new Point(5, 5), 7, 5, 'r');
        drawing.addShape(shape);
        Shape expResult = null;
        Shape result = drawing.getShapeAt(new Point(29, 38));
        assertEquals(expResult, result);
    }

}
