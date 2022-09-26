package exercice.view;

import exercice.controller.Controller;
import exercice.designpattern.Observable;
import exercice.designpattern.Observer;
import exercice.model.Lifestyle;
import exercice.model.Model;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * Class where the user will write his data and where the results will be shown.
 *
 * @author Marika Winska 55047
 */
public class VBoxField extends VBox implements Observer {

    private final HBoxField MyHbox;
    private final Button BMRButton;
    private final Button ClearButton;

    /**
     * Constructor of the VBoxField that will create it by creating a
     * MyHboxField and buttons.
     */
    public VBoxField() {
        super();
        MyHbox = new HBoxField();
        this.setPadding(new Insets(15, 15, 15, 15));
        BMRButton = new Button("Calcul du BMR");
        ClearButton = new Button("Effacer");
        BMRButton.setMaxWidth(Double.MAX_VALUE);
        ClearButton.setMaxWidth(Double.MAX_VALUE);
        this.getChildren().addAll(MyHbox, BMRButton, ClearButton);
        addEventHandlerClear();
    }

    /**
     * Adds an event to the clear button that will clear all the inputed data.
     */
    public void addEventHandlerClear() {
        ClearButton.setOnMouseClicked((MouseEvent arg0) -> {
            MyHbox.getGridPaneLeft().clear();
            MyHbox.getGridPaneRight().clear();
            BMRButton.setDisable(false);
        });
    }

    /**
     * Adds an event to the BMR button that will compute the BMR and the
     * calories with the inputed data.
     *
     * @param controller
     */
    public void addEventHandlerResult(Controller controller) {
        BMRButton.setOnMouseClicked((MouseEvent arg0) -> {
            String heightText = MyHbox.getGridPaneLeft().getHeightText();
            String weightText = MyHbox.getGridPaneLeft().getWeightText();
            String ageText = MyHbox.getGridPaneLeft().getAgeText();
            boolean isMale = MyHbox.getGridPaneLeft().getMSelected();
            boolean isFemale = MyHbox.getGridPaneLeft().getFSelected();
            Lifestyle lifeStyle = MyHbox.getGridPaneLeft().getLifestyle();

            controller.compute(heightText, weightText, ageText, isMale, isFemale,
                    lifeStyle);

        });
    }

    @Override
    public void update(Observable observable, Object arg) {
        Model model = (Model) observable;
        double BMR = model.getBMR();
        double calories = model.getCalories();
        MyHbox.getGridPaneRight().setBMRField(String.valueOf(BMR));
        MyHbox.getGridPaneRight().setCaloriesField(String.valueOf(calories));

    }

    /**
     * Displays an alert to say that the inputed data was incorrect.
     */
    public void alert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur !");
        alert.setHeaderText("Erreur !");
        alert.setContentText("Valeur non acceptée !");
        alert.showAndWait();
        MyHbox.clearGridPaneLeft();
    }

}
