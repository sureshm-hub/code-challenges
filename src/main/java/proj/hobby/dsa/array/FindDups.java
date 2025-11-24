package proj.hobby.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/description
 */
public class FindDups {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
                res.add(nums[i]);
            }
        }
        return res;
    }

}
