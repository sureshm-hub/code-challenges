package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/construct-the-rectangle/description
 */
public class ConstructRectangle {

    public int[] constructRectangle(int area) {
        int max = (int) Math.sqrt(area);
        int l = max, w = area / l;
        while(l * w != area && l >= 1) {
            l--;
            w = area / l;
        }

        if(l > w) return new int[]{l, w};

        return new int[]{w, l};
    }
}
