package proj.hobby.dsa.array;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/largest-number
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) strs[i] = String.valueOf(nums[i]);

        Arrays.sort(strs, (a, b) -> (b+a).compareTo(a+b));

        if("0".equals(strs[0])) return "0";

        StringBuilder sb = new StringBuilder();
        for(String s : strs) sb.append(s);

        return sb.toString();
    }
}
