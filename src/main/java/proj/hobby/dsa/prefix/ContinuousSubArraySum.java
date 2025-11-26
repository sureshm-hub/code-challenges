package proj.hobby.dsa.prefix;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/continuous-subarray-sum
 */
public class ContinuousSubArraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        int N = nums.length;

        // TLE
        // int maxSum  = Arrays.stream(nums).sum();
        // if(maxSum == 0 && N > 1) return true;
        // if(k > maxSum) return false;

        // for(int i = 0; i < N-1; i++) {
        //     int sum = nums[i];
        //     for(int j = i + 1; j < N; j++) {
        //         sum += nums[j];
        //         if(sum % k == 0) return true;
        //     }
        // }
        // return false;

        int prefix = 0;
        Map<Integer, Integer> prefixToIndex = new HashMap<>();
        prefixToIndex.put(0, -1);// sum 0 at index -1

        for(int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            if(k != 0) prefix %= k;

            if(prefixToIndex.containsKey(prefix)) {
                if(i - prefixToIndex.get(prefix) > 1) return true; // window size is atleast 2 for good
            } else {
                prefixToIndex.put(prefix, i);// save prefix
            }
        }

        return false;

    }
}
