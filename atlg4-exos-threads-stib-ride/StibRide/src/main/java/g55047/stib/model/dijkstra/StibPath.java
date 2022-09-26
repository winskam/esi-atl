package g55047.stib.model.dijkstra;

import g55047.stib.model.dto.LineDto;
import g55047.stib.model.dto.StationDto;
import g55047.stib.model.exception.RepositoryException;
import g55047.stib.model.repository.LineRepository;
import g55047.stib.model.repository.StationRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Class that will transform a stib data base to a graph.
 *
 * @author Marika Winska 55047
 */
public class StibPath {

    private Graph graph;

    /**
     * Constructor of the class.
     *
     * @throws g55047.stib.model.exception.RepositoryException
     */
    public StibPath() throws RepositoryException {
        initialize();
    }

    /**
     * Calculates the path from the station with idOrigin to the station with
     * idDestination.
     *
     * @param idOrigin the id of the station of origin.
     * @param idDestination the id of the station of destination.
     * @return a list of ids of the stations forming the path.
     * @throws g55047.stib.model.exception.RepositoryException
     */
    public List<Integer> calculatePath(int idOrigin, int idDestination) throws RepositoryException {
        initialize();
        List<Integer> path = new ArrayList<>();
        graph = calculateShortestPathFromSource(this.graph, this.graph.getNode(idOrigin));
        List<Node> nodesPath = graph.getNode(idDestination).getShortestPath();
        nodesPath.forEach((node) -> {
            path.add(node.getId());
        });
        path.add(idDestination);
        return path;
    }

    /**
     * Calculates the shortest path from the origin to each node of the graph.
     *
     * @param graph on which the operations are performed.
     * @param source the origin from which the shortest path is calculated.
     * @return the graph with the path calculated to each node.
     */
    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Entry< Node, Integer> adjacencyPair
                    : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!settledNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unsettledNodes.add(adjacentNode);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }

    /**
     * Getter for the node with the lowest distance from the origin.
     *
     * @param unsettledNodes set of nodes from which the lowest distance from
     * the origin is calculated.
     * @return the node with the lowest distance from the origin.
     */
    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node : unsettledNodes) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    /**
     * Compares the actual distance with the newly calculated one while
     * following the newly explored path.
     *
     * @param evaluationNode the node from the newly explored path.
     * @param edgeWeigh the distance of the new path.
     * @param sourceNode the origin.
     */
    private static void calculateMinimumDistance(Node evaluationNode,
            Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    /**
     * Initializes the graph with the data from the data base.
     *
     * @throws g55047.stib.model.exception.RepositoryException
     */
    public void initialize() throws RepositoryException {
        graph = new Graph();

        StationRepository stationRepository = new StationRepository();
        LineRepository lineRepository = new LineRepository();

        List<StationDto> stations = stationRepository.getAll();
        List<LineDto> lines = lineRepository.getAll();

        for (StationDto station : stations) {
            Node node = new Node(station.getKey());
            graph.addNode(node);
        }

        for (LineDto line : lines) {
            for (int order = 0; order < line.getStations().size() - 1; order++) {
                Node origin = graph.getNode(line.getStations().get(order).getKey());
                Node destination = graph.getNode(line.getStations().get(order + 1).getKey());
                origin.addDestination(destination, 1);
                destination.addDestination(origin, 1);
            }
        }
    }
    
}
