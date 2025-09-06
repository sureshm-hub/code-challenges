package proj.hobby.dsa.binaryTree.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/unique-binary-search-trees/description/
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        Map<String, Integer> map = new HashMap<>();
        return generate(1, n, map);
    }

    private int generate(int lo, int hi, Map<String, Integer> map) {
        String key = lo+","+hi;
        if(map.get(key) != null){
            return map.get(key);
        }

        if(lo == hi) {
            return 1;
        }

        if(lo > hi) {
            return 0;
        }

        int total = 0;
        for(int j = lo; j <= hi; j++) {
            int left = generate(lo, j-1, map);
            int right = generate(j+1, hi, map);
            int curr = 0;
            if(left == 0 || right == 0) {
                curr = left + right;
            } else {
                curr = left * right;
            }
            total += curr;
        }
        map.put(key, total);
        return total;
    }
}
