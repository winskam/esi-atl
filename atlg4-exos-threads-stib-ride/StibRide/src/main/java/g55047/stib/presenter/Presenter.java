package g55047.stib.presenter;

import g55047.stib.designpattern.Observable;
import g55047.stib.designpattern.Observer;
import g55047.stib.model.Model;
import g55047.stib.model.exception.RepositoryException;
import g55047.stib.view.FxmlController;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents a presenter in MVP pattern.
 *
 * @author Marika Winska 55047
 */
public class Presenter implements Observer {

    private final FxmlController view;
    private final Model model;

    /**
     * Constructor of the class.
     *
     * @param view that presenter will manage.
     * @param model that presenter will manage.
     */
    public Presenter(FxmlController view, Model model) {
        this.view = view;
        this.model = model;
        model.addObserver(this);
    }

    /**
     * Sets the stations in the view.
     *
     * @throws RepositoryException
     */
    public void setStations() throws RepositoryException {
        List<String> stations = new ArrayList<>();
        model.getStations().forEach((station) -> {
            stations.add(station.getName());
        });
        view.initOrigDest(stations);
    }

    /**
     * Asks the model to getNamesStations the path between the origin and the
     * destination.
     *
     * @param origin of the path.
     * @param destination of the path.
     * @throws RepositoryException
     */
    public void calculatePath(String origin, String destination) throws RepositoryException {
        view.clearTable();
        model.calculatePath(origin, destination);
    }

    /**
     * Asks the model to getNamesStations the favourite path.
     *
     * @param favourite name of the favourite.
     * @throws RepositoryException
     */
    public void calculateFavPath(String favourite) throws RepositoryException {
        view.clearTable();
        model.calculateFavPath(favourite);
        view.clearComboBox();
    }

    /**
     * Asks the model to add a favourite to the data base.
     *
     * @param origin of the favourite.
     * @param destination of the favourite.
     * @param name of the favourite.
     * @throws RepositoryException
     */
    public void addFavourite(String origin, String destination, String name) throws RepositoryException {
        model.addFavourite(origin, destination, name);
    }

    /**
     * Asks the model to delete a favourite from the data base.
     *
     * @param name of the favourite.
     * @throws RepositoryException
     */
    public void deleteFavourite(String name) throws RepositoryException {
        model.deleteFavourite(name);
    }

    /**
     * Asks the model to update the favourites in the list.
     *
     * @param name to change.
     * @param newName to set.
     * @param origin of the favourite.
     * @param destination of the favourite.
     * @throws RepositoryException
     */
    public void updateFavourite(String name, String newName, String origin, String destination) throws RepositoryException {
        if (name != null && newName != null && origin != null && destination != null) {
            model.updateFavourite(name, newName, origin, destination);
        } else if (name != null && newName != null) {
            model.updateFavouriteName(name, newName);
        }
    }

    /**
     * Asks the model to update the favourites in the list.
     *
     * @throws RepositoryException
     */
    public void updateFavourites() throws RepositoryException {
        model.updateFavourites();
    }

    /**
     * Initializes the view with the data base.
     *
     * @throws RepositoryException
     */
    public void initialize() throws RepositoryException {
        setStations();
        updateFavourites();
    }

    @Override
    public void update(Observable observable, Object arg) {
        if (arg != null) {
            view.addPath(arg);
        }
        if (observable instanceof Model) {
            Model model = (Model) observable;
            view.setFavourites(model.getFavourites());
        }
    }

}
