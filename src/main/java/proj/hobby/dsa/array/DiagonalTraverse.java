package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/diagonal-traverse
 */
public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;

        int i = 0, j = 0;
        int[] res = new int[M * N];
        int dir = 1; // 1 for up  -1 for down

        for(int k = 0 ; k < M * N; k++) {
            res[k] = mat[i][j];

            // move diagonally DIRS: NE -> (E, S) -> SW -> (S, E)
            if(dir == 1) {
                if(j == N - 1 ) {
                    i++;
                    dir = -1;
                } else if(i == 0) {
                    j++;
                    dir = -1;
                } else {
                    i--;
                    j++;
                }
            } else {
                if(i == M - 1) {
                    j++;
                    dir = 1;
                } else if(j == 0) {
                    i++;
                    dir = 1;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return res;
    }
}
