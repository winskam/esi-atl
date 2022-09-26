package g55047.atlg3.asciipaint.model;

/**
 * Interface that makes ColoredShape's methods accessible.
 *
 * @author Marika Winska 55047
 */
public interface Shape {

    /**
     * Checks if the given point is within an existing shape.
     *
     * @param point to check.
     * @return true if the point is in a shape, false otherwise.
     */
    public boolean isInside(Point point);

    /**
     * Moves the shape.
     *
     * @param dx horizontal displacement of the given distance.
     * @param dy vertical displacement of the given distance.
     */
    public void move(double dx, double dy);

    /**
     * Getter of the color.
     *
     * @return the color.
     */
    public char getColor();

}
