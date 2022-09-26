package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.Etudiant;

/**
 *
 * @author Marika Winska 55047
 */
public class TableController implements Initializable {

    @FXML
    private TextField id;

    @FXML
    private TextField prenom;

    @FXML
    private TextField nom;

    @FXML
    private Label okInput;

    @FXML
    private Label errorInput;

    @FXML
    private TableView myTable;

    @FXML
    private TableColumn numeroColumn;

    @FXML
    private TableColumn prenomColumn;

    @FXML
    private TableColumn nomColumn;

    public TableController() {

    }

    @FXML
    public void handleButton(ActionEvent event) {
        addStudent();
    }

    @FXML
    public void enterPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            addStudent();
        }
    }

    public void addStudent() {
        try {
            int idInt = Integer.parseInt((id.getText()));
            String prenomInput = prenom.getText();
            String nomInput = nom.getText();
            Etudiant etudiant = new Etudiant(idInt, prenomInput, nomInput);
            myTable.getItems().add(etudiant);
            id.clear();
            prenom.clear();
            nom.clear();
            okInput.setText("Données ajoutées !");
            errorInput.setText("");
            id.requestFocus();
        } catch (Exception e) {
            okInput.setText("");
            errorInput.setText("Erreur d'encodage !");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numeroColumn.setCellValueFactory(new PropertyValueFactory<>("num"));
        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
    }

}
