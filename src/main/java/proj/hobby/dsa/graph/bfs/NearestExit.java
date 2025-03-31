package proj.hobby.dsa.graph.bfs;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Graph BFS
 *
 * Complexity:
 *  Time: O(MN) - BFS traversal
 *  Space: O(MN) - for levelQ
 */
public class NearestExit {

    public int nearestExit(char[][] maze, int[] entrance) {
        int steps = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(entrance);
        int rows = maze.length, cols = maze[0].length;
        maze[entrance[0]][entrance[1]] = '+'; // mark entrance as visited
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                int[] currentCell = queue.poll();
                int  y = currentCell[0], x = currentCell[1]; //(y, x) co-ordinates
                // check if currentCell is exit
                if((y == 0 || y == rows-1 || x == 0 || x == cols-1)
                        && (y != entrance[0] || x != entrance[1])) { // exclude entrance
                    return steps;// found exit return
                }


                // Add Next cells to Queue
                int[][] directions = new int[][] {{-1,0},{1, 0},{0,-1}, {0,1}};
                for(int[] dir : directions) {
                    int newX = x+dir[1], newY = y+dir[0];
                    if(newX >= 0 && newX < cols && newY >=0  && newY < rows &&
                        maze[newY][newX] == '.') {
                        queue.add(new int[]{newY, newX});
                        maze[newY][newX] = '+'; // mark as visited
                    }
                }
            }
            steps++; // track number of steps
        }
        return -1;
    }

    public static void main(String[] args) {
        NearestExit ne = new NearestExit();
        System.out.println("steps to exit: "+ ne.nearestExit(new char[][]
                {{'+','+','.','+'},
                {'.','.','.','+'},
                {'+','+','+','.'}}, new int[]{1,2}));
        System.out.println("steps to exit: "+ ne.nearestExit(new char[][]
                {{'+','+','+'},
                 {'.','.','.'},
                 {'+','+','+'}}, new int[]{1,0}));
        System.out.println("steps to exit: "+ ne.nearestExit(new char[][]
                {{'.','+'}}, new int[]{0,0}));
        System.out.println("steps to exit: "+ ne.nearestExit(new char[][]
                {{'.','.'}}, new int[]{0,0}));
        System.out.println("steps to exit: "+ ne.nearestExit(new char[][]
                {{'.','.'}}, new int[]{0,1}));
    }

}
