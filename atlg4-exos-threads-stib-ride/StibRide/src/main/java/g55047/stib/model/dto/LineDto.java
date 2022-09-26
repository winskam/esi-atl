package g55047.stib.model.dto;

import java.util.List;

/**
 * Class that represents a line of the metro.
 * 
 * @author Marika Winska 55047
 */
public class LineDto extends Dto<Integer> {

    List<StationDto> stations;
    
    /**
     * Constructor of the class.
     * 
     * @param key the id of the line.
     */
    public LineDto(Integer key) {
        super(key);
    }

    /**
     * Constructor of the class.
     * 
     * @param stations list of stations on this line.
     * @param key id of the line.
     */
    public LineDto(List<StationDto> stations, Integer key) {
        super(key);
        this.stations = stations;
    }

    /**
     * Getter for the stations on this line.
     * 
     * @return a list of stations.
     */
    public List<StationDto> getStations() {
        return stations;
    }

    /**
     * Setter for the stations on this line.
     * 
     * @param stations to set.
     */
    public void setStations(List<StationDto> stations) {
        this.stations = stations;
    }

}
