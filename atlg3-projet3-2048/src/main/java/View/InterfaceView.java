package View;

import Model.Direction;
import Model.Model;

/**
 * Class that implements the game interface.
 *
 * @author Marika Winska 55047
 */
public interface InterfaceView {

    /**
     * Creates the display of the game board with a 2-dimensional array of
     * integers.
     *
     * @param board the game board to make.
     */
    void displayBoard(Model board);

    /**
     * Asks the user to encode a direction in which numbers will move.
     *
     * @return the direction of the movement.
     */
    Direction askDirection();

    /**
     * Displays a message when the player has won a game.
     */
    void displayWin();

    /**
     * Displays a message when the player has lost a game.
     */
    void displayDefeat();

    /**
     * Displays a message asking the player at the end of a game if he wants to
     * play again.
     *
     * @return true if the player wants to play again, false otherwise.
     */
    boolean displayReplay();

}
