package proj.hobby.dsa.twopointer;

/**
 *
 * https://leetcode.com/problems/maximum-average-subarray-i/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach:  sliding window fixed
 *
 * Complexity:
 *  Time: O(N)
 *  Space: O(I)
 */
public class MaxAverage {

    public double findMaxAverage(int[] nums, int k) {
        int i = 0,  j = 0;
        double sum = 0.0d, max  = Integer.MIN_VALUE;
        for( ; i < nums.length; i++) {
            sum += nums[i];
            if( i >= k-1) {
                max = Math.max(max, sum);
                sum -= nums[j];
                j++;
            }
        }
        return max/k;
    }

    public static void main(String[] args) {
        MaxAverage ma = new MaxAverage();
        double max = ma.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4);
        System.out.println("Max Average: "+max);

        max = ma.findMaxAverage(new int[]{-5}, 1);
        System.out.println("Max Average: "+max);

        max = ma.findMaxAverage(new int[]{5, 7}, 1);
        System.out.println("Max Average: "+max);

        max = ma.findMaxAverage(new int[]{8860,-853,6534,4477,-4589,8646,-6155,-5577,-1656,-5779,-2619,-8604,-1358,-8009,4983,7063,3104,-1560,4080,2763,5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,-4072,-4391,-9579,1407,6700,2421,-6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,-1777,2237,-3253,-506,-4931,-7366,-8132,5406,-6300,-275,-1908,67,3569,1433,-7262,-437,8303,4498,-379,3054,-6285,4203,6908,4433,3077,2288,9733,-8067,3007,9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,-4444,3586,-5711,-9506,-79,-4418,-4348,-5891}, 93);
        System.out.println("Max Average: "+max);
    }

}
