package Oving8_1;

import java.util.*;

public class Node {

    private String name;

    // Tar vare på kjappeste path fra start til denne noden
    private List<Node> shortestPath = new LinkedList<>();

    // Distansen blir i førsteomgang satt til "uendelig"
    private Integer distance = Integer.MAX_VALUE;

    // Naboliste
    Map<Node, Integer> adjacentNodes = new HashMap<>();

    // metode for legge til naboer og distansen til de (?)
    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }

    public Node(String name) {
        this.name = name;
    }




    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<Node> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Map<Node, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }
}