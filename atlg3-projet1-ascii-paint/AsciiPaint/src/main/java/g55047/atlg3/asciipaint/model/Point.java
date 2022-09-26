package g55047.atlg3.asciipaint.model;

/**
 * Represents a point.
 *
 * @author Marika Winska 55047
 */
public class Point {

    private double x;
    private double y;

    /**
     * Constructor of the point.
     *
     * @param x position.
     * @param y position.
     */
    public Point(double x, double y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Impossible position of the point.");
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Create a copy of a point.
     *
     * @param point
     */
    public Point(Point point) {
        this.x = point.getX();
        this.y = point.getY();
    }

    /**
     * Getter of the x.
     *
     * @return position of the x.
     */
    public double getX() {
        return x;
    }

    /**
     * Getter of the y.
     *
     * @return position of the y.
     */
    public double getY() {
        return y;
    }

    /**
     * Moves a point by a given distance.
     *
     * @param dx the displacement of the x.
     * @param dy the displacement of the y.
     */
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
    }

    /**
     * Calculates the distance between 2 points.
     *
     * @param other point.
     * @return the distance.
     */
    public double distanceTo(Point other) {
        return Math.sqrt(((this.getX() - other.getX()) * (this.getX() - other.getX()))
                + ((this.getY() - other.getY()) * (this.getY() - other.getY())));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
