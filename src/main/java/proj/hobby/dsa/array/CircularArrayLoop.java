package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/circular-array-loop/description
 *
 */
public class CircularArrayLoop {

    public boolean circularArrayLoop(int[] nums) {

        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(nums[i] == 0) continue;

            boolean forward = nums[i] > 0;

            int slow = i, fast = i;

            while(true) {
                slow = nextIndex(nums, forward, slow);
                if(slow == -1) break;

                fast = nextIndex(nums, forward, fast);
                if(fast == -1) break;

                fast = nextIndex(nums, forward, fast);
                if(fast == -1) break;

                if(slow == fast) return true;
            }

            int idx = i;

            while(nums[idx] * (forward ? 1 : -1) > 0) {
                int next = ((idx + nums[idx]) % n + n) % n;
                nums[idx] = 0;
                idx = next;
            }

        }

        return false;

    }

    private int nextIndex(int[] nums, boolean forward, int i) {
        boolean direction = nums[i] > 0;
        if(direction != forward) return -1; // direction changed

        int n = nums.length;

        int next = ((i+nums[i]) % n + n) % n; // safe wrap around

        if(next == i) return -1;// self loop not allowed

        return next;
    }
}
