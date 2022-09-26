package g55047.atlg3.asciipaint.model;

/**
 * Creating a circle.
 *
 * @author Marika Winska 55047
 */
public class Circle extends ColoredShape {

    private final Point center;
    private final double radius;

    /**
     * Constructor of the circle.
     *
     * @param center of the circle.
     * @param radius of the circle.
     * @param color representation of the circle.
     */
    public Circle(Point center, double radius, char color) {
        super(color);
        if (center == null) {
            throw new IllegalArgumentException("Center null.");
        }
        this.center = center;
        this.radius = radius;
    }

    /**
     * Checks if the given point is within an existing circle.
     *
     * @param point to check.
     * @return true if the point is in a circle, false otherwise.
     */
    @Override
    public boolean isInside(Point point) {
        return point.distanceTo(center) <= radius;
    }

    /**
     * Moves the circle.
     *
     * @param dx horizontal displacement of the given distance.
     * @param dy vertical displacement of the given distance.
     */
    @Override
    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

}
