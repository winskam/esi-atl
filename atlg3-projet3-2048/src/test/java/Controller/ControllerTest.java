package Controller;

import Model.Game;
import View.View;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests of the Controller class.
 *
 * @author Marika Winska 55047
 */
public class ControllerTest {

    /**
     * Test of constructor of class Controller.
     */
    @Test
    public void testController() {
        System.out.println("Invalid argument for the construction "
                + "of the controller.");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    View view = new View();
                    Controller controller = new Controller(null, view);
                });
    }

    /**
     * Test of constructor of class Controller.
     */
    @Test
    public void testConstructorBis() {
        System.out.println("Invalid argument for the construction "
                + "of the controller.");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    Game game = new Game();
                    Controller controller = new Controller(game, null);
                });
    }

}
