package proj.hobby.dsa.prefix;

public class ProductArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;
        // prefix sum
        for(int i = 1; i < n; i++) {
            result[i] = result[i-1]*nums[i-1];
        }

        //suffix sum
        int suffix = 1;
        for(int i = n-1; i >= 0; i--) {
            result[i] = result[i] * suffix;
            suffix *= nums[i];
        }
        return result;
    }

    public int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        long output = 1l;
        boolean oneZero = false;
        boolean manyZero = false;
        for(int j = 0 ; j < nums.length;j ++){
            if(nums[j] != 0) {
                output *=  nums[j];
            } else {
                if(!oneZero) {
                    oneZero = true;
                } else {
                    manyZero = true;
                }
            }
        }
        for(int i=0; i < nums.length; i++) {
            if(manyZero) {
                result[i] = 0;
            } else if( oneZero ) {
                if(nums[i] == 0) {
                    result[i] = (int) (output);
                } else {
                    result[i]  = 0;
                }
            } else {
                result[i] = (int) (output/nums[i]);
            }
        }
        return result;
    }
}
