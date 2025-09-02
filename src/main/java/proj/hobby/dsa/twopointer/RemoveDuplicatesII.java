package proj.hobby.dsa.twopointer;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 */
public class RemoveDuplicatesII {

    public int removeDuplicates(int[] nums) {
        int i =0;// slow pointer
        for(int n : nums) {
            if(i < 2 || n > nums[i-2]){
                nums[i] = n;
                i++;
            }
        }
        return i;
    }
}
