package proj.hobby.dsa.strings;

/**
 *
 * Problem: https://leetcode.com/problems/increasing-triplet-subsequence/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Multipass
 *
 * Complexity:
 *  Time:  O(N)
 *  Space: O(1)
 *
 */
public class IncreasingTripletSequence {

    public boolean increasingTriplet(int[] nums) {

        boolean[] minLeft = new boolean[nums.length];
        int min = nums[0];
        for(int i =0 ; i < nums.length; i++) { // first pass find min left
            if(nums[i] > min) {
                minLeft[i] = true;
            } else {
                min = nums[i];
            }
        }
        int max = nums[nums.length -1];
        for(int i = nums.length-1; i >=0 ; i--) { //second pass find max right
            if(nums[i] < max) {
                if(minLeft[i]) {
                    return true; // return early
                }
            } else {
                max = nums[i];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSequence itp = new IncreasingTripletSequence();
        boolean found = itp.increasingTriplet(new int[] {1,2,3,4,5});
        System.out.println("Increasing Triplet Sequence Found: "+found);

        found = itp.increasingTriplet(new int[] {5,4,3,2,1});
        System.out.println("Increasing Triplet Sequence Found: "+found);

        found = itp.increasingTriplet(new int[] {2,1,5,0,4,6});
        System.out.println("Increasing Triplet Sequence Found: "+found);
    }

}
