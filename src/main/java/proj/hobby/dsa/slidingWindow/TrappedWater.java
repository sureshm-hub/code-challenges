package proj.hobby.dsa.slidingWindow;

/**
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 *  clarifying questions:
 * 	height is an int
 * 	sum total of all the trapped water
 *
 * test cases:
 * 	input: [] or null  			result: 0
 * 	input: [0,1,0,2,1,3,0,1]	result: 0+0+1+0+1+0+1+0 = 3
 *
 * Solution:
 * 	trapped[i] = Math.min(leftMax[i], rightMax[i]) - height[i]
 * 			# leftMax[i], rightMax[i] calculated including height[i]
 * 			# will always be zero or more
 *
 * 	limitations:
 * 		two arrays leftMax[i] & rightMax[i]
 *
 * 	Complexity:
 * 		Single Pass
 * 		TIme: O(N) - N is length of input
 * 		Space: O(N) - N is length of input
 *
 * Example:
 * 	input: 		[0,1,0,2,1,3,0,1]
 * 	leftMax: 	[0,1,1,2,2,3,3,3]
 * 	rightMax:   [3,3,3,3,3,3,1,1]
 * 	trappedWater:0+0+1+0+1+0+1+0 = 3
 *
 */
public class TrappedWater {

    public int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0; //early exit
        }

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];
        for(int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[height.length-1] = height[height.length-1];
        for(int i = height.length-2; i >=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int trappedWater = 0;

        // calculate trapped water
        for(int i=0;  i < height.length; i++) {
            trappedWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        TrappedWater trw = new TrappedWater();
        System.out.println("Trapped Rain Water: "+trw.trap(new int[]{0,1,0,2,1,3,0,1}));
        System.out.println("Trapped Rain Water: "+trw.trap(new int[]{4,2,0,3,2,5}));
    }
}
