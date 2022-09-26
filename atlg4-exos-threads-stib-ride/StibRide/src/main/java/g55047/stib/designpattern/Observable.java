package g55047.stib.designpattern;

/**
 * Class that will be observed by the observer.
 *
 * @author Marika Winska 55047
 */
public interface Observable {

    /**
     * Adds a class that will observe this class.
     *
     * @param obs the class to add as observer.
     */
    public void addObserver(Observer obs);

    /**
     * Notifies the observes that the asked computations are done.
     */
    public void notifyObservers();

    /**
     * Notifies the observes that the asked computations are done.
     *
     * @param arg the finished computations.
     */
    public void notifyObservers(Object arg);

}
