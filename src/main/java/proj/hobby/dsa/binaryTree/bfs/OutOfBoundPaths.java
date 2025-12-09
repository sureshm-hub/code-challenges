package proj.hobby.dsa.binaryTree.bfs;

/**
 *
 * https://leetcode.com/problems/out-of-boundary-paths
 *
 */
public class OutOfBoundPaths {

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        //  BFS correct idea: misses path multiplicities - queue stores each position only once per layer
        // Queue<int[]> pos = new ArrayDeque<>();
        // pos.add(new int[] {startRow, startColumn});

        // //adjust m, n for 0 index
        // m--; n--;

        // int paths = 0;
        // int mod = 1_000_000_007;//10 ^ 9 + 7;
        // int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        // while(maxMove > 0) {
        //     Queue<int[]> next = new ArrayDeque<>();
        //     while(!pos.isEmpty()) {
        //         int[] p =  pos.poll();
        //         for(int[] dir : dirs) {
        //             int newX = p[0] + dir[0];
        //             int newY = p[1] + dir[1];

        //             if(newX < 0 || newY < 0 || newX > m || newY > n) {
        //                 paths++;
        //                 paths %= mod;
        //             } else {
        //                 next.add(new int[] {newX, newY});
        //             }
        //         }
        //     }

        //     pos = next;
        //     maxMove--;
        // }

        // return paths;

        int mod = 1_000_000_007;

        // dp[r][c] number of ways to be at (r, c) with the current # of moves
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        long paths = 0;

        for(int move = 1; move <= maxMove; move++) {
            int[][] next =  new int[m][n];

            for(int r = 0;  r <  m; r++) {
                for(int c = 0;  c < n; c++) {
                    int count =  dp[r][c];

                    if(count == 0) continue;

                    for(int[] dir : dirs) {
                        int newX = r + dir[0];
                        int newY = c + dir[1];

                        if(newX < 0 || newY < 0 || newX >= m || newY >= n) {
                            paths += count;
                            if (paths >= mod) paths -= mod;
                        } else {
                            // accumulate ways for  next step
                            next[newX][newY] = (int)((next[newX][newY] + (long) count) % mod);
                        }
                    }
                }
            }

            dp = next;
        }


        return (int) (paths % mod);
    }
}
