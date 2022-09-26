package g55047.atlg3.asciipaint.model;

/**
 * Responsible for the actions of the class Drawing.
 *
 * @author Marika Winska 55047
 */
public class AsciiPaint {

    private Drawing drawing;

    /**
     * Constructor of the standard sheet.
     */
    public AsciiPaint() {
        this.drawing = new Drawing();
    }

    /**
     * Constructor of the sheet.
     *
     * @param width of the sheet.
     * @param height of the sheet.
     */
    public AsciiPaint(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Impossible to draw the sheet.");
        }
        this.drawing = new Drawing(width, height);
    }

    /**
     * Draws a circle and adds it to Drawing.
     *
     * @param x location of the centre of the circle.
     * @param y location of the centre of the circle.
     * @param radius of the circle.
     * @param color representation of the circle.
     */
    public void newCircle(int x, int y, double radius, char color) {
        drawing.addShape((Shape) new Circle(new Point(x, y), radius, color));
    }

    /**
     * Draws a rectangle and adds it to Drawing.
     *
     * @param x location of the upper left point on the sheet.
     * @param y location of the upper left point on the sheet.
     * @param width of the rectangle.
     * @param height of the rectangle.
     * @param color representation of the rectangle.
     */
    public void newRectangle(int x, int y, double width, double height, char color) {
        drawing.addShape((Shape) new Rectangle(new Point(x, y), width, height, color) {
        });
    }

    /**
     * Draws a square and adds it to Drawing.
     *
     * @param x location of the upper left point on the sheet.
     * @param y location of the upper left point on the sheet.
     * @param side length of the square sides.
     * @param color representation of the square.
     */
    public void newSquare(int x, int y, double side, char color) {
        drawing.addShape((Shape) new Square(new Point(x, y), side, color));
    }

    /**
     *
     * @return the sheet containing the shapes.
     */
    public String asAscii() {
        String drawingShapes = "";
        for (int y = 0; y < drawing.getHeight(); y++) {
            for (int x = 0; x < drawing.getWidth(); x++) {
                if (drawing.getShapeAt(new Point(x, y)) == null) {
                    drawingShapes += " ";
                } else {
                    drawingShapes += drawing.getShapeAt(new Point(x, y)).getColor();
                }
            }
            drawingShapes += "\n";
        }
        return drawingShapes;
    }

}
