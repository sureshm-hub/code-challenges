package proj.hobby.dsa.dp.multiDimensional;

/**
 *
 * https://leetcode.com/problems/longest-common-subsequence/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Dynamic Programming - multidimensional
 *  LCS(S1, S2) -  if S1[i] == S2[j] then 1 + LCS(S1-i,S2-j)
 *                 else MAX(LCS(S1,S2-j),  LCS(S1-i,S2)
 *
 * Complexity:
 *  Time: O(M*N) - M is length of String1, N is length of S2
 *  Space: O(M*N)
 *
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] dp = new int[n+1];

        for(int i = 1; i <= m; i++) {
            int[] curr = new int[n+1];
            for(int j = 1; j <= n; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    curr[j] = 1 + dp[j-1];
                } else {
                    curr[j] = Math.max(curr[j-1], dp[j]);
                }
            }
            dp = curr;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println("Longest Common Subsequence: "+lcs.longestCommonSubsequence("abcde","ace"));
        System.out.println("Longest Common Subsequence: "+lcs.longestCommonSubsequence("abcde","abcde"));
        System.out.println("Longest Common Subsequence: "+lcs.longestCommonSubsequence("abcde","xyz"));
    }
}
