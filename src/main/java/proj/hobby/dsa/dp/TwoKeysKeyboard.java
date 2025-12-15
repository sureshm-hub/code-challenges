package proj.hobby.dsa.dp;

/**
 *
 * https://leetcode.com/problems/2-keys-keyboard
 */
public class TwoKeysKeyboard {

    public int minSteps(int n) {
        int[] dp = new int[n+1];

        for(int i = 2; i <= n; i++ ) {
            dp[i] = i;// copy once and paste A i-1 times
            for(int j = i/2; j > 2; --j) {
                if(i % j == 0)  {
                    dp[i] = dp[j] + i / j;// paste dp[j] i/j times
                    break;
                }
            }
        }

        return dp[n];
    }
}
