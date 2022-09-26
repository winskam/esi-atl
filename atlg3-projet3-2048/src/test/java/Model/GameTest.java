package Model;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests of the Game class.
 *
 * @author Marika Winska 55047
 */
public class GameTest {

    /**
     * Test of getBoard method, of class Game.
     */
    @Test
    public void testGetBoard() {
        System.out.println("Getter of the board.");
        Game game = new Game();
        Board board = new Board(2);
        Cell[][] newBoard = {{new Cell(2), new Cell(2)}, {new Cell(8),
            new Cell(8)}};
        board.setBoard(newBoard);
        game.setBoard(board);
        int result = game.getBoard().getCopyBoard()[0][0].getNumber();
        int expResult = 2;
        assertEquals(result, expResult);

    }

    /**
     * Test of move method, of class Game.
     */
    public void testMoveException() {
        System.out.println("Invalid argument for method move.");
        IllegalArgumentException assertThrows;
        assertThrows = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Game game = new Game();
                    game.move(null);
                });
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMove() {
        System.out.println("Simple move.");
        Board board = new Board(2);
        Cell[][] newBoard = {{null, new Cell(2)}, {new Cell(4), new Cell(2)}};
        board.setBoard(newBoard);
        board.move(Direction.UP);
        int result = board.getCopyBoard()[0][0].getNumber();
        int expResult = 4;
        assertEquals(result, expResult);
    }

    /**
     * Test of canMove method, of class Game.
     */
    @Test
    public void testCanMove() {
        System.out.println("Can move.");
        Game game = new Game();
        boolean result = game.canMove();
        assertTrue(result);
    }

    /**
     * Test of canMove method, of class Game.
     */
    @Test
    public void testCanNotMove() {
        System.out.println("Can not move.");
        Game game = new Game();
        Board board = new Board(2);
        Cell[][] newBoard = {{new Cell(2), new Cell(4)}, {new Cell(8),
            new Cell(16)}};
        board.setBoard(newBoard);
        game.setBoard(board);
        boolean result = game.canMove();
        assertFalse(result);
    }

    /**
     * Test of isWon method, of class Game.
     */
    @Test
    public void testIsWon() {
        System.out.println("Game is won.");
        Game game = new Game();
        Board board = new Board(2);
        Cell[][] newBoard = {{new Cell(2048), new Cell(2)}, {new Cell(4),
            new Cell(8)}};
        board.setBoard(newBoard);
        game.setBoard(board);
        boolean result = game.isWon();
        assertTrue(result);
    }

    /**
     * Test of isWon method, of class Game.
     */
    @Test
    public void testIsNotWon() {
        System.out.println("Game is not won.");
        Game game = new Game();
        Board board = new Board(2);
        Cell[][] newBoard = {{new Cell(16), new Cell(2)}, {new Cell(4),
            new Cell(8)}};
        board.setBoard(newBoard);
        game.setBoard(board);
        boolean result = game.isWon();
        assertFalse(result);
    }

}
