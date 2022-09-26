package exercice.view;

import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * Class of MenuBar.
 *
 * @author Marika Winska 55047
 */
public class MyMenuBar extends MenuBar {

    /**
     * Constructor of the MenuBar with the possibility to exit the app.
     */
    public MyMenuBar() {
        Menu myFile = new Menu("File");
        MenuItem exit = new MenuItem("exit");
        myFile.getItems().add(exit);
        this.getMenus().add(myFile);
        this.setMaxHeight(600);

        exit.addEventHandler(ActionEvent.ACTION, (ActionEvent actionEvent) -> {
            System.exit(0);
        });
    }

}
