package Model;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Tests of the Board class.
 *
 * @author Marika Winska 55047
 */
public class BoardTest {

    /**
     * Test of the constructor of class Board.
     */
    @Test
    public void BoardTestException() {
        System.out.println("Invalid argument for the construction "
                + "of the game board.");
        IllegalArgumentException assertThrows;
        assertThrows = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Board board = new Board(0);
                });
    }

    /**
     * Test of getBoard method, of class Game.
     */
    @Test
    public void testGetCopyBoard() {
        System.out.println("Getter of the copy of the board.");
        Board board = new Board(2);
        Cell[][] newBoard = {{new Cell(2), new Cell(2)}, {new Cell(8),
            new Cell(8)}};
        board.setBoard(newBoard);
        int result = board.getCopyBoard()[0][0].getNumber();
        int expResult = 2;
        assertEquals(result, expResult);
    }

    /**
     * Test of getSize method, of class Board.
     */
    @Test
    public void testGetSize() {
        System.out.println("Getter of size of the board.");
        Board board = new Board(3);
        Cell[][] newBoard = {{null, new Cell(4), new Cell(4)},
        {new Cell(2), new Cell(2), new Cell(4)},
        {new Cell(2), new Cell(2), new Cell(4)}};
        board.setBoard(newBoard);
        int result = 3;
        int expResult = newBoard.length;
        assertEquals(result, expResult);
    }

    /**
     * Test of addCell method, of class Board.
     */
    @Test
    public void testAddCell() {
        System.out.println("addCell to the board.");
        Board board = new Board(3);
        Cell[][] newBoard = {{null, new Cell(4), new Cell(4)},
        {new Cell(2), new Cell(2), new Cell(4)},
        {new Cell(2), new Cell(2), new Cell(4)}};
        board.setBoard(newBoard);
        board.addCell();
        boolean result = board.isCompleted();
        assertTrue(result);

    }

    /**
     * Test of hasCell method, of class Board.
     */
    @Test
    public void testHasCell() {
        System.out.println("hasCell at this position.");
        Board board = new Board(3);
        Cell[][] newBoard = {{null, new Cell(4), new Cell(4)},
        {new Cell(2), new Cell(2), new Cell(4)},
        {new Cell(2), new Cell(2), new Cell(4)}};
        board.setBoard(newBoard);
        boolean result = board.hasCell(new Position(0, 1));
        assertTrue(result);
    }

    /**
     * Test of hasCell method, of class Board.
     */
    @Test
    public void testHasNotCell() {
        System.out.println("hasNotCell at this positionn (null).");
        Board board = new Board(3);
        Cell[][] newBoard = {{null, new Cell(4), new Cell(4)},
        {new Cell(2), new Cell(2), new Cell(4)},
        {new Cell(2), new Cell(2), new Cell(4)}};
        board.setBoard(newBoard);
        boolean result = board.hasCell(new Position(0, 0));
        assertFalse(result);

    }

    /**
     * Test of hasCell method, of class Board.
     */
    @Test
    public void testHasNotCellOutBoard() {
        System.out.println("hasNotCell out of the board.");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Board board = new Board(2);
                    Cell[][] newBoard = {{new Cell(4), new Cell(8)}, {null,
                        new Cell(2)}};
                    board.setBoard(newBoard);
                    board.hasCell(new Position(3, 3));
                });
    }

    /**
     * Test of isCompleted method, of class Board.
     */
    @Test
    public void testIsCompleted() {
        System.out.println("Board is completed.");
        Board board = new Board(2);
        Cell[][] newBoard = {{new Cell(2), new Cell(2)}, {new Cell(4),
            new Cell(8)}};
        board.setBoard(newBoard);
        boolean result = board.isCompleted();
        assertTrue(result);

    }

    /**
     * Test of isCompleted method, of class Board.
     */
    @Test
    public void testIsNotCompleted() {
        System.out.println("Board is not completed.");
        Board board = new Board(2);
        Cell[][] newBoard = {{new Cell(2), new Cell(2)}, {new Cell(4), null}};
        board.setBoard(newBoard);
        boolean result = board.isCompleted();
        assertFalse(result);

    }

    /**
     * Test of moveUp method, of class Board.
     */
    @Test
    public void testMoveUp() {
        System.out.println("Simple moveUp.");
        Board board = new Board(2);
        Cell[][] newBoard = {{null, new Cell(2)}, {new Cell(4), new Cell(2)}};
        board.setBoard(newBoard);
        board.move(Direction.UP);
        int result = board.getCopyBoard()[0][0].getNumber();
        int expResult = 4;
        assertEquals(result, expResult);
    }

    /**
     * Test of moveUp method, of class Board.
     */
    @Test
    public void testMoveUpPosNull() {
        System.out.println("null at the checked position with moveUp.");
        Assertions.assertThrows(NullPointerException.class,
                () -> {
                    Board board = new Board(2);
                    Cell[][] newBoard = {{null, null}, {new Cell(2), null}};
                    board.setBoard(newBoard);
                    board.move(Direction.UP);
                    board.getCopyBoard()[1][0].getNumber();
                });
    }

    /**
     * Test of moveUp method, of class Board.
     */
    @Test
    public void testMoveUpWithoutChange() {
        System.out.println("moveUp without change.");
        Board board = new Board(2);
        Cell[][] newBoard = {{new Cell(2), new Cell(2)}, {new Cell(4), null}};
        board.setBoard(newBoard);
        board.move(Direction.UP);
        int result = board.getCopyBoard()[0][1].getNumber();
        int expResult = 2;
        assertEquals(result, expResult);
    }

    /**
     * Test of moveUp method, of class Board.
     */
    @Test
    public void testMoveUpWithAddition() {
        System.out.println("moveUp with addition of at least 2 numbers.");
        Board board = new Board(2);
        Cell[][] newBoard = {{null, new Cell(2)}, {new Cell(4), new Cell(2)}};
        board.setBoard(newBoard);
        board.move(Direction.UP);
        int result = board.getCopyBoard()[0][1].getNumber();
        int expResult = 4;
        assertEquals(result, expResult);
    }

    /**
     * Test of moveDown method, of class Board.
     */
    @Test
    public void testMoveDown() {
        System.out.println("Simple moveDown.");
        Board board = new Board(2);
        Cell[][] newBoard = {{null, new Cell(2)}, {new Cell(4), null}};
        board.setBoard(newBoard);
        board.move(Direction.DOWN);
        int result = board.getCopyBoard()[1][1].getNumber();
        int expResult = 2;
        assertEquals(result, expResult);
    }

    /**
     * Test of moveDown method, of class Board.
     */
    @Test
    public void testMoveDownPosNull() {
        System.out.println("null at the checked position with moveDown.");
        Assertions.assertThrows(NullPointerException.class,
                () -> {
                    Board board = new Board(2);
                    Cell[][] newBoard = {{null, new Cell(4)}, {new Cell(2), null}};
                    board.setBoard(newBoard);
                    board.move(Direction.DOWN);
                    board.getCopyBoard()[0][1].getNumber();
                });
    }

    /**
     * Test of moveDown method, of class Board.
     */
    @Test
    public void testMoveDownWithoutChange() {
        System.out.println("moveDown without change.");
        Board board = new Board(2);
        Cell[][] newBoard = {{new Cell(2), new Cell(8)}, {new Cell(4),
            new Cell(4)}};
        board.setBoard(newBoard);
        board.move(Direction.DOWN);
        int result = board.getCopyBoard()[0][0].getNumber();
        int expResult = 2;
        assertEquals(result, expResult);
    }

    /**
     * Test of moveDown method, of class Board.
     */
    @Test
    public void testMoveDownWithAddition() {
        System.out.println("moveDown with addition of at least 2 numbers.");
        Board board = new Board(2);
        Cell[][] newBoard = {{new Cell(4), new Cell(2)}, {new Cell(4), null}};
        board.setBoard(newBoard);
        board.move(Direction.DOWN);
        int result = board.getCopyBoard()[1][0].getNumber();
        int expResult = 8;
        assertEquals(result, expResult);
    }

    /**
     * Test of moveLeft method, of class Board.
     */
    @Test
    public void testMoveLeft() {
        System.out.println("Simple moveLeft.");
        Board board = new Board(2);
        Cell[][] newBoard = {{null, new Cell(2)}, {new Cell(4), new Cell(2)}};
        board.setBoard(newBoard);
        board.move(Direction.LEFT);
        int result = board.getCopyBoard()[0][0].getNumber();
        int expResult = 2;
        assertEquals(result, expResult);
    }

    /**
     * Test of moveLeft method, of class Board.
     */
    @Test
    public void testMoveLeftPosNull() {
        System.out.println("null at the checked position with moveLeft.");
        Assertions.assertThrows(NullPointerException.class,
                () -> {
                    Board board = new Board(2);
                    Cell[][] newBoard = {{null, new Cell(4)}, {new Cell(2), null}};
                    board.setBoard(newBoard);
                    board.move(Direction.LEFT);
                    board.getCopyBoard()[0][1].getNumber();
                });
    }

    /**
     * Test of moveLeft method, of class Board.
     */
    @Test
    public void testMoveLeftWithoutChange() {
        System.out.println("moveLeft without change.");
        Board board = new Board(2);
        Cell[][] newBoard = {{new Cell(2), new Cell(8)}, {new Cell(4),
            new Cell(16)}};
        board.setBoard(newBoard);
        board.move(Direction.LEFT);
        int result = board.getCopyBoard()[1][1].getNumber();
        int expResult = 16;
        assertEquals(result, expResult);
    }

    /**
     * Test of moveLeft method, of class Board.
     */
    @Test
    public void testMoveLeftWithAddition() {
        System.out.println("moveLeft with addition of at least 2 numbers");
        Board board = new Board(2);
        Cell[][] newBoard = {{null, new Cell(2)}, {new Cell(4), new Cell(4)}};
        board.setBoard(newBoard);
        board.move(Direction.LEFT);
        int result = board.getCopyBoard()[1][0].getNumber();
        int expResult = 8;
        assertEquals(result, expResult);
    }

    /**
     * Test of moveRight method, of class Board.
     */
    @Test
    public void testMoveRight() {
        System.out.println("Simple moveRight.");
        Board board = new Board(2);
        Cell[][] newBoard = {{null, new Cell(2)}, {new Cell(4), null}};
        board.setBoard(newBoard);
        board.move(Direction.RIGHT);
        int result = board.getCopyBoard()[1][1].getNumber();
        int expResult = 4;
        assertEquals(result, expResult);
    }

    /**
     * Test of moveRight method, of class Board.
     */
    @Test
    public void testMoveRightPosNull() {
        System.out.println("null at the checked position with moveRight.");
        Assertions.assertThrows(NullPointerException.class,
                () -> {
                    Board board = new Board(2);
                    Cell[][] newBoard = {{null, new Cell(4)}, {new Cell(2), null}};
                    board.setBoard(newBoard);
                    board.move(Direction.RIGHT);
                    board.getCopyBoard()[1][0].getNumber();
                });
    }

    /**
     * Test of moveRight method, of class Board.
     */
    @Test
    public void testMoveRightWithoutChange() {
        System.out.println("moveRight without change.");
        Board board = new Board(2);
        Cell[][] newBoard = {{new Cell(2), new Cell(8)}, {new Cell(4),
            new Cell(16)}};
        board.setBoard(newBoard);
        board.move(Direction.RIGHT);
        int result = board.getCopyBoard()[0][0].getNumber();
        int expResult = 2;
        assertEquals(result, expResult);
    }

    /**
     * Test of moveRight method, of class Board.
     */
    @Test
    public void testMoveRightWithAddition() {
        System.out.println("moveRight with addition of at least 2 numbers");
        Board board = new Board(2);
        Cell[][] newBoard = {{null, new Cell(2)}, {new Cell(32), new Cell(32)}};
        board.setBoard(newBoard);
        board.move(Direction.RIGHT);
        int result = board.getCopyBoard()[1][1].getNumber();
        int expResult = 64;
        assertEquals(result, expResult);
    }

}
