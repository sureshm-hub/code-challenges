package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/reshape-the-matrix
 */
public class ReshapeMatrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;

        if(m * n !=  r * c)   return mat;

        int i = 0;
        int [][] reshaped = new int[r][c];


        while(i < m * n) {
            int newR = i / c;
            int newC = i % c;

            int oldR = i / n;
            int oldC = i % n;

            reshaped[newR][newC] = mat[oldR][oldC];
            i++;
        }

        return reshaped;
    }

}
