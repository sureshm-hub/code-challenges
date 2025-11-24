package proj.hobby.dsa.bitwise;

/**
 *
 * https://leetcode.com/problems/total-hamming-distance/description
 */
public class TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int hd = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int xor = nums[i] ^ nums[j];
                hd += Integer.bitCount(xor);
            }
        }
        return hd;
    }
}
