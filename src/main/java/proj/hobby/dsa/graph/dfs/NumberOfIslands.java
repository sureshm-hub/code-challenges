package proj.hobby.dsa.graph.dfs;

/**
 *
 * https://leetcode.com/problems/number-of-islands/description/
 *
 * Approach:  Graph DFS
 *
 * Complexity:
 *  Time: O(M*N) - M & N are grid length & width
 *  Space: O(1) - keep track of counts
 *
 *
 */
public class NumberOfIslands {

    static final char LAND = '1', WATER = '0', VISITED_LAND = 'X';
    static final int[][] DIRECTIONS = new int[][]{{-1,0},{1,0},{0,1},{0,-1}}; // left, right, up, down


    public int findNumberOfIslands(char[][] grid) {
        int count = 0;//tracking island count
        for(int i =0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == LAND) { // do DFS traversal to mark island
                    count++;// track island
                    markIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    private void markIsland(char[][] grid, int i, int j) {
        // base conditions
        if(i < 0 || i >= grid.length // x in bounds
                || j < 0 || j >= grid[0].length  // y in bounds
                || grid[i][j] == WATER  // not water
                || grid[i][j] == VISITED_LAND) { // not visited
            return;
        }
        grid[i][j] = VISITED_LAND;// mark coordinate as visited
        for(int[] dir : DIRECTIONS) {
            markIsland(grid, i+dir[0], j+dir[1]);
        }
    }

    public static void main(String[] args) {
        NumberOfIslands nl = new NumberOfIslands();
        char[][] grid = new char[][]  {
                    {'1','1','1','1','0'},
                    {'1','1','0','1','0'},
                    {'1','1','0','0','0'},
                    {'0','0','0','0','0'}
                };
        System.out.println("Number of Islands: "+nl.findNumberOfIslands(grid));

        grid = new char[][]  {
                    {'1','1','0','0','0'},
                    {'1','1','0','0','0'},
                    {'0','0','1','0','0'},
                    {'0','0','0','1','1'}
                };
        System.out.println("Number of Islands: "+nl.findNumberOfIslands(grid));
    }

}