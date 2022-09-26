package View;

import Controller.Controller;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * Class that displays the button to play again.
 *
 * @author Marika Winska 55047
 */
public final class PlayAgainButton extends Button {

    private final Controller controller;

    /**
     * Constructor of the button.
     *
     * @param controller that interacts with the game.
     */
    public PlayAgainButton(Controller controller) {
        super("Recommencer");
        this.controller = controller;
        addHandlerPlayAgain();
    }

    /**
     * Adds a handler to the button that will ask the controller to restart the
     * game.
     */
    public void addHandlerPlayAgain() {
        this.setOnMouseClicked((MouseEvent arg0) -> {
            controller.playAgain();
        });
    }

}
