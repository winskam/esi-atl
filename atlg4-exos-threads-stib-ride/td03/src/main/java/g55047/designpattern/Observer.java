package g55047.designpattern;

/**
 * Class that will observe the observable.
 * 
 * @author Marika Winska 55047
 */
public interface Observer {

    /**
     * Updates the observer.
     * 
     * @param observable
     * @param arg
     */
    public void update(Observable observable, Object arg);
    
}
