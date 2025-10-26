package proj.hobby.dsa.graph.bfs;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/minimum-height-trees/description/
 */
public class MinHeightTrees {

    /**
     *
     * Leaf Trimming Technique (scales well ...)
     *
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        List<Integer> mht = new ArrayList<>();
        if(n <= 2) {
            for(int i = 0; i < n; i ++) {
                mht.add(i);
            }
            return mht;
        }

        List<List<Integer>>  graph = new ArrayList<>();
        int[] deg = new int[n];

        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for(int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
            deg[e[0]]++;
            deg[e[1]]++;
        }

        ArrayDeque<Integer> leaves = new ArrayDeque<>();

        for(int i = 0 ; i < n; i++) {
            if(deg[i] == 1) leaves.add(i);
        }

        int rem = n;
        while(rem > 2) {
            int sz = leaves.size();
            rem -= sz;

            for(int i = 0; i < sz; i++) {
                int e = leaves.poll();
                for(int v : graph.get(e)) {
                    --deg[v];
                    if(deg[v] == 1) leaves.add(v);
                }
            }
        }

        return new ArrayList<>(leaves);
    }

    /**
     * suffers with TLE for sparse graphs (compare/contrast with findMinHeightTreesAdjacentMap)
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTreesAdjacentList(int n, int[][] edges) {

        if(n == 1) {
            return List.of(0);
        }

        List<List<Integer>>  graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for(int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        Map<Integer, List<Integer>> rootHeights = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int cur = height(graph, i);
            rootHeights.computeIfAbsent( cur, x -> new ArrayList<>()).add(i);
            min = Math.min(min, cur);
        }

        return  rootHeights.get(min);
    }

    private int height(List<List<Integer>> graph, int root) {
        boolean[] vis = new boolean[graph.size()];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(root);
        vis[root] = true;
        int height = 0;
        while(!q.isEmpty()) {
            int sz = q.size();
            while(sz-- > 0) {
                int u = q.poll();
                for( int v : graph.get(u)) {
                    if(!vis[v]) {vis[v] = true; q.add(v);}
                }
            }
            height++;
        }
        return height;
    }

    /**
     * suffers with TLE for sparse graphs
     *
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTreesAdjacentMap(int n, int[][] edges) {

        if(n == 1) {
            return List.of(0);
        }

         Map<Integer, List<Integer>> edgeMap = new HashMap<>();
         int nodeMin = Integer.MAX_VALUE, nodeMax = Integer.MIN_VALUE;
         for(int[] e : edges) {
             edgeMap.computeIfAbsent(e[0], x -> new ArrayList<>()).add(e[1]);
             edgeMap.computeIfAbsent(e[1], x -> new ArrayList<>()).add(e[0]);
             nodeMin = Math.min(e[1], Math.min(nodeMin, e[0]));
             nodeMax = Math.max(e[1], Math.max(nodeMax, e[0]));
         }

        // System.out.println(" edge Map: "+edgeMap);
        Map<Integer, List<Integer>> rootHeights = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int cur = height2(edgeMap, i);
            rootHeights.computeIfAbsent( cur, x -> new ArrayList<>()).add(i);
            min = Math.min(min, cur);
        }

        return  rootHeights.get(min);
    }

    private int height2(Map<Integer, List<Integer>> edges, int node) {
        // System.out.println(" ==== ");
        // System.out.println(" node : "+node);
        List<Integer> level = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(node);
        level.add(node);
        int start = 0, end = level.size();
        int height = 0;
        while(start < end) {
            List<Integer> next  = new ArrayList<>();
            for(int i = start; i < end; i++){
                List<Integer> neighbs = edges.get(level.get(i));
                for(int nei : neighbs) {
                    if(visited.add(nei)) next.add(nei);
                }
            }
            level.addAll(next);
            start = end;
            end = level.size();
            height++;
            // System.out.println(" >>> "+ next);
        }
        // System.out.println(" h: "+ height);
        return height;
    }
}
