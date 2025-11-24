package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/island-perimeter/description
 */
public class IslandPerimetere {

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int perimeter = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j ++) {

                if(grid[i][j] ==  1) {
                    if(i == 0)      perimeter++;     // island top
                    if(i == m-1)    perimeter++;   // island bottom
                    if(j == 0)      perimeter++;     // island edge left
                    if(j == n-1)    perimeter++;   // island edge right

                    if(j > 0 && grid[i][j - 1] == 0) perimeter++; // prev cell is water
                    if(j < n-1 && grid[i][j+1] == 0) perimeter++; // next cell is water
                    if(i > 0 && grid[i-1][j] == 0)  perimeter++; //top cell is water
                    if(i < m-1 && grid[i+1][j] == 0) perimeter++; //bottom cell is water
                }
            }
        }
        return perimeter;
    }
}
