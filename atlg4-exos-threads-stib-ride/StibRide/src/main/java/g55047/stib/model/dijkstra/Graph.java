package g55047.stib.model.dijkstra;

import java.util.HashSet;
import java.util.Set;

/**
 * Class that represents a graph.
 * 
 * @author 
 */
public class Graph {

    private final Set<Node> nodes = new HashSet<>();

    /**
     * Adds the node to the graph.
     * 
     * @param nodeA to add.
     */
    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }
    
    /**
     * Getter for the nodes of the graph.
     * 
     * @return a set of nodes.
     */
    public Set<Node> getNodes() {
        return nodes;
    }

    /**
     * Getter for the node with the given id of the graph.
     * 
     * @param id of the node to get.
     * @return the node.
     */
    public Node getNode(int id) {
        for (Node node : nodes) {
            if (node.getId() == id) {
                return node;
            }
        }
        return null;
    }

}
