package g55047.stib.model.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Class that represents a node.
 *
 * @author
 */
public class Node {

    private final int id;
    private List<Node> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;
    Map<Node, Integer> adjacentNodes = new HashMap<>();

    /**
     * Constructor of the class.
     *
     * @param id
     */
    public Node(int id) {
        this.id = id;
    }

    /**
     * Adds a connection between this node and the destination node of length
     * distance.
     *
     * @param destination the node that will be connected to this node.
     * @param distance the length of the connection between the two nodes.
     */
    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    /**
     * Getter for the id of the node.
     *
     * @return the id.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for the shortest path to this node.
     *
     * @return a list of nodes forming the shortest path.
     */
    public List<Node> getShortestPath() {
        return shortestPath;
    }

    /**
     * Getter for the distance to this node.
     *
     * @return a number representing the distance.
     */
    public Integer getDistance() {
        return distance;
    }

    /**
     * Getter for the nodes adjacent to this one.
     *
     * @return a map of adjacent nodes.
     */
    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    /**
     * Setter for the shortest path between the origin and he destination.
     *
     * @param shortestPath a list of nodes forming the shortest path.
     */
    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    /**
     * Setter for the distance to this node.
     *
     * @param distance to this node.
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

}
