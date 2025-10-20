package proj.hobby.dsa.prefix;

public class RangeSumMutable {

    private final int N;
    private final int[] arr;
    private final long[] bit; // 1 indexed

    public RangeSumMutable(int[] nums) {
        N = nums.length;
        bit = new long[N + 1];
        arr = nums.clone();
        for(int i = 0 ; i < N; i++) {
            add(i + 1, arr[i]);// build BIT
        }
    }

    private void add(int idx, int delta) {
        while(idx <= N) {
            bit[idx] += delta;
            idx += idx & -idx;
        }
    }

    private long prefixSum(int idx) {
        long sum = 0;
        while(idx > 0) {
            sum += bit[idx];
            idx -= idx & -idx;
        }
        return sum;
    }

    public void update(int index, int val) {
        int delta = val - arr[index];
        arr[index] = val;
        add(index + 1, delta);
    }

    public int sumRange(int left, int right) {
        long sum = prefixSum(right + 1) - prefixSum(left);
        return (int) sum;
    }
}
