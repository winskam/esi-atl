package g55047.view;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Class main that launches the application.
 *
 * @author Marika Winska 55047
 */
public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = FXMLLoader.load(getClass().getResource("/fxml/sort.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Entry point of the application.
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}
