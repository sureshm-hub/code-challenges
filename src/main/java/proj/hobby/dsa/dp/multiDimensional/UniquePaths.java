package proj.hobby.dsa.dp.multiDimensional;

import java.util.*;

/**
 * https://leetcode.com/problems/unique-paths/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: DP 2 Dimensional
 *
 * Complexity:
 *  Time: O(m*n) m rows, n cols
 *  Space: O(N) for storing current and result
 *
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[] result = new int[n];
        Arrays.fill(result, 1); // first row cell's have only 1  path

        for(int i = 1; i <m; i++) {
            for(int j = 1; j < n; j++) {
                result [j] += result[j-1];//update cells based on top and left
            }
        }

        return result[n-1];
    }

    public static void main(String[] args) {
        UniquePaths up = new UniquePaths();
        System.out.println("Unique Paths: "+up.uniquePaths(3,7));
        System.out.println("Unique Paths: "+up.uniquePaths(3,2));
    }
}
