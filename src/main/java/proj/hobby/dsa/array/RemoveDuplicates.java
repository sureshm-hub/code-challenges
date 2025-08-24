package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 *
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);

        int k = 1;
        for(int i =1; i < temp.length;i++) {
            if(temp[i] != temp[i-1]) {
                k++;
                nums[k-1]=temp[i];
            }
        }
        return k;
    }
}
