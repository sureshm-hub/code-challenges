package proj.hobby.dsa.grpah.bfs;

import java.util.*;

/**
 * https://leetcode.com/problems/rotting-oranges/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach:
 *
 * Complexity:
 *  Time: O(MN) for building queue & traversing
 *  Space: O(MN) for queue
 *
 */
public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int total = 0; //total oranges
        int time =0, rotten = 0; //track time and rotten oranges
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < rows; i++) {
            for(int j =0; j < cols; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    rotten++;
                }
                if(grid[i][j] == 1 || grid[i][j] == 2) {
                    total++;
                }
            }
        }

        int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while(!queue.isEmpty() && total != rotten) {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize;i++) {
                int[] curr = queue.poll();
                for(int[] dir : directions) {
                    int newRow = curr[0]+dir[0], newCol = curr[1]+dir[1];
                    if((newRow >=0 && newRow < rows && newCol >= 0 && newCol < cols) // cell within grid
                            && grid[newRow][newCol] ==  1) { //  orange is fresh
                        rotten++;
                        queue.offer(new int[]{newRow, newCol});
                        grid[newRow][newCol] = 2;// mark orange as rotten
                    }
                }
            }
            time++;
        }

        return total == rotten ? time: -1;
    }

    public static void main(String[] args) {
        RottenOranges ro = new RottenOranges();
        System.out.println("time for rotting: "+ro.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
        System.out.println("time for rotting: "+ro.orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));
        System.out.println("time for rotting: "+ro.orangesRotting(new int[][]{{0,2}}));
        System.out.println("time for rotting: "+ro.orangesRotting(new int[][]{{0,2,1,0,1}}));
        System.out.println("time for rotting: "+ro.orangesRotting(new int[][]{{1,1}}));

    }

}
