package proj.hobby.dsa.twopointer;

import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/move-zeroes/?envType=study-plan-v2&envId=leetcode-75
public class MoveZeros  {

    public void moveZeroes(int[] nums) {
        int index = 0, currZero = -1, currNonZero = -1;
        while(index < nums.length) {
            if(nums[index] == 0 && currZero == -1) currZero = index;
            if(nums[index] != 0 && currZero != -1 && currNonZero == -1) currNonZero = index;
            index++;
            if(currZero != -1 && currNonZero != -1 && currZero < currNonZero) {
                //swap zero and non-zero
                nums[currZero] = nums[currNonZero];
                nums[currNonZero] = 0;
                index = currZero+1;
                currZero = -1;
                currNonZero = -1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,0,1,0,0,3,0,12,0,0};
        MoveZeros mz = new MoveZeros();
        mz.moveZeroes(nums);
        List<Integer> boxedNums = Arrays.stream(nums).boxed().toList();
        System.out.println("nums: "+boxedNums);

        nums = new int[] {1,0,1};
        mz.moveZeroes(nums);
        boxedNums = Arrays.stream(nums).boxed().toList();
        System.out.println("nums: "+boxedNums);
    }
}
