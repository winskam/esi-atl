package g55047.atlg3.asciipaint.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the space where the shapes are drawn (the sheet).
 *
 * @author Marika Winska
 */
public class Drawing {

    private List<Shape> shapes;
    private int height;
    private int width;

    /**
     * Constructor of the sheet.
     */
    public Drawing() {
        shapes = new ArrayList<>();
        this.width = 40;
        this.height = 30;
    }

    /**
     * Constructor of the sheet.
     *
     * @param height of the sheet.
     * @param width of the sheet.
     */
    public Drawing(int height, int width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("Impossible sheet size.");
        }
        shapes = new ArrayList<>();
        this.height = height;
        this.width = width;
    }

    /**
     * Adds a shape to the list.
     *
     * @param shape
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Checks if the given point is in a shape.
     *
     * @param point given.
     * @return the shape that contains the given point.
     */
    public Shape getShapeAt(Point point) {
        Shape getShape = null;
        for (Shape shape : shapes) {
            if (shape.isInside(point)) {
                getShape = shape;
            }
        }
        return getShape;
    }

    /**
     * Getter for the height of the sheet.
     *
     * @return the height.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Getter for the width of the sheet.
     *
     * @return the width.
     */
    public int getWidth() {
        return width;
    }

}
