package proj.hobby.dsa.graph.dfs;

/**
 *
 * https://leetcode.com/problems/valid-parenthesis-string/description
 *
 */
public class ValidParenthesis {

    public boolean checkValidString(String s) {
        Boolean[][] dp = new Boolean[s.length() + 1][s.length() + 1];
        return dfs(s, 0, 0, dp);
    }

    private boolean dfs(String s, int i, int l, Boolean[][] dp) {
        if(i == s.length()) return l == 0;

        if(l < 0) return false;

        if(dp[i][l] != null) return dp[i][l];

        char c = s.charAt(i);
        boolean result;
        if(c == '(') {
            result = dfs(s, i + 1, l + 1, dp);
        } else if (c == ')') {
            result = dfs(s, i + 1, l - 1, dp);
        } else {
            // 3 possibilities when c = '*'
            result = dfs(s, i + 1, l, dp) // * as ""
                    || dfs(s, i + 1,  l + 1, dp)  // * as ()
                    || dfs(s, i + 1, l - 1, dp); // * as )
        }

        dp[i][l] = result;
        return result;
    }
}
