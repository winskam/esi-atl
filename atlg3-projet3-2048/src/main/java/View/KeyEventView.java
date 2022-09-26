package View;

import Controller.Controller;
import Model.Direction;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Class that handles the keys inputed by the user.
 *
 * @author Marika Winska 55047
 */
public class KeyEventView implements EventHandler<Event> {

    private final Controller controller;

    /**
     * Constructor of the class.
     *
     * @param controller
     */
    public KeyEventView(Controller controller) {
        this.controller = controller;
    }

    /**
     * Asks to the controller to move in the direction inputed by the user.
     *
     * @param t the key event.
     */
    @Override
    public void handle(Event t) {
        if (t instanceof KeyEvent) {
            KeyEvent keyEvent = (KeyEvent) t;
            KeyCode keyCode = keyEvent.getCode();
            if (null == keyCode) {
                System.out.println("NULL");
            } else {
                switch (keyCode) {
                    case UP:
                        controller.move(Direction.UP);
                        break;
                    case DOWN:
                        controller.move(Direction.DOWN);
                        break;
                    case LEFT:
                        controller.move(Direction.LEFT);
                        break;
                    case RIGHT:
                        controller.move(Direction.RIGHT);
                }
            }
        }
    }

}
