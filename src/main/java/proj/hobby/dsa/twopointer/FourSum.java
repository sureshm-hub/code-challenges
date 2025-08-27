package proj.hobby.dsa.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/4sum/
 *
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        long MAX = 1000_000_000;
        long MIN = -1000_000_000;
        List<List<Integer>> result = new ArrayList<>();
        for(int i =0; i< nums.length-3; i++){
            if( i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j <nums.length-2; j++) {
                if( j > i+1 && nums[j] == nums[j-1]) continue;
                for(int k = j+1; k < nums.length-1; k++) {
                    if(k > j+1 && nums[k] == nums[k-1]) continue;
                    for(int l = nums.length-1; l > k; l--) {
                        if(l < nums.length-1 &&  nums[l] == nums[l+1]) continue;
                        //long curr = nums[i]+nums[j]+nums[k]+nums[l];  --> causes overflow error
                        long curr = nums[i];  curr += nums[j]; curr += nums[k]; curr += +nums[l];
                        if(curr <= MAX && curr >= MIN) {
                            int val = (int) curr;
                            if(target == val) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                            }
                            if(val < target) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

}
