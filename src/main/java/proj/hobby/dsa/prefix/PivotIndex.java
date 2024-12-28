package proj.hobby.dsa.prefix;

/**
 * https://leetcode.com/problems/find-pivot-index/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: prefix sum
 *
 * Complexity:
 * Time: O(N)
 * Space: O(1)
 *
 */
public class PivotIndex {

    public int pivotIndex(int[] nums) {
        int[] suffixSum = new int[nums.length+1]; // calculate suffix sum
        suffixSum[nums.length] = 0 ;
        for(int j = nums.length-1; j >= 0; j--) {
            suffixSum[j] = suffixSum[j+1]+nums[j];
        }
        int prefixSum = 0;
        for(int i =0 ;i <nums.length; i++) {
            if(prefixSum == suffixSum[i+1]){
                return i;
            }
            prefixSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        PivotIndex pi = new PivotIndex();
        System.out.println("Pivot Index: "+pi.pivotIndex(new int[] {1,7,3,6,5,6}));
        System.out.println("Pivot Index:"+pi.pivotIndex(new int[] {-2,1,-1}));
        System.out.println("Pivot Index:"+pi.pivotIndex(new int[] {-1,1,2}));
        System.out.println("Pivot Index:"+pi.pivotIndex(new int[] {-1,10,72}));
    }

}
