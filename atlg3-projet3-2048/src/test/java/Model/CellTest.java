package Model;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests of the Cell class.
 *
 * @author Marika Winska 55047
 */
public class CellTest {

    /**
     * Test of the constructor of class Cell.
     */
    @Test
    public void testCellException() {
        System.out.println("Invalid argument for the construction of the cell.");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Cell cell = new Cell(0);
                });
    }

    /**
     * Test of the constructor of class Cell.
     */
    @Test
    public void testCellExceptionBis() {
        System.out.println("Invalid argument for the construction of the cell.");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Cell cell = new Cell(22);
                });
    }

    /**
     * Test of getNumber method, of class Cell.
     */
    @Test
    public void testGetNumber() {
        System.out.println("Getter of the number of the cell.");
        Cell cell = new Cell(64);
        int result = cell.getNumber();
        int expResult = 64;
        assertEquals(result, expResult);
    }

}
