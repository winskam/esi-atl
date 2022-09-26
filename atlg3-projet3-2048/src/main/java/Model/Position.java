package Model;

/**
 * Position on the board. A position consists of a row and a column.
 *
 * @author Marika Winska 55047
 */
public class Position {

    private final int row;
    private final int column;

    /**
     * Constructor of the position on the game board given in parameters.
     *
     * @param row the position on the row.
     * @param column the position on the column.
     */
    public Position(int row, int column) {
        if (row < 0 || column < 0) {
            throw new IllegalArgumentException("Invalid argument.");
        }
        this.row = row;
        this.column = column;
    }

    /**
     * Constructor of the default position on the game board at (0, 0).
     */
    public Position() {
        this.row = 0;
        this.column = 0;
    }

    /**
     * Getter of row.
     *
     * @return the position on the row.
     */
    int getRow() {
        return row;
    }

    /**
     * Getter of column.
     *
     * @return the position on the column.
     */
    int getColumn() {
        return column;
    }

}
