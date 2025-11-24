package proj.hobby.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description
 *
 */
public class FindMissingNums {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        int count = 1;
        int i = 0;

        while(i < n) {
            if(nums[i] == count) {
                count++;
                i++;
            } else if(nums[i] < count) {
                i++;
            } else {
                while(nums[i] > count) {
                    res.add(count);
                    count++;
                }
            }
        }

        while(count <= n) {
            res.add(count);
            count++;
        }

        return res;
    }
}
