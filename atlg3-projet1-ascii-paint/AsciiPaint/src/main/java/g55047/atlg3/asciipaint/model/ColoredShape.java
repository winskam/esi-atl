package g55047.atlg3.asciipaint.model;

/**
 * Class that implements a way of representing a shape.
 *
 * @author Marika Winska 55047
 */
public abstract class ColoredShape implements Shape {

    private char color;

    /**
     * Constructor of the color.
     *
     * @param color given.
     */
    public ColoredShape(char color) {
        this.color = color;
    }

    /**
     * Getter of the color.
     *
     * @return the color.
     */
    @Override
    public char getColor() {
        return color;
    }

    /**
     * Setter of the color.
     *
     * @param color given.
     */
    public void setColor(char color) {
        this.color = color;
    }

}
