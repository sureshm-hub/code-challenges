package proj.hobby.dsa.prefix;

/**
 *
 * RangeSumMutableTLE: simple impl for RangeSumMutable.
 * Suffers TLE, to avoid use Fenwick Tree solution "RangeSumMutable"
 *
 */
public class RangeSumMutableTLE {

    private int[] prefix;

    public RangeSumMutableTLE(int[] nums) {
        prefix = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public void update(int index, int val) {
        int delta = val - prefix[index + 1] + prefix[index];
        while(index < prefix.length - 1) {
            prefix[index + 1] +=  delta;
            index++;
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}
