package exercice.view;

import exercice.model.Lifestyle;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Manages the left side with the GridPane.
 *
 * @author Marika Winska 55047
 */
public class GridLeft extends GridPane {

    private final TextField heightField;
    private final TextField weightField;
    private final TextField ageField;
    private final RadioButton femaleField;
    private final RadioButton maleField;
    private final ChoiceBox lifeField;

    /**
     * Constructor of the left side of the window where the user interacts.
     */
    public GridLeft() {
        super();

        this.setPadding(new Insets(20));
        this.setHgap(10);
        this.setVgap(10);

        Label title = new Label("Données");
        title.setFont(Font.font("System", FontWeight.BOLD, 15));
        title.setUnderline(true);
        this.add(title, 0, 0, 5, 1);

        Label heightLabel = new Label("Taille (cm)");
        this.add(heightLabel, 0, 1);
        heightField = new TextField();
        heightField.setPromptText("Taille en cm");

        this.add(heightField, 1, 1);

        Label weightLabel = new Label("Poids (kg)");
        this.add(weightLabel, 0, 2);
        weightField = new TextField();
        weightField.setPromptText("Poids en kg");

        this.add(weightField, 1, 2);

        Label ageLabel = new Label("Âge (années)");
        this.add(ageLabel, 0, 3);
        ageField = new TextField();
        ageField.setPromptText("Âge en années");
        this.add(ageField, 1, 3);

        Label sexLabel = new Label("Sexe");
        this.add(sexLabel, 0, 4);

        HBox gender = new HBox();
        ToggleGroup group = new ToggleGroup();

        femaleField = new RadioButton("Femme");
        femaleField.setToggleGroup(group);
        femaleField.setSelected(true);

        maleField = new RadioButton("Homme");
        maleField.setToggleGroup(group);
        gender.setSpacing(10);

        gender.getChildren().addAll(femaleField, maleField);
        this.add(gender, 1, 4);

        Label lifeLabel = new Label("Style de vie");
        this.add(lifeLabel, 0, 5);
        lifeField = new ChoiceBox<Lifestyle>();
        lifeField.getItems().addAll(Lifestyle.SEDENTAIRE, Lifestyle.PEU_ACTIF,
                Lifestyle.ACTIF, Lifestyle.FORT_ACTIF, Lifestyle.EXTREMENT_ACTIF);
        this.add(lifeField, 1, 5);

    }

    /**
     * Getter for the height written by the user.
     *
     * @return the height.
     */
    public String getHeightText() {
        return heightField.getText();
    }

    /**
     * Getter for the weight written by the user.
     *
     * @return the weight.
     */
    public String getWeightText() {
        return weightField.getText();
    }

    /**
     * Getter for the age written by the user.
     *
     * @return the age.
     */
    public String getAgeText() {
        return ageField.getText();
    }

    /**
     * Getter for the lifestyle selected by the user.
     *
     * @return the lidestyle.
     */
    public Lifestyle getLifestyle() {
        return (Lifestyle) lifeField.getValue();
    }

    /**
     * Getter to see if the female was selected.
     *
     * @return true if the female was selected, false otherwise.
     */
    public boolean getFSelected() {
        return femaleField.isSelected();
    }

    /**
     * Getter to see if the male was selected.
     *
     * @return true if the female was selected, false otherwise.
     */
    public boolean getMSelected() {
        return maleField.isSelected();
    }

    /**
     * Clears the data fields of GridLeft.
     */
    public void clear() {
        heightField.clear();
        weightField.clear();
        ageField.clear();
        femaleField.setSelected(false);
        maleField.setSelected(false);
        lifeField.setValue(null);
    }

}
