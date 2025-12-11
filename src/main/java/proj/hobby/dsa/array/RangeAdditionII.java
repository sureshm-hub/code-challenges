package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/range-addition-ii/description
 */
public class RangeAdditionII {

    public int maxCount(int m, int n, int[][] ops) {
        int minX = m, minY = n;

        for(int[] op : ops) {
            minX = Math.min(minX, op[0]);
            minY = Math.min(minY, op[1]);
        }

        return minX * minY;
    }
}
