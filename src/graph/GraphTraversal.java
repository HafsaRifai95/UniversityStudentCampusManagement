package graph;

import java.util.*;

public class GraphTraversal {

    public static void BFS(Map<Integer, List<Integer>> graph, int start) {

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {

            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbour : graph.getOrDefault(current, new ArrayList<>())) {

                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }

        System.out.println();
    }

    public static void DFS(Map<Integer, List<Integer>> graph, int start) {

        Set<Integer> visited = new HashSet<>();

        System.out.print("DFS Traversal: ");

        DFSRecursive(graph, start, visited);

        System.out.println();
    }

    private static void DFSRecursive(
            Map<Integer, List<Integer>> graph,
            int current,
            Set<Integer> visited) {

        visited.add(current);
        System.out.print(current + " ");

        for (int neighbour : graph.getOrDefault(current, new ArrayList<>())) {

            if (!visited.contains(neighbour)) {
                DFSRecursive(graph, neighbour, visited);
            }
        }
    }
}