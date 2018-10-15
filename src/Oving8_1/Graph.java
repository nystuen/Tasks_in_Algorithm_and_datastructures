package Oving8_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Graph {

    int N, K;
    Node start = null;
    private Set<Node> nodes = new HashSet<>();


    // Les inn graf
    public void ny_vgraf(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        System.out.println("Antall node: " + N + " Antall kanter: " + K);

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int fra = Integer.parseInt(st.nextToken());
            int til = Integer.parseInt(st.nextToken());
            int vekt = Integer.parseInt(st.nextToken());


            System.out.println("Node: " + fra + ", fra:" + fra + " vekt: " + vekt);
            Node n = new Node("" + fra);

            if(!nodeExists(n)){
                addNode(n);
            }

            if (!nodes.contains(n)) {
                addNode(n);
            }

            n.addDestination(new Node("" + til), vekt);

            if (start == null) {
                start = n;
            }


        }
    }

    public boolean nodeExists(Node s) {
        for (Node n : nodes) {
            if (n.getName().equals(s.getName())) {
                return true;
            }
        }
        return false;
    }

    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }

    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;

        for (Node node : unsettledNodes) {
            if (node.getDistance() < lowestDistance) {
                lowestDistance = node.getDistance();
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
            evaluationNode.setDistance(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }

    public static Graph dijkstra(Graph graph, Node source) {
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while (unsettledNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);
            for (Map.Entry<Node, Integer> adjacencyPair :
                    currentNode.getAdjacentNodes().entrySet()) {
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

    // getters and setters

    public static void main(String[] args) throws IOException {
        FileReader leseforbTilFil = new FileReader("/Users/adnenystuen/Documents/Skole/Java/IdeaProjects/Tasks_in_AlgorithmAndDatastructures/src/Oving8_1/eksempelFil");
        BufferedReader br = new BufferedReader(leseforbTilFil);
        Graph g = new Graph();

        g.ny_vgraf(br);

        Graph shortestPath = g.dijkstra(g, g.start);

        for (Node n : shortestPath.nodes) {
            System.out.println("Node: " + n.getName());
        }
    }
}