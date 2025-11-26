package proj.hobby.dsa.dp;

/**
 *
 * https://leetcode.com/problems/longest-palindromic-subsequence/description
 */
public class LongestPalindromicSubseq {

    public int longestPalindromeSubseq(String s) {
        int N = s.length();
        int[][] mem = new int[N][N];
        return longest(s, 0, s.length() - 1, mem);
    }

    private int longest(String s, int start, int end, int[][] mem) {

        if(start > end) return 0;

        if(start == end) return 1;

        if(mem[start][end] > 0) return mem[start][end];

        if(s.charAt(start) == s.charAt(end))
            return mem[start][end] = 2 + longest(s, start + 1, end - 1, mem);
        return mem[start][end] = Math.max(longest(s, start + 1, end, mem), longest(s, start, end - 1, mem));
    }
}
