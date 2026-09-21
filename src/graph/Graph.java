package graph;

import java.util.*;

public class Graph {

    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Add a campus location
    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add a connection/road
    public void addEdge(int vertex1, int vertex2) {
        addVertex(vertex1);
        addVertex(vertex2);

        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    // Remove a connection/road
    public void removeEdge(int vertex1, int vertex2) {
        if (adjacencyList.containsKey(vertex1) &&
            adjacencyList.containsKey(vertex2)) {

            adjacencyList.get(vertex1).remove(Integer.valueOf(vertex2));
            adjacencyList.get(vertex2).remove(Integer.valueOf(vertex1));
        }
    }

    // Remove a campus location
    public void removeVertex(int vertex) {
        if (adjacencyList.containsKey(vertex)) {

            for (List<Integer> neighbours : adjacencyList.values()) {
                neighbours.remove(Integer.valueOf(vertex));
            }

            adjacencyList.remove(vertex);
        }
    }

    // Display the campus network
    public void displayGraph() {
        for (int vertex : adjacencyList.keySet()) {
            System.out.println(vertex + " -> " + adjacencyList.get(vertex));
        }
    }

    // Get the adjacency list for BFS and DFS
    public Map<Integer, List<Integer>> getAdjacencyList() {
        return adjacencyList;
    }
}