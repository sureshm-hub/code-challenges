package proj.hobby.dsa.graph.dfs;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/evaluate-division/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Graph DFS
 *
 * Complexity:
 *  Time: O(N) - build graph and DFS traversal to solve equations
 *  Space: O(N) - graph and call hierarchy
 *
 */
public class EvaluateDivisions {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        //build adjacency list from equations and values
        Map<String,Map<String, Double>> graph = new HashMap<>();

        for(int i =0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            double val = values[i];
            String nr = eq.get(0);
            String dr = eq.get(1);
            graph.computeIfAbsent(nr, k -> new HashMap<>()).put(dr, val);
            graph.computeIfAbsent(dr, k -> new HashMap<>()).put(nr, 1.0/val);
        }

        double[] result = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            Set<String> visited = new HashSet<>(); // visited nodes of graph
            result[i] = dfs(graph, visited, query.get(0), query.get(1));
        }

        // return the results
        return result;

    }

    private double dfs(Map<String, Map<String, Double>> graph, Set<String> visited, String from, String to) {
        visited.add(from);

        if(graph.get(from) == null || graph.get(to) == null) { // no connections for from or to
            return -1.0;
        }

        if(from.equals(to)) { // divide by self
            return 1.0;
        }

        Double result  = graph.get(from).get(to); //  divide by neighbor
        if(result != null) {
            return result;
        }

        // traverse the graph
        Map<String, Double> conns = graph.get(from);
        Set<String> keys = conns.keySet();
        for(String key : keys) {
            if(!visited.contains(key)) {
                double nextResult = dfs(graph, visited, key, to);
                if(nextResult != -1.0) {
                    return conns.get(key) * nextResult;
                }
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        EvaluateDivisions evd = new EvaluateDivisions();
        double[] results = evd.calcEquation(Arrays.asList(Arrays.asList("a","b"), //equations
                        Arrays.asList("b","c")),
                        new double[]{2.0,3.0}, //values
                        Arrays.asList(Arrays.asList("a","c"), //queries
                        Arrays.asList("b","a"),
                        Arrays.asList("a","e"),
                        Arrays.asList("a","a"),
                        Arrays.asList("x","x")));
       System.out.println("Evaluate Division Results: "+Arrays.toString(results));

        results = evd.calcEquation(Arrays.asList(Arrays.asList("a","b"), //equations
                        Arrays.asList("b","c"),
                        Arrays.asList("bc","cd")),
                new double[]{1.5,2.5,5.0}, //values
                Arrays.asList(Arrays.asList("a","c"), //queries
                        Arrays.asList("c","b"),
                        Arrays.asList("bc","cd"),
                        Arrays.asList("cd","bc")));
        System.out.println("Evaluate Division Results: "+Arrays.toString(results));

        results = evd.calcEquation(Arrays.asList(Arrays.asList("a","b")),//equations
                new double[]{0.5}, //values
                Arrays.asList(Arrays.asList("a","b"), //queries
                        Arrays.asList("b","a"),
                        Arrays.asList("a","c"),
                        Arrays.asList("x","y")));
        System.out.println("Evaluate Division Results: "+Arrays.toString(results));
    }
}