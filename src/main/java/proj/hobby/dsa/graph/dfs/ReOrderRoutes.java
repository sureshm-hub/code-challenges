package proj.hobby.dsa.graph.dfs;

import java.util.*;


/**
 * https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Build Adjacency List and Graph DFS
 *
 * Complexity:
 *  Time: O(N) - Build Adjacency List and DFS processing
 *  Space: O(N) - Store N nodes, Adjacency List
 *
 */
public class ReOrderRoutes {

    public int minReorder(int n, int[][] connections) {

        // adjacency list of connections
        List<List<int[]>> graph = new ArrayList<>();
        for(int i =0 ; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] conn : connections) {
            int from = conn[0];
            int to = conn[1];
            graph.get(from).add(new int[]{to, 1});// original direction
            graph.get(to).add(new int[]{from, 0});// reverse direction
        }

        boolean[] visited = new boolean[n];
        return dfs(graph, visited, 0);
    }

    private int dfs(List<List<int[]>> graph, boolean[] visited, int node) {
        visited[node] = true;
        int changes = 0 ;

        for(int[] cities : graph.get(node)) {
            int nextNode = cities[0];
            int nextDirection = cities[1];
            if(!visited[nextNode]) {
                changes += nextDirection;
                changes += dfs(graph, visited, nextNode);
            }
        }

        return changes;
    }


    public static void main(String[] args) {
        ReOrderRoutes ror = new ReOrderRoutes();
        System.out.println("min reorders:"+ror.minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}));
    }

}
