package Model;

/**
 * Enumeration of possible movements during the game.
 *
 * @author Marika Winska 55047
 */
public enum Direction {
    UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1);

    private final int deltaRow;
    private final int deltaColumn;

    /**
     * Constructor of the class Direction.
     *
     * @param deltaRow movement in row.
     * @param deltaColumn movement in column.
     */
    private Direction(int deltaRow, int deltaColumn) {
        this.deltaRow = deltaRow;
        this.deltaColumn = deltaColumn;
    }

    /**
     * Getter of delta row.
     *
     * @return movement in deltaRow.
     */
    public int getDeltaRow() {
        return deltaRow;
    }

    /**
     * Getter of delta column.
     *
     * @return movement in deltaColumn.
     */
    public int getDeltaColumn() {
        return deltaColumn;
    }

}
