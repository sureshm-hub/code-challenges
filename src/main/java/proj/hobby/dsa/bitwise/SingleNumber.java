package proj.hobby.dsa.bitwise;

/**
 *
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result =0;
        for(int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber num = new SingleNumber();
        System.out.println( "SingleNumber: " +  num.singleNumber(new int[] {1,2,2,4,5,6,5,6,4,1,43,34,43}));
    }

}