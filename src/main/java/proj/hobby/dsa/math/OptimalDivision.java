package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/optimal-division/description
 */
public class OptimalDivision {

    public String optimalDivision(int[] nums) {

        int n = nums.length;

        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);

        if(n == 1) return sb.toString();
        if(n == 2) return sb.append("/").append(nums[1]).toString();

        sb.append("/(").append(nums[1]);
        for(int i = 2; i < n; i++) {
            sb.append("/").append(nums[i]);
        }
        sb.append(")");
        return sb.toString();
    }
}
