package proj.hobby.dsa.collections;

import java.util.Random;

/**
 *
 * https://leetcode.com/problems/shuffle-an-array/
 */
public class ShuffleArray {

    private final int[] nums;
    private final Random rand;

    public ShuffleArray(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    public int[] reset() {
        return this.nums;
    }

    public int[] shuffle() {
        int N = nums.length;
        int[] shfl = new int[N];
        System.arraycopy(nums, 0, shfl, 0, N);
        for(int i = N - 1; i > 0; i--) {
            int temp = shfl[i];
            int indx = rand.nextInt(i + 1);
            shfl[i] = shfl[indx];
            shfl[indx] = temp;
        }
        return shfl;
    }
}
