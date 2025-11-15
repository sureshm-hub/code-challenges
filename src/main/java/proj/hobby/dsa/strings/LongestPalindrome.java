package proj.hobby.dsa.strings;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/longest-palindrome/
 *
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {

        Map<Character, int[]> chars = new HashMap<>();

        for(char c : s.toCharArray()) {
            chars.computeIfAbsent(c, _ -> new int[]{0})[0]++;
        }

        int sum = 0;
        int extra = 0;
        for(char c : chars.keySet()) {
            int val = chars.get(c)[0];
            if(val % 2  == 0) {
                sum += val;
            } else{
                extra = 1;
                val--;
                sum += val;
            }
        }
        return sum + extra;
    }
}
