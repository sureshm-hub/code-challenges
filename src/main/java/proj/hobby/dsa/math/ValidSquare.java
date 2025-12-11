package proj.hobby.dsa.math;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/valid-square/description
 *
 */
public class ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        // doesn't take care of rotations
        // int[][] square = new int[][]{p1, p2, p3, p4};
        // Comparator<int[]> comp = Comparator.comparingInt((int[] p) -> p[0])
        //                             .thenComparingInt((int[] p) -> p[1]);

        // Arrays.sort(square, comp);

        // for(int i = 0 ; i < square.length; i++) {
        //     System.out.println(Arrays.toString(square[i]));
        // }

        // // check 90-degree
        // if((square[0][1] != square[2][1]) || (square[1][1] != square[3][1])) return false;

        // if((square[0][0] != square[1][0]) || (square[2][0] != square[3][0])) return false;

        // // check side length
        // int side = square[1][1] - square[0][1];

        // if(((square[3][0] - square[1][0]) != side) ||
        //         ((square[3][1] - square[2][1]) != side) ||
        //         ((square[2][0] - square[0][0]) != side))
        //         return false;


        // return true;

        Set<Integer> distSet = new HashSet<>();
        int[][] points = new int[][]{p1, p2, p3, p4};

        for(int i = 0; i < 4; i++)
            for(int j = i + 1; j < 4; j++) {
                distSet.add(dist(points[i], points[j]));
            }

        return !distSet.contains(0) && distSet.size() == 2;
    }

    private int dist(int[] p1, int[] p2){
        int x = p2[0] - p1[0];
        int y = p2[1] - p1[1];
        return (x * x) + (y * y);
    }
}
