package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int RED_COLOR = 0, WHITE_COLOR = 1, BLUE_COLOR = 2;
        int red = 0, white = 0, blue = 0;

        for(int num : nums){
            if (num  == RED_COLOR) red++;
            else if (num == WHITE_COLOR) white++;
            else blue++;
        }
        int i=0;
        while(i < red) {
            nums[i++] = RED_COLOR;
        }
        while(i-red<white) {
            nums[i++] = WHITE_COLOR;
        }
        while(i-red-white<blue) {
            nums[i++] = BLUE_COLOR;
        }

    }
}
