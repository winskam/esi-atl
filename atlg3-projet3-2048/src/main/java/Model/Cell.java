package Model;

/**
 * Class of a square on the game board containing a multiple of 2.
 *
 * @author Marika Winska 55047
 */
public class Cell {

    private final int number;

    /**
     * Constructor of the class Cell.
     *
     * @param number in the corresponding cell/square.
     */
    public Cell(int number) {
        double log = Math.log(number) / Math.log(2);
        if (number < 2 || !(log % 1 == 0)) {
            throw new IllegalArgumentException("Invalid argument.");
        }
        this.number = number;
    }

    /**
     * Getter of the number of the corresponding cell.
     *
     * @return the multiple of 2.
     */
    public int getNumber() {
        return number;
    }

}
