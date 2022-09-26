package g55047.atlg3.asciipaint.view;

import g55047.atlg3.asciipaint.model.AsciiPaint;
import java.util.Scanner;

/**
 * A class that displays the sheet and shapes and interacts with the user.
 *
 * @author Marika Winska 55047
 */
public class View {

    /**
     * Display the sheet.
     *
     * @param paint the display.
     */
    public void displayDrawing(AsciiPaint paint) {
        System.out.println(paint.asAscii());
    }

    /**
     * Interact with the user and draws the shapes.
     *
     * @param paint the display.
     */
    public void displayAscii(AsciiPaint paint) {
        System.out.print("Enter a command : ");
        Scanner clavier = new Scanner(System.in);
        boolean askAgain = true;
        while (askAgain) {
            String command = clavier.next();
            switch (command) {
                case "add":
                    String shape = clavier.next();
                    switch (shape) {
                        case "circle": {
                            int pointX = clavier.nextInt();
                            int pointY = clavier.nextInt();
                            int radius = clavier.nextInt();
                            char color = clavier.next().charAt(0);
                            paint.newCircle(pointX, pointY, radius, color);
                            break;
                        }
                        case "rectangle": {
                            int pointX = clavier.nextInt();
                            int pointY = clavier.nextInt();
                            int width = clavier.nextInt();
                            int height = clavier.nextInt();
                            char color = clavier.next().charAt(0);
                            paint.newRectangle(pointX, pointY, width, height, color);
                            break;
                        }
                        case "square": {
                            int pointX = clavier.nextInt();
                            int pointY = clavier.nextInt();
                            int side = clavier.nextInt();
                            char color = clavier.next().charAt(0);
                            paint.newSquare(pointX, pointY, side, color);
                            break;
                        }
                        default:
                            System.out.print("Command not possible ! ");
                            break;
                    }
                    break;
                case "show":
                    displayDrawing(paint);
                    break;
                case "stop":
                    askAgain = false;
                    break;
                default:
                    System.out.print("Command not possible ! ");
                    break;
            }
        }
    }

}
