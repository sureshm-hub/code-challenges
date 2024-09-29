package proj.hobby.leet;

/**

Problem:
    https://leetcode.com/problems/search-in-rotated-sorted-array/description/

Clarifying Questions:
    Can the numbers repeat?

Pseudo Code:

     middleIndex = (start+end)/2

     //base conditions
     // 1: found the number
     if(num[middleIndex] == target)
     return middleIndex;

     // 2: end of nums
     if (start == end)
     return -1;

     int leftEnd <- middleIndex - 1 // handle boundary
     int rightStart <- middleIndex + 1 // handle boundary

     leftSorted <- nums[start] < nums[leftEnd]

     searchLeft <= leftSorted && target in left || NOT target in right

     searchLeft ? search target in left : search target in right

Complexity:
    O(LogN)

**/
public class RotatedSort {

    public int search(int[] nums, int target) {
        return  searchRotated(nums, target, 0, nums.length-1);
    }

    public int searchRotated(int[] nums, int target, int start, int end) {

        int middleIndex = (start+end)/2;

        // System.out.println(">> middleIndex: "+middleIndex+ ", start: "+start+ ", end: "+end);
        if(target == nums[middleIndex])
            return middleIndex;
        if(start == end) {
            // Note: We have reached the end of the search and didn't find what we are looking for
            return -1;
        }

        // Note: adjust left and rightStart for boundary conditions
        int leftEnd = Math.max(start,middleIndex -1);
        int rightStart = Math.min(middleIndex+1, end);

        // Note: leftSorted and rightSorted needs adjusted for single element arrays
        boolean leftSorted = nums[start] <= nums[leftEnd];
        boolean rightSorted = nums[rightStart] <= nums[end];

        // Note: should we search left or right tree?
        boolean leftSearch = leftSorted && (target >= nums[start] && target <= nums[leftEnd])
                || rightSorted && !(target >= nums[rightStart] && target <= nums[end]);

        if(leftSearch) {
            return searchRotated(nums, target, start, leftEnd);
        } else {
            return searchRotated(nums, target, rightStart, end);
        }

    }

    public static void main(String[] args) {
        RotatedSort rs = new RotatedSort();
        int index = rs.search(new int[]{4,5,6,7,0,1,2}, 0);
        System.out.println("index: "+index);

        System.out.println("=====");

        index = rs.search(new int[]{0,1,2}, 0);
        System.out.println("index: "+index);

        System.out.println("=====");

        index = rs.search(new int[]{1,2,0}, 0);
        System.out.println("index: "+index);

        System.out.println("=====");

        index = rs.search(new int[]{2,0,1}, 0);
        System.out.println("index: "+index);

        System.out.println("=====");

        index = rs.search(new int[]{0}, 0);
        System.out.println("index: "+index);

        System.out.println("=====");

        index = rs.search(new int[]{0}, -1);
        System.out.println("index: "+index);

        System.out.println("=====");

        index = rs.search(new int[]{3,4,5,6,1,2}, 2);
        System.out.println("index: "+index);
    }

}
