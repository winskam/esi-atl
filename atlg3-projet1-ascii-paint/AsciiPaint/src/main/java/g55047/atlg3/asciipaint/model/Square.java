package g55047.atlg3.asciipaint.model;

/**
 * Creates a square.
 *
 * @author Marika Winska 55047
 */
public class Square extends Rectangle {

    /**
     * Constructor of the square.
     *
     * @param upperLeft point of the square.
     * @param side of the square.
     * @param color of the square.
     */
    public Square(Point upperLeft, double side, char color) {
        super(upperLeft, side, side, color);
        if (side <= 0) {
            throw new IllegalArgumentException("Impossible construction of the square.");
        }
    }

}
