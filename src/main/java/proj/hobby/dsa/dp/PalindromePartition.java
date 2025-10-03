package proj.hobby.dsa.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/palindrome-partitioning/description
 */
public class PalindromePartition {

    public List<List<String>> partition(String s) {
        List<List<String>> partitions = new ArrayList<>();
        Map<Integer, List<List<String>>> memo = new HashMap<>();
        partition(s, 0, partitions, memo);
        return partitions;
    }

    private void partition(String s, int start, List<List<String>> partitions, Map<Integer, List<List<String>>> memo) {

        if(start == s.length()) {
            partitions.add(new ArrayList<>());
            memo.put(start, partitions);
            return;
        };

        for(int i = start; i < s.length(); i++) {
            if(isPal(s, start, i)) {
                String part = s.substring(start, i + 1);
                List<List<String>> sub = new ArrayList<>();
                if(memo.containsKey(i+1)) {
                    sub = memo.get( i + 1);
                } else {
                    partition(s, i + 1, sub, memo);
                }
                for(List<String> tail : sub) {
                    List<String> cur = new ArrayList<>(tail.size() + 1);
                    cur.add(part);
                    cur.addAll(tail);
                    partitions.add(cur);
                }
            }
        }
        memo.put(start, partitions);
    }

    private boolean isPal(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

}
