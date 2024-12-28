package proj.hobby.dsa.strings;

import java.util.*;

/**
 *
 *
 *
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        ans[nums.length-1] = 1;

        for(int i = 1 ; i < nums.length;i++) {
            ans[i] = ans[i-1]*nums[i-1]; // first pass prefix
        }

        int[] suffix = new int[nums.length];
        suffix[nums.length-1] = 1;
        for(int i = nums.length - 2; i>= 0; i--) {
            suffix[i] = suffix[i+1]*nums[i+1]; // suffix
            ans[i] *= suffix[i]; // combined
        }
        return ans;
    }

    public static void main(String[] args) {

        ProductExceptSelf pes = new ProductExceptSelf();
        int[] res = pes.productExceptSelf(new int[] {1,2,3,4});
        System.out.println("Product Except Self: "+Arrays.toString(res));

        res = pes.productExceptSelf(new int[] {-1,1,0,-3,3});
        System.out.println("Product Except Self: "+Arrays.toString(res));

        res = pes.productExceptSelf(new int[] {1});
        System.out.println("Product Except Self: "+Arrays.toString(res));
    }


}
