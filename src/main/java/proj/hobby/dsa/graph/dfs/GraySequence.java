package proj.hobby.dsa.graph.dfs;

import java.util.*;
/**
 *
 * https://leetcode.com/problems/gray-code/
 *
 * Time Complexity: O(n.2^N)
 * A Naive search can have O(N ^ (2^N)) time complexity
 *
 */
public class GraySequence {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        char[] zeros = new char[n];
        Arrays.fill(zeros, '0');
        String start = new String(zeros);
        path.add(start);
        seen.add(start);
        int total = 1 << n; //(int) Math.pow(2,n);
        generate(n, total, start, path, result, seen);
        return result;
    }

    private void generate(int n, int total, String curr, List<String> path, List<Integer> result, Set<String> seen) {
        if(result.size() != total && path.size() == total) {
            String first = path.get(0);
            String last = path.get(total-1);
            int diff = 0;
            for(int i = 0; i < n; i++) {
                if(first.charAt(i) != last.charAt(i)) {
                    diff++;
                    if(diff > 1) break;
                }
            }
            if(diff == 1) {
                for(String s : path) {
                    result.add(Integer.parseInt(s, 2));
                }
                return;
            }
        }

        for(int i = 0; i < n; i++) {
            char[] chars = curr.toCharArray();
            chars[i] = (chars[i] == '0') ? '1' : '0';
            String nextStr = new String(chars);
            if(!seen.contains(nextStr)) {
                seen.add(nextStr);
                path.add(nextStr);
                generate(n, total, nextStr, path, result, seen);
                path.remove(path.size()-1);
                seen.remove(nextStr);
                if(result.size() == total) return;
            }
        }
    }

}
