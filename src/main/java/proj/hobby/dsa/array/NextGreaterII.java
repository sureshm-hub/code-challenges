package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/next-greater-element-ii/description
 *
 */
public class NextGreaterII {

    public int[] nextGreaterElements(int[] nums) {

        int N = nums.length;
        int[] res = new int[N];

        for(int i = 0; i < N; i++) {
            int j = i + 1;
            boolean found = false;
            while(j != i ) {

                if(j >= N) j = 0;

                if( j != i) {
                    if(nums[j] > nums[i]) {
                        res[i] = nums[j];
                        found = true;
                        break;
                    }
                    j++;
                }
            }

            if(!found) res[i] = -1;
        }

        return res;
    }
}
