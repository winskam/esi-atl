package View;

import javafx.scene.layout.HBox;

/**
 * Class that displays the game board and the events next to each other.
 *
 * @author Marika Winska 55047
 */
public class MyHBox extends HBox {

    private final BoardView boardView;
    private final EventsView eventsView;

    /**
     * Constructor of myHBox.
     */
    public MyHBox() {
        super();
        this.boardView = new BoardView(4);
        this.eventsView = new EventsView();
        this.getChildren().addAll(boardView, eventsView);
    }

    /**
     * Getter for the view of the game board.
     *
     * @return the board view.
     */
    public BoardView getBoardView() {
        return boardView;
    }

    /**
     * Getter for the view of the events.
     *
     * @return the events view.
     */
    public EventsView getEventsView() {
        return eventsView;
    }

}
