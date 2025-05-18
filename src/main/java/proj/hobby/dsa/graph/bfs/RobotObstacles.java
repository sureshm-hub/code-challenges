package proj.hobby.dsa.graph.bfs;

import java.util.*;

/**
Imagine you are creating a 2D robot game. The game has a 2d grid representing a map containing your robot and obstacles.
In a given turn, your robot can walk in a straight line or diagonal how many squares it wants, but cannot go through an obstacle or
the map limit.
Implement a function that finds the number of all possible movements the robot can make in a given turn.
Treat this as production code that needs to evolve and will be maintained/reviewed by other engineers.

Example:
[ . . . X ]
[ . . . . ]
[ . R X . ]
[ . . . . ]

Output: 8

Trade-Offs:
- String vs int[] vs  Point class
    - String directly used in Collections vs int[]/Point need implementation of hashCode & equals
- Set vs Queue vs boolean[][]
    - Set for remembering the steps visited
    - Queue is for "shortest path" and not correct for straight line walk
    - boolean[][] for steps visited and space complexity always O(M*N)
    - using grid to remember is also not correct
 **/
public class RobotObstacles {

    private static final int[][] DIRECTIONS = new int[][]{
            {-1,0}, //LEFT
            {1,0}, // RIGHT
            {0,-1}, // UP
            {0,1},  // DOWN
            {-1,-1}, //LEFT UP
            {1,-1}, //RIGHT UP
            {-1,1},
            {1,1}
    }; // (x, Y) pairs
    private static final char ROBOT = 'R';
    private static final char OBSTACLE = 'X';
    private static final char EMPTY = '.';

    /**
     * complexity:
     *      Time: O(M*N) - M is Rows & N is Cols
     *      Space: O(M*N) - worst case
     *
     * @param grid
     * @param rx
     * @param ry
     * @return
     */
    public int numberOfMovements(char[][] grid, int rx, int ry) {

        // Input Validation
        if(grid == null || grid.length == 0 || grid[0].length == 0 ) {
            throw new IllegalArgumentException("grid can not be null or empty");
        }
        int rows = grid.length; // rows
        int cols = grid[0].length; // cols

        if(rx < 0 || rx > rows || ry < 0 || ry > cols) {
            throw new IllegalArgumentException("Robots position is not valid "+rx+", "+ry);
        }

        int steps = 0;
        Set<String> visited = new HashSet<>();

        // for every direction we will walk in that direction to get all the steps
        for(int[] dir : DIRECTIONS) {
            int newX  = rx+ dir[0];
            int newY = ry + dir[1];
            while(isValidPosition(grid, newX, newY, rows, cols)) { // continue in the direction till we hit a block
                String pair = newX+", "+newY;
                if(visited.add(pair)) { //add unique paths
                    steps++;
                }
                newX += dir[0];
                newY += dir[1];
            }
        }
        return steps;
    }

    private boolean isValidPosition(char[][] grid, int rx, int ry, int rows, int cols) {
        return rx >=0 && rx < rows && ry >=0 && ry < cols && grid[rx][ry] == EMPTY;
    }

    public static void main(String[] args) {
        RobotObstacles ro = new RobotObstacles();
        char[][] grid = new char[][]{
                {'.','.','.','X'},
                {'.','.','.','.'},
                {'.','R','X','.'},
                {'.','.','.','.'}
        };
        System.out.println(ro.numberOfMovements(grid,2,1));
    }
}