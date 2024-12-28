package proj.hobby.dsa.slidingWindow;

/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: sliding Window
 *
 * Complexity:
 *  Time: O(N)
 *  Space: O(1)
 */
public class MaxConsecutiveOnes {

    public int longestOnes(int[] nums, int k) {
        int max = 0, remaining = k, left = 0, right =0 ;
        while(right < nums.length) {
            if(nums[right] == 0) {
                remaining--;
            }

            while(remaining < 0){ // handle k = 0 & recover flip
                if(nums[left] == 0) {
                    remaining++;
                }
                left++;
            }
            right++;
            max = Math.max(max, right-left);
        }
        return max;
    }

    public int longestOnesV2(int[] nums, int k) {
        int max = 0, right = 0, left = 0, remaining = k;
        while(right < nums.length) {

            // get consecutive 1's for curr window with k flips
            while(right < nums.length && (remaining > 0 ||  nums[right] == 1)) {
                if(nums[right++] == 0) {
                    remaining--;
                }
            }

            max = Math.max(max, right-left); // udpate max

            // slide right end of window till we recover 1 flip
            while( left <= right && left < nums.length) {
                if(nums[left++] == 0){
                    remaining++;
                    break;
                }
            }

        }
        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes mco = new MaxConsecutiveOnes();
        System.out.println("MaxConsecutiveOnes: "+mco.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println("MaxConsecutiveOnes: "+mco.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        System.out.println("MaxConsecutiveOnes: "+mco.longestOnes(new int[]{1,1,1,1,1,1,1}, 3));
        System.out.println("MaxConsecutiveOnes: "+mco.longestOnes(new int[]{0,0,0,0,0,0,0,0}, 3));
        System.out.println("MaxConsecutiveOnes: "+mco.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 0));
        System.out.println(" === ");
        System.out.println("MaxConsecutiveOnes: "+mco.longestOnesV2(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println("MaxConsecutiveOnes: "+mco.longestOnesV2(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        System.out.println("MaxConsecutiveOnes: "+mco.longestOnesV2(new int[]{1,1,1,1,1,1,1}, 3));
        System.out.println("MaxConsecutiveOnes: "+mco.longestOnesV2(new int[]{0,0,0,0,0,0,0,0}, 3));
        System.out.println("MaxConsecutiveOnes: "+mco.longestOnesV2(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 0));
    }
}
