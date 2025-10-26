package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/super-pow/
 */
public class SuperPow {

    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int ans = 1;

        a %= MOD;

        for(int i : b) {
            ans = modPow(ans, 10)  * modPow(a, i) % MOD;
        }

        return ans;
    }

    private int modPow(int x, int n) {
        if(n == 0) return 1;
        if(n %2 == 1) {
            return x * modPow( x % MOD, (n - 1)) % MOD;
        }
        return modPow(x * x % MOD, (n/2)) % MOD;
    }
}
