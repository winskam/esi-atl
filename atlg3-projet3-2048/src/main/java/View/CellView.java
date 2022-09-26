package View;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Class that displays the cells.
 *
 * @author Marika Winska 55047
 */
public class CellView extends StackPane {

    private final Text textValue;
    private final Rectangle cell;

    /**
     * Constructor of the view of a cell.
     *
     * @param value of a cell.
     */
    public CellView(int value) {
        super();
        cell = new Rectangle(50, 50);
        this.textValue = new Text(String.valueOf(value));
        this.getChildren().addAll(cell, textValue);
    }

    /**
     * Getter of the value of a cell.
     *
     * @return the value.
     */
    public int getValue() {
        return Integer.parseInt(textValue.getText());
    }

    /**
     * Setter of a value in the cell.
     *
     * @param value set.
     */
    public void setValue(int value) {
        this.textValue.setText(String.valueOf(value));
    }

    /**
     * Changes the color according to the value.
     */
    public void changeColor() {
        cell.getStyleClass().clear();
        cell.setStyle(null);
        int value = getValue();
        cell.getStyleClass().add("color" + value);
    }

}
