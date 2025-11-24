package proj.hobby.dsa.dp;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/unique-substrings-in-wraparound-string
 */
public class UniqueSubstrings {

    public int findSubstringInWraproundString(String s) {
        int[] dp = new int[26];

        int max = 1;
        for(int i = 0; i < s.length(); i++) {
            if( i > 0  && (s.charAt(i) - s.charAt(i - 1) == 1 || s.charAt(i - 1) - s.charAt(i) == 25))
                max++;
            else
                max = 1; //reset max

            int idx = s.charAt(i) - 'a';
            dp[idx] = Math.max(dp[idx], max);
        }

        return Arrays.stream(dp).sum();
    }
}
