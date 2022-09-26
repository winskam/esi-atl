
import exercice.controller.Controller;
import exercice.model.Model;
import exercice.view.GeneralView;
import exercice.view.MyLineCharts;
import exercice.view.VBoxField;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Class that starts the game.
 *
 * @author Marika Winska 55047
 */
public class Main extends Application {

    /**
     * The main entry point for all JavaFX applications.
     *
     * @param stage the primary stage for this application, onto which the
     * application scene can be set.
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        VBoxField vboxField = new VBoxField();
        MyLineCharts lineCharts = new MyLineCharts();
        GeneralView view = new GeneralView(vboxField, lineCharts);
        Model model = new Model();
        Controller controller = new Controller(model, vboxField);
        vboxField.addEventHandlerResult(controller);
        model.addObserver(vboxField);
        model.addObserver(lineCharts);
        Scene scene = new Scene(view);
        stage.setTitle("Calcul du BMR");
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
