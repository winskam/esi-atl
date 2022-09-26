package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Marika Winska 55047
 */
public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("/fxml/MainView.fxml"));
        //MyTableView view = new MyTableView();
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
        //loader.setController(new ViewController());
        //AnchorPane root = loader.load();
        //ViewController ctrl = loader.getController();
        //ctrl.setModel(model);
        //Scene scene = new Scene(view);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setMinWidth(560);
        stage.setMinHeight(445);
        stage.show();
    }

}
