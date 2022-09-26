package exercice.view;

import javafx.scene.layout.HBox;

/**
 * Manages the two parts (left and right) created with the GridPane.
 *
 * @author Marika Winska 55047
 */
public class HBoxField extends HBox {

    private final GridLeft gridPaneLeft;
    private final GridRight gridPaneRight;

    /**
     * Constructor of the field to be completed by the user and where the user
     * receives the results.
     */
    public HBoxField() {
        super();
        gridPaneLeft = new GridLeft();
        gridPaneRight = new GridRight();
        this.getChildren().addAll(gridPaneLeft, gridPaneRight);
    }

    /**
     * Getter for GridPaneLeft where the user inserts his data.
     *
     * @return gridPaneLeft.
     */
    public GridLeft getGridPaneLeft() {
        return gridPaneLeft;
    }

    /**
     * Getter for GridPaneRight where the user receives the results.
     *
     * @return gridPaneRight.
     */
    public GridRight getGridPaneRight() {
        return gridPaneRight;
    }

    /**
     * Clears inserted data in gridPaneLeft when there is an insertion error.
     */
    public void clearGridPaneLeft() {
        gridPaneLeft.clear();
    }

}
