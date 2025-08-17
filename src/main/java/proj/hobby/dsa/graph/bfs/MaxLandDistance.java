package proj.hobby.dsa.graph.bfs;
import java.util.*;

public class MaxLandDistance {
    
    public int maxDistance2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        List<int[]> lands = new ArrayList<>();
        for(int i =0; i < m; i++) {
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) {
                    lands.add(new int[]{i, j});
                }
            }
        }

        int max = -1;
        for(int i =0; i < m; i++) {
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) {
                    int curr = Integer.MAX_VALUE;
                    for(int[] land : lands) {
                        curr = Math.min(Math.abs(i-land[0])+Math.abs(j-land[1]), curr);
                    }
                    if(!lands.isEmpty()){
                        max = Math.max(curr, max);
                    }
                }
            }
        }
        System.out.println(" >> "+max);
        return max;
    }

    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        LinkedList<int[]> queue = new LinkedList<>();
        for(int i =0; i < m; i++) {
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if(queue.size() == 0 || queue.size() == m*n) {
            return -1; // All Land or all Water
        }

        int[][] choices = new int[][]{{1,0}, {-1,0},{0,1}, {0,-1}};
        int distance = -1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for(int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                for(int[] next: choices) {
                    int newX = curr[0]+next[0];
                    int newY = curr[1]+next[1];
                    if(newX >= 0 && newY >=0 && newX < m && newY < n && grid[newX][newY] == 0) {
                        grid[newX][newY] = 1;// Mark Visited
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        MaxLandDistance q = new MaxLandDistance();
        q.maxDistance(new int[][]{{1,0,1},{0,0,0},{1,0,1}});
        q.maxDistance(new int[][]{{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}});
    }
}
