package proj.hobby.dsa.twopointer;

public class AlternatingSubArray {

    public int longestAlternatingSubarray(int[] nums, int threshold) {

        int max = 0;
        for(int l = 0; l < nums.length; l++) {
            while(l < nums.length && !(nums[l]%2 == 0 && nums[l] <= threshold) ) {
                l++;
            }
            int r = l;
            while(r+1 < nums.length && nums[r]%2 != nums[r+1]%2 && nums[r+1] <= threshold ) {
                r++;
            }
            if(l < nums.length) {
                max = Math.max(max, r-l+1);
            }
            l = r;
        }
        return max;

    }

    public static void main(String[] args) {
        AlternatingSubArray q1 = new AlternatingSubArray();
        q1.longestAlternatingSubarray( new int[]{11,37,16,29}, 18);
        q1.longestAlternatingSubarray( new int[]{4,10,3}, 10);

    }
}
