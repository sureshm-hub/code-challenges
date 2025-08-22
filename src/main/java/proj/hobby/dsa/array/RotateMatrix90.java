package proj.hobby.dsa.array;

/**
 * https://leetcode.com/problems/rotate-image/
 */
public class RotateMatrix90 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int outer = 0; outer < n/2; outer++) {
            int start = outer, end = n-1-outer;

            for(int i = start, j = end; i < end; i++, j--) {

                int top = matrix[start][i];

                //left -> top
                matrix[start][i] = matrix[j][start];

                //bottom -> left
                matrix[j][start] = matrix[end][j];

                //right -> bottom
                matrix[end][j] = matrix[i][end];

                //top -> right
                matrix[end][j] = top;
            }
        }
    }


}
