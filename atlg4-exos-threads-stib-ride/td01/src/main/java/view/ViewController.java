package view;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Marika Winska 55047
 */
public class ViewController  {
    
    @FXML
    private Button button;
    
    @FXML
    private Label message;
    
    @FXML
    private Label time;

    public ViewController() {
        System.out.println("DEBUT Controller");
        
        System.out.println("FIN Controller");
    }
    
    @FXML
    public void handleButton(ActionEvent event) {
        System.out.println("BUTTON activé");
        message.setText("Au revoir");
    }

    //@Override
    //public void initialize(URL url, ResourceBundle rb) {
    //time.setText(LocalDate.now().toString());
    //}
    
}
