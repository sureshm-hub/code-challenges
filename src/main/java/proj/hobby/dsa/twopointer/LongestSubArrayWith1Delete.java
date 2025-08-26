package proj.hobby.dsa.twopointer;

/**
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Sliding Window
 *
 * Complexity:
 *  Time: O(N)
 *  Space: O(1)
 */
public class LongestSubArrayWith1Delete {

    public int longestSubarray(int[] nums) {
        int left = 0, right = 0, max = 0 , delete = 1;
        while(right < nums.length) {
            if(nums[right] == 0) {
                delete--;
            }
            while(delete < 0 ) {
                if(nums[left] == 0) {
                    delete++;
                }
                left++;
            }
            max = Math.max(max, right - left);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubArrayWith1Delete las = new LongestSubArrayWith1Delete();
        System.out.println("Longest SubArray With 1 Delete: "+las.longestSubarray(new int[]{1,1,0,1}));
        System.out.println("Longest SubArray With 1 Delete: "+las.longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
        System.out.println("Longest SubArray With 1 Delete: "+las.longestSubarray(new int[]{1,1,1}));
        System.out.println("Longest SubArray With 1 Delete: "+las.longestSubarray(new int[]{0,0,0}));
    }

}
