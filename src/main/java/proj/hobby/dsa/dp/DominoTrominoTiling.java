package proj.hobby.dsa.dp;

/**
 *
 * https://leetcode.com/problems/domino-and-tromino-tiling/
 */
public class DominoTrominoTiling {

    public int numTilings(int N) {
        if(N == 1) return 1;
        if(N == 2) return 2;
        long[][] dp = new long[N + 1][3];
        dp[1][0] = 1; dp[2][0] = 2;
        dp[2][1] = 1;
        dp[2][2] = 1;
        int kmod = (int)1e9 + 7;
        for(int i = 3; i <= N; i++){
            dp[i][0] = (dp[i - 1][0] + dp[i - 2][0] + dp[i - 1][1] + dp[i - 1][2]) % kmod;
            dp[i][1] = (dp[i - 2][0] + dp[i - 1][2]) % kmod;
            dp[i][2] = (dp[i - 2][0] + dp[i - 1][1]) % kmod;
        }
        return (int)dp[N][0];
    }

    public int numTilings2(int n) {
        int n0 = 1;
        int n1 = 1;
        int n2 = 2;
        int ni = 0;
        int mod = (int)1e9 + 7;
        for(int i =3; i <= n ; i++) {
            ni =  (n1 + n2 + n0*2) % mod;
            n0 = n1;
            n1 = n2;
            n2 = ni;
        }
        return ni;
    }

    public int numTilings3(int N) {
        if(N == 1) return 1;
        if(N == 2) return 2;
        long[][] dp = new long[N+1][3];
        dp[1][0] = 1;
        dp[2][0] = 2;
        dp[2][1] = 1;
        dp[2][2] = 1;
        int mod = (int) 1e9+7;
        for(int i = 3 ; i  <= N ; i++) {
           dp[i][0] = (dp[i-1][0] + dp[i-2][0] +  dp[i-1][1] + dp [i-1][2]) % mod;
           dp[i][1] = (dp[i-2][0] + dp[i-1][2]) % mod;
           dp[i][2] = (dp[i-2][0] + dp[i-1][1]) % mod;
        }
        return (int) dp[N][0];
    }

    public static void main(String[] args) {
        DominoTrominoTiling d1 = new DominoTrominoTiling();
        int N = 577;
        System.out.println("Domino Tromino Tiling: "+d1.numTilings(N));
        System.out.println("Domino Tromino Tiling: "+d1.numTilings3(N));

    }

}


