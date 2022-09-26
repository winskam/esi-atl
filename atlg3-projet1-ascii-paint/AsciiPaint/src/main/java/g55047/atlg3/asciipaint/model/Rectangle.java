package g55047.atlg3.asciipaint.model;

/**
 * Creating a rectangle.
 *
 * @author Marika Winska 55047
 */
public class Rectangle extends ColoredShape {

    private final Point upperLeft;
    private final double width;
    private final double height;

    /**
     * Constructor of the rectangle.
     *
     * @param upperLeft point.
     * @param width of the rectangle.
     * @param height of the rectangle.
     * @param color of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height, char color) {
        super(color);
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Impossible construction of the rectangle.");
        }
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Checks if the given point is within an existing rectangle.
     *
     * @param point given.
     * @return true if the point is in a circle, false otherwise.
     */
    @Override
    public boolean isInside(Point point) {
        return ((point.getX() >= upperLeft.getX())
                && (point.getX() <= upperLeft.getX() + width)
                && (point.getY() >= upperLeft.getY())
                && (point.getY() <= upperLeft.getY() + height));
    }

    /**
     * Moves the rectangle.
     *
     * @param dx horizontal displacement of the given distance.
     * @param dy vertical displacement of the given distance.
     */
    @Override
    public void move(double dx, double dy) {
        upperLeft.move(dx, dy);
    }

}
