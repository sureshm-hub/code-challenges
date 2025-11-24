package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/next-greater-element-i/description
 */
public class NextGreaterI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++) {
            int ng = -1;
            int idx = -1;
            for(int j = 0; j < nums2.length; j++) {
                if(nums2[j] == nums1[i]) {
                    idx = j;
                }

                if(idx >= 0 && nums2[j] > nums1[i]) {
                    ng  = nums2[j];
                    break;
                }
            }
            res[i] = ng;
        }

        return res;
    }
}
