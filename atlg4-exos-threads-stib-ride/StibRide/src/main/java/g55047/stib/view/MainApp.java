package g55047.stib.view;

import g55047.stib.model.Model;
import g55047.stib.model.config.ConfigManager;
import g55047.stib.presenter.Presenter;
import javafx.application.Application;
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
        ConfigManager.getInstance().load();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/view.fxml"));
        VBox root = loader.load();
        FxmlController view = loader.getController();
        Model model = new Model();
        Presenter presenter = new Presenter(view, model);
        presenter.initialize();
        view.setPresenter(presenter);
        stage.setTitle("StibRide");
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
