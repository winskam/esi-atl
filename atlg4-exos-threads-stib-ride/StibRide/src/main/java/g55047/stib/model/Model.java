package g55047.stib.model;

import g55047.stib.designpattern.Observable;
import g55047.stib.designpattern.Observer;
import g55047.stib.model.dijkstra.StibPath;
import g55047.stib.model.dto.FavRouteDto;
import g55047.stib.model.dto.StationDto;
import g55047.stib.model.exception.RepositoryException;
import g55047.stib.model.repository.FavRouteRepository;
import g55047.stib.model.repository.StationRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that represents the all model of the application.
 *
 * @author Marika Winska 55047
 */
public class Model implements Observable {

    private final List<Observer> observers = new ArrayList<>();
    private StibPath stibPath;
    private StationRepository stationRepository;
    private FavRouteRepository favRouteRepository;
    private List<String> favourites;

    /**
     * Constructor of the class Model.
     */
    public Model() {
        try {
            stibPath = new StibPath();
            stationRepository = new StationRepository();
            favRouteRepository = new FavRouteRepository();
        } catch (RepositoryException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Getter for the list of all the stations.
     *
     * @return a list of station dtos.
     * @throws RepositoryException if the resource can't be accessed.
     */
    public List<StationDto> getStations() throws RepositoryException {
        return stationRepository.getAll();
    }

    /**
     * Getter for the names of the favourites.
     *
     * @return a list of string for the favourites.
     */
    public List<String> getFavourites() {
        return favourites;
    }

    /**
     * Getter for the id of a favourite route.
     *
     * @param name of the favourite route.
     * @return the id.
     * @throws RepositoryException if the resource can't be accessed.
     */
    public int getIdFav(String name) throws RepositoryException {
        List<FavRouteDto> routes = favRouteRepository.getAll();
        int id = 0;
        for (FavRouteDto route : routes) {
            if (route.getName().equals(name)) {
                id = route.getKey();
            }
        }
        return id;
    }

    /**
     * Getter for the id of a station.
     *
     * @param name of the station.
     * @return the id.
     * @throws RepositoryException if the resource can't be accessed.
     */
    public int getIdStation(String name) throws RepositoryException {
        int idStation = 0;
        for (StationDto station : stationRepository.getAll()) {
            if (station.getName().equals(name)) {
                idStation = station.getKey();
            }
        }
        return idStation;
    }

    /**
     * Gets the names of a list of ids of stations and notifies the observers
     * with each name.
     *
     * @param path list of ids of stations.
     * @throws RepositoryException if the resource can't be accessed.
     */
    public void getNamesStations(List<Integer> path) throws RepositoryException {
        List<StationDto> stationsPath = new ArrayList<>();
        for (int idStation : path) {
            StationDto station = stationRepository.get(idStation);
            stationsPath.add(station);
        }
        stationsPath.forEach((station) -> {
            notifyObservers(station);
        });
    }

    /**
     * Calculates the path between an origin station and destination station and
     * notifies the observers with as argument the name of every station of the
     * path.
     *
     * @param origin the name of the station of origin.
     * @param destination the name of the station of destination.
     * @throws RepositoryException if the resource can't be accessed.
     */
    public void calculatePath(String origin, String destination) throws RepositoryException {
        int idOrigin = getIdStation(origin);
        int idDestination = getIdStation(destination);
        List<Integer> path = stibPath.calculatePath(idOrigin, idDestination);
        getNamesStations(path);
    }

    /**
     * Calculates the path of the given favourite and notifies the observers
     * with as argument the name of every station of the path.
     *
     * @param favourite the name of the favourite.
     * @throws RepositoryException if the resource can't be accessed.
     */
    public void calculateFavPath(String favourite) throws RepositoryException {
        int id = getIdFav(favourite);
        FavRouteDto routes = favRouteRepository.get(id);
        if (routes != null) {
            List<Integer> path = stibPath.calculatePath(routes.getOrigin(), routes.getDestination());
            getNamesStations(path);
        }
    }

    /**
     * Adds a favourite path to the data base.
     *
     * @param origin the name of the station of origin of the favourite path.
     * @param destination the name of the station of destination of the
     * favourite path.
     * @param name of the favourite path.
     * @throws RepositoryException if the resource can't be accessed.
     */
    public void addFavourite(String origin, String destination, String name) throws RepositoryException {
        int idOrigin = getIdStation(origin);
        int idDestination = getIdStation(destination);
        int id = getIdFav(name);
        favRouteRepository.add(new FavRouteDto(id, name, idOrigin, idDestination));
        updateFavourites();
    }

    /**
     * Deletes the favourite with the given name from the data base.
     *
     * @param name of the favourite to delete.
     * @throws RepositoryException if the resource can't be accessed.
     */
    public void deleteFavourite(String name) throws RepositoryException {
        int id = getIdFav(name);
        favRouteRepository.remove(id);
        updateFavourites();
    }

    /**
     * Updates an existing favourite.
     *
     * @param name of the favourite.
     * @param newName of the favourite.
     * @param origin of the favourite.
     * @param destination of the favourite.
     * @throws RepositoryException if the resource can't be accessed.
     */
    public void updateFavourite(String name, String newName, String origin, String destination) throws RepositoryException {
        int id = getIdFav(name);
        int idOrigin = getIdStation(origin);
        int idDestination = getIdStation(destination);
        favRouteRepository.add(new FavRouteDto(id, newName, idOrigin, idDestination));
        updateFavourites();
    }

    /**
     * Updates the name of a favourite route.
     *
     * @param name to change.
     * @param newName to set.
     * @throws RepositoryException if the resource can't be accessed.
     */
    public void updateFavouriteName(String name, String newName) throws RepositoryException {
        int id = getIdFav(name);
        FavRouteDto favToUpdate = favRouteRepository.get(id);
        favToUpdate.setName(newName);
        favRouteRepository.add(favToUpdate);
        updateFavourites();
    }

    /**
     * Updates the attribute favourites to the current favourites in the data
     * base.
     *
     * @throws RepositoryException if the resource can't be accessed.
     */
    public void updateFavourites() throws RepositoryException {
        List<String> favourites = new ArrayList<>();
        for (FavRouteDto route : favRouteRepository.getAll()) {
            favourites.add(route.getName());
        }
        this.favourites = favourites;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void notifyObservers() {
        notifyObservers(null);
    }

    @Override
    public void notifyObservers(Object arg) {
        observers.forEach((observer) -> {
            observer.update(this, arg);
        });
    }

}
