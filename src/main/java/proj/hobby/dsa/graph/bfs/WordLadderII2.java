package proj.hobby.dsa.graph.bfs;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/word-ladder-ii
 *
 * Refined Word Ladder II
 */
public class WordLadderII2 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);

        if(!words.contains(endWord)) return res; // prune early

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> dist = new HashMap<>();

        bfsPred(beginWord, endWord, new HashSet<>(words), graph, dist);

        if(!dist.containsKey(endWord)) return res; // prune if no path to end word

        Deque<String> path = new ArrayDeque<>();
        path.add(endWord);
        dfsPred(beginWord, endWord,  graph, dist, res, path);

        return res;
    }


    private void dfsPred(String start, String end, Map<String, List<String>> graph, Map<String, Integer> dist, List<List<String>> res, Deque<String> path) {
        if(start.equals(end)) {
            res.add(new ArrayList<>(path));
            return;
        }

        List<String> neighs = graph.getOrDefault(end, new ArrayList<>()); // construct path backwards
        for(String parent : neighs) {
            if(dist.get(end) == dist.get(parent) + 1) { // keep adjacency list tight - no back loops and move 1 step forward
                path.addFirst(parent); //build in reverse as path is from end to begin
                dfsPred(start, parent, graph, dist, res, path);
                path.poll(); // remove from front
            }
        }
    }

    private void bfsPred(String start, String end, Set<String> words, Map<String, List<String>> graph, Map<String, Integer> dist) {
        Deque<String> q = new ArrayDeque<>();
        q.offer(start);
        words.remove(start);
        dist.put(start, 0);

        boolean found = false;
        while(!q.isEmpty() && !found) {
            Set<String> visited = new HashSet<>();
            int sz = q.size();
            for(int i = 0; i < sz; i++) {
                String curr = q.poll();
                List<String> neighs = findNeighbors(curr, words);
                visited.addAll(neighs);
                for(String next : neighs) {
                    if(next.equals(end)) found = true;
                    if(!dist.containsKey(next)) {
                        dist.put(next, dist.get(curr) + 1);
                        q.offer(next);
                        // build "predecssor" adjacency list from next to cur
                        graph.computeIfAbsent(next, _ -> new ArrayList<>()).add(curr);
                    } else if(dist.get(next) == dist.get(curr) + 1) {
                        graph.computeIfAbsent(next, _ -> new ArrayList<>()).add(curr);
                    }
                }
            }
            words.removeAll(visited);
        }
    }

    private List<String> findNeighbors(String w, Set<String> words) {
        List<String> adj = new ArrayList<>();
        char[] chars = w.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];
            for(char r = 'a'; r <= 'z'; r++) {
                if(c != r) {
                    chars[i] = r;
                    String next = new String(chars);
                    if(words.contains(next)) {
                        adj.add(next);
                    }
                }
            }
            chars[i] = c; // reset
        }
        return adj;
    }
}
