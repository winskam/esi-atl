package Model;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests of the Position class.
 *
 * @author Marika Winska 55047
 */
public class PositionTest {

    /**
     * Test of the constructor of class Position.
     */
    @Test
    public void testPositionExceptionRow() {
        System.out.println("Invalid argument for the construction of the cell."
                + " (row)");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Position position = new Position(-10, 3);
                });
    }

    /**
     * Test of the constructor of class Position.
     */
    @Test
    public void testPositionExceptionColumn() {
        System.out.println("Invalid argument for the construction of the cell."
                + " (column)");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Position position = new Position(3, -10);
                });
    }

    /**
     * Test of getRow method, of class Position.
     */
    @Test
    public void testGetRow() {
        System.out.println("Getter of the row.");
        Position position = new Position(3, 2);
        int result = position.getRow();
        int expResult = 3;
        assertEquals(result, expResult);
    }

    /**
     * Test of getColumn method, of class Position.
     */
    @Test
    public void testGetColumn() {
        System.out.println("Getter of the column.");
        Position position = new Position(3, 2);
        int result = position.getColumn();
        int expResult = 2;
        assertEquals(result, expResult);

    }

    @Test
    public void tesPositiontEqualItSelf() {
        System.out.println("The position is equal to itself.");
        Position position1 = new Position(1, 2);
        assertTrue(position1.equals(position1));
    }

    @Test
    public void testPositionNotEqual() {
        System.out.println("The positions are not equal.");
        Position position1 = new Position(2, 3);
        Position position2 = new Position(1, 4);
        assertFalse(position1.equals(position2));
    }

}
