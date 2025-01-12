package proj.hobby.dsa.binarySearch;

/**
 * https://leetcode.com/problems/find-peak-element/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Binary Search
 *
 * Complexity:
 *  Time: O(Log N) - N size of input array
 *  Space: O(1)
 *
 */
public class PeakElement {

    public int findPeakElement(int[] nums) {
        int hi = nums.length-1, lo = 0;
        while(lo < hi ) {
            int mid = lo + (hi-lo)/2;
            if(nums[mid] < nums[mid+1]) { // peak in right half
                lo = mid+1;
            } else {
                hi = mid; // peak in left half
            }
        }
        return lo; //hi == lo we found peak
    }

    public static void main(String[] args) {
        PeakElement pe = new PeakElement();
        System.out.println("Index of Peak Element: "+pe.findPeakElement(new int[]{1,2,3,1}));
        System.out.println("Index of Peak Element: "+pe.findPeakElement(new int[]{1,2,1,3,5,6,4}));
        System.out.println("Index of Peak Element: "+pe.findPeakElement(new int[]{1,2,3,4}));
        System.out.println("Index of Peak Element: "+pe.findPeakElement(new int[]{4,3,2,1}));
        System.out.println("Index of Peak Element: "+pe.findPeakElement(new int[]{1}));
        System.out.println("Index of Peak Element: "+pe.findPeakElement(new int[]{Integer.MIN_VALUE}));
        System.out.println("Index of Peak Element: "+pe.findPeakElement(new int[]{Integer.MAX_VALUE}));
    }
}
