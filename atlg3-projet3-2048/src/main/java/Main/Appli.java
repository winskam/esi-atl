package Main;

import Controller.Controller;
import Model.Game;
import View.GeneralView;
import View.KeyEventView;
import View.MyHBox;
import View.View;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX application.
 *
 * @author Marika Winska 55047
 */
public class Appli extends Application {

    /**
     * The main entry point for all JavaFX applications.
     *
     * @param stage the primary stage for this application, onto which the
     * application scene can be set.
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        MyHBox myHBox = new MyHBox();
        Game game = new Game();
        game.addObserver(myHBox.getBoardView());
        game.addObserver(myHBox.getEventsView());
        View terminalView = new View();
        Controller controller = new Controller(game, terminalView);
        GeneralView view = new GeneralView(myHBox, controller);
        KeyEventView handler = new KeyEventView(controller);
        Scene scene = new Scene(view);
        scene.setOnKeyReleased(handler);
        scene.getStylesheets().add("CSS/style.css");
        stage.setTitle("2048");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Launches the application.
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}
