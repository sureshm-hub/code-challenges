package proj.hobby.dsa.intervals;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Greedy Algorithm
 *
 * Complexity:
 *  Time: O(NLogN) - for sorting points
 *  Space: O(1)
 *
 */
public class BallonBurst {

    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;

        Arrays.sort(points, Comparator.comparingInt( o -> o[1])); // sort by end point

        int arrows = 1, end = points[0][1];
        for(int i = 1; i < points.length; i++) {
            if(points[i][0] > end) { // no overlap so we have to use new arrow
                arrows++;
                end = points[i][1];
            }
        }
        return arrows;
    }


    public static void main(String[] args) {
        BallonBurst bb = new BallonBurst();
        System.out.println("Min Arrow Count: "+bb.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
        System.out.println("Min Arrow Count: "+bb.findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));
        System.out.println("Min Arrow Count: "+bb.findMinArrowShots(new int[][]{{1,2},{2,3},{3,4},{4,5}}));
    }
}
