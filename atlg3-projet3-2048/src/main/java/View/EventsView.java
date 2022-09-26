package View;

import designpattern.Observable;
import designpattern.Observer;
import java.util.Calendar;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

/**
 * Class that displays the events during the game.
 *
 * @author Marika Winska 55047
 */
public class EventsView extends ListView<Text> implements Observer {

    /**
     * Constructor of the view of the events.
     */
    public EventsView() {
        super();
        this.setFocusTraversable(false);
        addItem("Bienvenue dans 2048 ! ");
    }

    /**
     * Adds an event to the list according to an event in the game.
     *
     * @param observable the object that notifies that object.
     * @param arg the text to adding an event.
     */
    @Override
    public void update(Observable observable, Object arg) {
        if (arg != null) {
            String texte = (String) arg;
            addItem(texte);
        }
    }

    /**
     * Adds text with the current time to the list.
     *
     * @param text to add.
     */
    private void addItem(String text) {
        Calendar calendar = Calendar.getInstance();
        String hour = String.format("%02d:%02d",
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE));
        Text message = new Text(hour + " - " + text);
        message.getStyleClass().add("textEvents");
        this.getItems().add(message);
    }

}
