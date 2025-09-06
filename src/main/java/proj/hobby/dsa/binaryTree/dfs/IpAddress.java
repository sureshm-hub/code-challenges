package proj.hobby.dsa.binaryTree.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/description/
 */
public class IpAddress {

    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        if(n < 4 || n > 12) { // pruning when not enough or too many parts  4 parts of 3 digits each - 12 chars max
            return Collections.emptyList();
        }

        @SuppressWarnings("unchecked")
        List<String>[][] memo = new ArrayList[n+1][5];
        return dfs(s, 0, 4, memo);
    }

    private List<String> dfs(String s, int i, int partsLeft, List<String>[][] memo) {
        if(memo[i][partsLeft] != null) return memo[i][partsLeft];

        List<String> res = new ArrayList<>();
        int n = s.length();
        int remaining = n - i;

        // feasibility prune
        if(remaining < partsLeft || remaining > 3 * partsLeft) {
            return memo[i][partsLeft] = res;
        }

        if(partsLeft == 0) {
            if( i == n) res.add("");
            return memo[i][partsLeft] = res;
        }

        // try segments of lengths 1 .. 3
        for(int len = 1; len <= 3 && i + len <= n ; len++) {

            if(len > 1 && s.charAt(i) == '0') break;

            String seg = s.substring(i, i + len);
            int val = Integer.parseInt(seg);

            if(val > 255) break;

            List<String> tails = dfs(s, i + len, partsLeft - 1, memo);
            for(String t : tails) {
                res.add(t.isEmpty() ? seg : seg+"."+t);
            }
        }
        return memo[i][partsLeft] = res;
    }
}
