package proj.hobby.dsa.prefixTree;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/map-sum-pairs/description
 *
 */
public class MapSum {

    class Trie{
        Trie[] child = new Trie[26];
        int sum = 0;
    }

    private Trie root = new Trie();
    private Map<String, Integer> kv = new HashMap<>();

    public MapSum() {
    }

    public void insert(String key, int val) {
        int diff = val - kv.getOrDefault(key, 0);
        Trie node = root;
        for(char c : key.toCharArray()) {
            int idx = c - 'a';
            if(node.child[idx] == null) node.child[idx] = new Trie();
            node = node.child[idx];
            node.sum += diff;
        }
        kv.put(key, val);
    }

    public int sum(String prefix) {
        Trie node = root;
        for(char c : prefix.toCharArray()) {
            int idx = c - 'a';
            node = node.child[idx];
            if(node == null) return 0;
        }
        return node.sum;
    }
}
