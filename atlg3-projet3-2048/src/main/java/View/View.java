package View;

import Model.Direction;
import Model.Model;
import Model.Position;
import java.util.Scanner;

/**
 * Class that displays the game board and interacts with the user.
 *
 * @author Marika Winska 55047
 */
public class View implements InterfaceView {

    /**
     * Creates the display of the game board with a 2-dimensional array of
     * integers.
     *
     * @param board the game board to make.
     */
    @Override
    public void displayBoard(Model board) {
        if (board == null) {
            throw new IllegalArgumentException("Invalid argument.");
        }
        for (int row = 0; row < board.getBoard().getSize(); row++) {
            System.out.println();
            for (int column = 0; column < board.getBoard().getSize(); column++) {
                if (board.getBoard().hasCell(new Position(row, column))) {
                    System.out.printf("%5d",
                            board.getBoard()
                                    .getCopyBoard()[row][column].getNumber());
                } else {
                    System.out.printf("%5d", 0);
                }
            }
        }
        System.out.println();
    }

    /**
     * Asks the user to encode a direction in which numbers will move.
     *
     * @return the direction of the movement.
     */
    @Override
    public Direction askDirection() {
        Scanner direction = new Scanner(System.in);
        String directionOfNumbers;
        do {
            System.out.print("Enter the direction (up / down / left / right) : ");
            directionOfNumbers = direction.next().toUpperCase();
        } while (!(directionOfNumbers.equals("UP")
                || directionOfNumbers.equals("DOWN")
                || directionOfNumbers.equals("LEFT")
                || directionOfNumbers.equals("RIGHT")));

        return Direction.valueOf(directionOfNumbers);
    }

    /**
     * Displays a message when the player has won a game.
     */
    @Override
    public void displayWin() {
        System.out.println("Congrats !");
    }

    /**
     * Displays a message when the player has lost a game.
     */
    @Override
    public void displayDefeat() {
        System.out.println("Game over ! Try again !");
    }

    /**
     * Displays a message asking the player at the end of a game if he wants to
     * play again.
     *
     * @return true if the player wants to play again, false otherwise.
     */
    @Override
    public boolean displayReplay() {
        Scanner askReplay = new Scanner(System.in);
        String answerReplay;
        boolean replay;

        do {
            System.out.print("Do you want to play again ? (yes / no) : ");
            answerReplay = askReplay.next().toUpperCase();
        } while (!(answerReplay.equals("YES") || answerReplay.equals("NO")));

        replay = answerReplay.equals("YES");

        return replay;
    }

}
