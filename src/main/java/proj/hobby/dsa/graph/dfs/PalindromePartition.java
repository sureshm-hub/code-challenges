package proj.hobby.dsa.graph.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * time complexity: O(n * 2 ^ n)
 */
public class PalindromePartition {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(s, 0,res, path);
        return res;
    }

    private void dfs(String s, int start, List<List<String>> res, List<String> path) {

        if(start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < s.length(); i++) {
            if(isPalin(s, start, i)) {
                path.add(s.substring(start, i + 1));
                dfs(s, i + 1, res, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalin(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
