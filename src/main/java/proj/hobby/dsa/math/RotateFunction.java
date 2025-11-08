package proj.hobby.dsa.math;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/rotate-function/
 */
public class RotateFunction {

    public int maxRotateFunction(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        final int sum = Arrays.stream(nums).sum();

        int f = 0;
        int N = nums.length;

        for(int i = 0; i < N; i++) f += i * nums[i]; //F(0)

        int max = f;
        for(int i = N - 1; i >=0; i--) {
            f += sum - N * nums[i];
            max = Math.max( max, f);
        }

        return max;

        // if(nums == null || nums.length == 0) return 0;

        // int N = nums.length;
        // int fMax = Integer.MIN_VALUE;
        // for(int i = 0; i < N; i++) {
        //     int count = 0;
        //     int Fk = 0;
        //     int mul = 0;
        //     for(int k = i; count < N; k++) {
        //         k = k >=N ? 0 : k;// reset k
        //         //System.out.println(" >> "+k);
        //         Fk += mul * nums[k];
        //         count++;
        //         mul++;
        //     }
        //     fMax = Math.max(fMax, Fk);
        // }
        // return fMax;
    }
}
