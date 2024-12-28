package proj.hobby.dsa.graph.dfs;

/**
 * https://leetcode.com/problems/number-of-provinces/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Graph - DFS
 *
 * Complexity:
 *  Time: O(V^2) - V is number of cities
 *  Space: O(V)
 *
 */

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int currProvince = 0;
        boolean[] visited = new boolean[isConnected[0].length];
        for(int i =0 ; i <visited.length; i++) {
            if(!visited[i]) {
                findCircleNum(isConnected, i, visited);
                currProvince++;
            }
        }
        return currProvince;
    }

    public void findCircleNum(int[][] isConnected, int node, boolean[] visited) {
        visited[node] = true;
        for(int i = 0; i < isConnected[node].length; i++) {
            if(isConnected[node][i] == 1 && !visited[i]) {
                findCircleNum(isConnected, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfProvinces provinces = new NumberOfProvinces();
        System.out.println("provinces: "+provinces.findCircleNum(new int[][]{{1,1,0},{1,1,0}, {0,0,1}}));
        System.out.println("provinces: "+provinces.findCircleNum(new int[][]{{1,0,0},{0,1,0}, {0,0,1}}));
        System.out.println("provinces: "+provinces.findCircleNum(new int[][]{
                {1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
                {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
                {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
                {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
                {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
                {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
                {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
                {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
                {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}}));
    }
}
