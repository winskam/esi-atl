package g55047.stib.view;

import g55047.stib.model.exception.RepositoryException;
import g55047.stib.presenter.Presenter;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.SearchableComboBox;

/**
 * Class that manage fxml file.
 *
 * @author Marika Winska 55047
 */
public class FxmlController implements Initializable {

    @FXML
    private TableView table;

    @FXML
    private TableColumn stationsCol;

    @FXML
    private TableColumn lineCol;

    @FXML
    private SearchableComboBox<String> origin;

    @FXML
    private SearchableComboBox<String> destination;

    @FXML
    private SearchableComboBox<String> favourites;

    @FXML
    private TextField favouriteName;

    private Presenter presenter;

    public FxmlController() {}

    /**
     * Adds the list of stations' name to origin and destination.
     *
     * @param names
     */
    public void initOrigDest(List<String> names) {
        origin.getItems().addAll(names);
        destination.getItems().addAll(names);
    }

    /**
     * Sets the presenter.
     *
     * @param presenter managing the view.
     */
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Sets favourites to the favourite box.
     *
     * @param favourites
     */
    public void setFavourites(List<String> favourites) {
        this.favourites.getItems().setAll(favourites);
    }

    /**
     * Handles the button that starts a path search.
     *
     * @param event click.
     */
    @FXML
    public void handleButtonSearch(ActionEvent event) {
        try {
            if (favourites.getValue() != null) {
                presenter.calculateFavPath(favourites.getValue());
            } else if (origin.getValue() != null && destination.getValue() != null) {
                presenter.calculatePath(origin.getValue(), destination.getValue());
            }
        } catch (RepositoryException ex) {
            Logger.getLogger(FxmlController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the button that adds a favourite.
     *
     * @param event click.
     */
    @FXML
    public void handleButtonAddFav(ActionEvent event) {
        try {
            presenter.addFavourite(origin.getValue(), destination.getValue(), favouriteName.getText());
            favouriteName.clear();
        } catch (RepositoryException ex) {
            Logger.getLogger(FxmlController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the button that deletes a favourite.
     *
     * @param event click.
     */
    @FXML
    public void handleButtonDeleteFav(ActionEvent event) {
        try {
            presenter.deleteFavourite(favourites.getValue());
        } catch (RepositoryException ex) {
            Logger.getLogger(FxmlController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the button that updates a favourite.
     *
     * @param event click.
     */
    @FXML
    public void handleButtonUpdateFav(ActionEvent event) {
        try {
            presenter.updateFavourite(favourites.getValue(), favouriteName.getText(), origin.getValue(), destination.getValue());
            favouriteName.clear();

        } catch (RepositoryException ex) {
            Logger.getLogger(FxmlController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Adds a path to the tableView.
     *
     * @param path to add.
     */
    public void addPath(Object path) {
        table.getItems().addAll(path);
    }

    /**
     * Clears all the combo box.
     */
    public void clearComboBox() {
        origin.setValue(null);
        destination.setValue(null);
        favourites.setValue(null);
    }

    /**
     * Clears the tableView.
     */
    public void clearTable() {
        table.getItems().clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stationsCol.setCellValueFactory(new PropertyValueFactory("name"));
        lineCol.setCellValueFactory(new PropertyValueFactory("lines"));
    }

}
