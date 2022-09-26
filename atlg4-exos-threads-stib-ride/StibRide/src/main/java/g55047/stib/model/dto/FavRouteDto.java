package g55047.stib.model.dto;

/**
 * Class that represents a favourite route.
 * 
 * @author Marika Winska 55047
 */
public class FavRouteDto extends Dto<Integer> {

    private String name;
    private final int origin;
    private final int destination;

    /**
     * Constructor of the class.
     * 
     * @param key the id of the favourite route.
     * @param name of the favourite route.
     * @param origin of the favourite route.
     * @param destination of the favourite route.
     */
    public FavRouteDto(Integer key, String name, int origin, int destination) {
        super(key);
        this.name = name;
        this.origin = origin;
        this.destination = destination;
    }

    /**
     * Getter for the name of the favourite route.
     * 
     * @return a string of the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the origin of the favourite route.
     * 
     * @return the id of the origin.
     */
    public int getOrigin() {
        return origin;
    }

    /**
     * Getter for the destination of the favourite route.
     * 
     * @return the id of the destination.
     */
    public int getDestination() {
        return destination;
    }
    
    /**
     * Setter to change the name of a favourite route.
     * 
     * @param name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

}
