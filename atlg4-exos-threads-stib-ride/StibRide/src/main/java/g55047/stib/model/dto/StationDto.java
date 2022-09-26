package g55047.stib.model.dto;

import java.util.List;

/**
 * Class that represents a station.
 * 
 * @author Marika Winska 55047
 */
public class StationDto extends Dto<Integer> {

    private final String name;
    private final List<Integer> lines;

    /**
     * Constructor of the class.
     * 
     * @param name of the station.
     * @param lines passing through this station.
     * @param key the id of the station.
     */
    public StationDto(String name, List<Integer> lines, Integer key) {
        super(key);
        this.name = name;
        this.lines = lines;
    }

    /**
     * Getter for the name of the station.
     * 
     * @return a string with the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the lines passing through this station.
     * 
     * @return a list of lines.
     */
    public List<Integer> getLines() {
        return lines;
    }
    
}
