package View;

import Model.Model;
import designpattern.Observable;
import designpattern.Observer;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 * Class that displays the game board.
 *
 * @author Marika Winska 55047
 */
public class BoardView extends GridPane implements Observer {

    private final int size;

    /**
     * Constructor of the view of the game board.
     *
     * @param size of the game board.
     */
    public BoardView(int size) {
        super();
        this.size = size;
        makeEmptyBoard(size);
    }

    /**
     * Makes a board with all the zero cells.
     *
     * @param size of the game board.
     */
    private void makeEmptyBoard(int size) {
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                CellView cell = new CellView(0);
                cell.changeColor();
                this.add(cell, column, row);
            }
        }
    }

    /**
     * Updates the value of the all cells.
     *
     * @param observable the object that notifies that object.
     * @param arg none is expected here.
     */
    @Override
    public void update(Observable observable, Object arg) {
        if (observable instanceof Model) {
            Model game = (Model) observable;
            for (int row = 0; row < size; row++) {
                for (int column = 0; column < size; column++) {
                    for (Node cell : this.getChildren()) {
                        CellView newCell = (CellView) cell;
                        if (GridPane.getColumnIndex(cell) == column
                                && GridPane.getRowIndex(cell) == row) {
                            newCell.setValue(game.getCellValue(row, column));
                            newCell.changeColor();
                        }
                    }
                }
            }
        }
    }

}
