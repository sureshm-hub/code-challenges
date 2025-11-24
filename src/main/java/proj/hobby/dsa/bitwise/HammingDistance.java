package proj.hobby.dsa.bitwise;

/**
 *
 * https://leetcode.com/problems/hamming-distance/description
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int h = 0;
        while(x > 0 || y > 0) {
            h += (x & 1) ^ (y & 1);
            x = x >> 1;
            y = y >> 1;
        }
        return h;
    }

}
