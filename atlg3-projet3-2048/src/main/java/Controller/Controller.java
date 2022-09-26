package Controller;

import Model.Direction;
import Model.Game;
import Model.Model;
import View.InterfaceView;
import View.View;

/**
 * Manages game dynamics and view update as the game progresses.
 *
 * @author Marika Winska 55047
 */
public class Controller {

    private Model game;
    private final InterfaceView view;

    /**
     * Constructor of the class Controller.
     *
     * @param game represents the model.
     * @param view represents the view.
     */
    public Controller(Model game, View view) {
        if (game == null || view == null) {
            throw new IllegalArgumentException("Invalid argument.");
        }
        this.game = game;
        this.view = view;
    }

    /**
     * Method used to play. Starts the model, displays the board and asks for a
     * direction to move.
     */
    public void startGame() {
        boolean keepPlaying = true;
        while (keepPlaying) {
            while (!game.isWon() && game.canMove()) {
                view.displayBoard(game);
                game.move(view.askDirection());
            }
            view.displayBoard(game);
            if (game.isWon()) {
                view.displayWin();
            } else {
                view.displayDefeat();
            }
            keepPlaying = view.displayReplay();
            this.game = new Game();
        }
    }

    /**
     * Makes a move in the game.
     *
     * @param direction of the move.
     */
    public void move(Direction direction) {
        game.move(direction);
    }

    /**
     * Initializes a new game.
     */
    public void playAgain() {
        game.initGame(2);
    }

}
