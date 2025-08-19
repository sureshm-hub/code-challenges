package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/minimum-operations-to-write-the-letter-y-on-a-grid/description/
 *
 */
public class MinOperationsForYGrid {

    public int minimumOperationsToWriteY(int[][] grid) {
        int r = 3; //0,1,2
        int[] yCounts = new int[r];
        int[] oCounts = new int[r];
        int yCellCount = 0;
        int n = grid.length;

        // count y & o cell
        for(int i =0; i <grid.length; i++) {
            for(int j=0; j< grid.length; j++) {

                boolean yCell = false;
                if((i <= n/2 && j <= n/2 && i == j) ||
                        (i > n/2 && j == n/2 ) ||
                        (i < n/2 && i + j == n-1)) {
                    yCell = true;
                }
                if(yCell) {
                    yCounts[grid[i][j]] += 1;
                    yCellCount++;
                } else {
                    oCounts[grid[i][j]] += 1;
                }
            }
        }

        int oCellCount = n*n - yCellCount;
        int min = Integer.MAX_VALUE;

        // Find min of all possible ops
        for(int i = 0; i < r; i++){
            for(int j = 0; j < r; j++) {
                if(i != j){
                    min = Math.min(min, oCellCount-oCounts[i]+yCellCount-yCounts[j]);
                }
            }
        }
        return min;
    }

}
