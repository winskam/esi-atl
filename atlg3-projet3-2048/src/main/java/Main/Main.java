package Main;

import Controller.Controller;
import Model.Game;
import View.View;

/**
 * Class that starts the game.
 *
 * @author Marika Winska 55047
 */
public class Main {

    /**
     * Method main that creates a controller with the game and the view. The
     * game starts.
     *
     * @param args the arguments given in the terminal.
     */
    public static void main(String[] args) {
        Controller controller = new Controller(new Game(), new View());
        controller.startGame();
    }

}
