package proj.hobby.dsa.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * https://leetcode.com/problems/rectangle-area/
 */
public class RectangleArea {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        int[][] xpoints = new int[][]{{ax1, 1}, {ax2, 1}, {bx1, 2}, {bx2, 2}};
        int[][] ypoints = new int[][]{{ay1, 1}, {ay2, 1}, {by1, 2}, {by2, 2}};

        Comparator<int[]> c = Comparator.comparingInt(p -> p[0]);
        Arrays.sort(xpoints, c);
        Arrays.sort(ypoints, c);

        int A = calcArea(ax1, ax2, ay1, ay2);
        int B = calcArea(bx1, bx2, by1, by2);
        int O = 0;
        if(xpoints[0][1] != xpoints[1][1] && ypoints[0][1] != ypoints[1][1]) {
            O = calcArea(xpoints[1][0], xpoints[2][0], ypoints[1][0], ypoints[2][0]);
        }

        return A + B - O;
    }

    private int calcArea(int x1, int x2, int y1, int y2) {
        int x = Math.abs(x1 - x2);
        int y = Math.abs(y1 - y2);

        return x * y;
    }
}
