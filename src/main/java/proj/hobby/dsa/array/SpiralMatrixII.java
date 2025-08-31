package proj.hobby.dsa.array;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {

        if(n == 1) {
            return new int[][]{{1}};
        }
        int[][] matrix = new int[n][n];

        int layer = 0, counter = 1;

        while(layer < n-1) {
            int top=layer, left=layer, bottom=n-1-layer, right=n-1-layer;

            //top
            for(int i=left; i <= right; i++) {
                matrix[top][i]=counter++;
            }

            //right
            for(int j=top+1; j <= bottom; j++) {
                matrix[j][right]=counter++;
            }

            // bottom
            for(int i=right-1; i>=left; i--) {
                matrix[bottom][i]=counter++;
            }

            //left
            for(int j=bottom-1;j>=top+1;j--) {
                matrix[j][left]=counter++;
            }

            layer++;
        }
        return matrix;
    }
}
