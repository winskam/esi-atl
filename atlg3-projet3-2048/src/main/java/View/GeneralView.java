package View;

import Controller.Controller;
import javafx.scene.layout.VBox;

/**
 * The general view of the application.
 *
 * @author Marika Winska 55047
 */
public class GeneralView extends VBox {

    private final MyHBox myHBox;
    private final PlayAgainButton button;

    /**
     * Constructor of the general view.
     *
     * @param myHBox the hbox with the board view and the events view.
     * @param controller that controls the game.
     */
    public GeneralView(MyHBox myHBox, Controller controller) {
        this.myHBox = myHBox;
        this.button = new PlayAgainButton(controller);
        this.getChildren().addAll(myHBox, button);
    }

    /**
     * Getter of the button play again.
     *
     * @return the button.
     */
    public PlayAgainButton getButton() {
        return button;
    }

    /**
     * Getter of myHBox.
     *
     * @return myHBox.
     */
    public MyHBox getMyHBox() {
        return myHBox;
    }

}
