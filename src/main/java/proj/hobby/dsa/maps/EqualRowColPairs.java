package proj.hobby.dsa.maps;

import java.util.*;

/**
 *https://leetcode.com/problems/equal-row-and-column-pairs/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Java Collections
 *
 * Complexity:
 *  TIme: O(N^2) - N^2 for building cols & rows and O(1) for checking equality
 *  Space: O(N)  - N Strings
 */
public class EqualRowColPairs {

    public int equalPairs(int[][] grid) {

        int equalCount = 0 ;
        Map<String, Integer> colFreqs = new HashMap<>();

        // build col strings
        for (int c  = 0 ; c < grid[0].length; c++) {
            StringBuilder sb = new StringBuilder();
            for(int r = 0; r < grid.length; r++) {
                sb.append(grid[r][c]).append(",");
            }
            String col = sb.toString();
            colFreqs.put(col, colFreqs.getOrDefault(col, 0)+1);
        }

        //build row strings and check equality
        for(int r = 0 ; r < grid.length; r++) {
            StringBuilder sb = new StringBuilder();
            for(int c = 0 ; c < grid[r].length; c++) {
                sb.append(grid[r][c]).append(",");
            }
            String row = sb.toString();
            if(colFreqs.containsKey(row)) {
                equalCount += colFreqs.get(row);
            }
        }
        return equalCount;
    }

    public static void main(String[] args) {
        EqualRowColPairs er = new EqualRowColPairs();
        System.out.println("EqualRowColPairs: "+er.equalPairs(new int[][]{{3,2,1},{1,7,6},{2,7,7}}));
        System.out.println("EqualRowColPairs: "+er.equalPairs(new int[][]{{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}));
        System.out.println("EqualRowColPairs: "+er.equalPairs(new int[][]{{11,1},{1,11}}));
    }
}
