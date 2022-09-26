package exercice.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Manages the right side with the GridPane.
 *
 * @author Marika Winska 55047
 */
public class GridRight extends GridPane {

    private final TextField BMRField;
    private final TextField caloriesField;

    /**
     * Constructor of the right side of the window where the user receives the
     * results.
     */
    public GridRight() {
        super();

        this.setPadding(new Insets(20));
        this.setHgap(10);
        this.setVgap(10);

        Label title = new Label("Résultats");
        title.setFont(Font.font("System", FontWeight.BOLD, 15));
        title.setUnderline(true);
        this.add(title, 0, 0, 2, 1);

        Label BMRLabel = new Label("BMR");
        this.add(BMRLabel, 0, 1);
        BMRField = new TextField();
        this.add(BMRField, 1, 1);

        Label caloriesLabel = new Label("Calories");
        this.add(caloriesLabel, 0, 2);
        caloriesField = new TextField();
        this.add(caloriesField, 1, 2);
    }

    /**
     * Setter for BMR.
     *
     * @param BMR computed.
     */
    public void setBMRField(String BMR) {
        BMRField.setText(BMR);
    }

    /**
     * Setter for calories.
     *
     * @param calories computed.
     */
    public void setCaloriesField(String calories) {
        caloriesField.setText(calories);
    }

    /**
     * Clears the data fields of GridRight.
     */
    public void clear() {
        BMRField.clear();
        caloriesField.clear();
    }

}
