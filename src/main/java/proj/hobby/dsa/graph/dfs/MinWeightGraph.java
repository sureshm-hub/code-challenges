package proj.hobby.dsa.graph.dfs;

import java.util.*;

public class MinWeightGraph {

    /**
     * Complexity:
     *          Time: O(V + E * k) - V nodes, E - edges & k steps (edges used)
     *          Space: O(V * E) - adjacent map O(V * K) - min weight + O(V) - queue
     *
     * @param nodes
     * @param paths
     * @param src
     * @param dest
     * @param k
     * @return
     */
    public int shortestPath(int nodes, int[][] paths, int src, int dest, int k) {
        // Input Validation
        if(nodes < 0 || src < 0 || dest < 0 || src >= paths.length || dest >= paths.length) {
            return -1;
        }
        if(src == dest && k == 0) {
            return 0;// allow self loop if k == 0
        }

        // build adjacent map
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] path : paths) {
            adj.computeIfAbsent(path[0], x -> new ArrayList<>()).add(new int[]{path[1], path[2]}); // {neighbor, weight}
        }

        // BFS: state = (node, edgesUsed, weight)
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{src, 0, 0});// start from src and search for dest

        int[][] minWeight = new int[nodes][k+1];// min weight to node i with j edges
        for(int[] row: minWeight) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minWeight[src][0] = 0;

        while(!queue.isEmpty()) {
            int[] state = queue.poll();
            int curr = state[0], edgesUsed = state[1], weight = state[2];

            if(edgesUsed >= k  || weight >= minWeight[dest][edgesUsed]) continue;

            List<int[]> neighbors = adj.getOrDefault(curr, new ArrayList<>());
            for(int[] edge: neighbors) {
                int newEdges = edgesUsed + 1;
                int next = edge[0];
                int nextWeight = weight + edge[1];

                if(newEdges <= k && nextWeight < minWeight[next][newEdges]) {
                    minWeight[next][newEdges] = nextWeight;
                    queue.offer(new int[]{next, newEdges, nextWeight});
                }
            }
        }

        //find min weight to dest with  at most k edges
        int result = Integer.MAX_VALUE;
        for(int i = 0 ; i <= k ;i++) {
            result  = Math.min(result, minWeight[dest][i]);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    /**
     * time complexity:
     *          AdjacencyMap - O(N)
     *          calculateMinWeight - O(N  * E ^ K) - worst case dense graph to explore  all Edges of  a Node upto level K
     *          O(R*K) - result processing  - R in worst case can be exponential
     *
     * space complexity: AdjacencyMap = O(N*E) - N nodes E edges
     *          visited = O(N) - N Nodes
     *          results - O(K) - K max level
     *          currPath - O(H) - H of graph
     *          recursion - O(K) stack depth
     *
     * @param nodes
     * @param paths
     * @param src
     * @param dest
     * @param k
     * @return
     */
    public int shortestPathDFS(int nodes, int[][] paths, int src, int dest, int k) {

        Map<Integer, List<int[]>> adjacentMap = adjacentMap(paths);// make adjacent map
        Set<Integer> visited = new HashSet<>();
        List<List<int[]>> results = new ArrayList<>();
        calculateMinWeight(src, dest, adjacentMap, visited, new ArrayDeque<>(), results, 0, k);
        int minWeight = Integer.MAX_VALUE;
        for(List<int[]> result : results) {
            int currMin = result.stream().mapToInt(e -> e[2]).reduce(0, Integer::sum);
            minWeight = Math.min(minWeight, currMin);
        }
        return  minWeight == Integer.MAX_VALUE ? -1 : minWeight;
    }

    private void calculateMinWeight(int curr, int dest, Map<Integer, List<int[]>> adjacentMap, Set<Integer> visited, Deque<int[]> currPath, List<List<int[]>> results, int level, int k) {
        if(curr == dest && level <= k) {
            results.add(new ArrayList<>(currPath));
        }

        List<int[]> paths = adjacentMap.get(curr);
        if (!visited.contains(curr) && paths != null) { // prevent loop & empty paths
            visited.add(curr);
            for (int[] path : paths) {
                currPath.offerLast(path);
                calculateMinWeight(path[1], dest, adjacentMap, visited, currPath, results, level+1, k);
                currPath.pollLast();
            }
        }
    }

    private Map<Integer, List<int[]>> adjacentMap(int[][] paths) {
        Map<Integer, List<int[]>> adjacentMap = new HashMap<>();
        for(int i = 0; i < paths.length; i++) {
            List<int[]> edges = adjacentMap.getOrDefault(paths[i][0], new ArrayList<>());
            edges.add(paths[i]);
            adjacentMap.put(paths[i][0], edges);
        }
        return adjacentMap;
    }

    public static void main(String[] args) {
        int[][] paths = new int[][]{{0,1,1}, {1,2,2}, {2,3,3}, {3,1,4}, {1,3,6}, {2,0,7}};
        MinWeightGraph graph = new MinWeightGraph();
        System.out.println(" min weight 0 - 3 in 2 steps--> "+graph.shortestPath(4, paths, 0,3, 2));
        System.out.println(" min weight 0 - 3 in 3 steps--> "+graph.shortestPath(4, paths, 0,3, 3));
    }

}