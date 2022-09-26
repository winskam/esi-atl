package g55047.atlg3.asciipaint.controller;

import g55047.atlg3.asciipaint.model.AsciiPaint;
import g55047.atlg3.asciipaint.view.View;

/**
 * Controls the setting up and dynamics of the AsciiPaint.
 *
 * @author Marika Winska 55047
 */
public class Application {

    private final AsciiPaint paint;
    private final View display;

    /**
     * Constructor of the Application.
     */
    public Application() {
        paint = new AsciiPaint(40, 30);
        display = new View();
    }

    /**
     * Starts the functioning of the project.
     */
    public void start() {
        display.displayAscii(paint);
    }

    /**
     * Launches the project.
     *
     * @param args
     */
    public static void main(String[] args) {
        Application application = new Application();
        application.start();
    }

}
