package proj.hobby.dsa;

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 */
public class ContainerWaterMax {

    public int maxAmount(int[] heights) {
        int left =0, right = heights.length-1;
        int maxAmount = 0;
        while(left < right) {
            int current = Math.min(heights[left], heights[right])*(right-left);
            maxAmount = Math.max(maxAmount,current);
            if(heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxAmount;
    }
}
