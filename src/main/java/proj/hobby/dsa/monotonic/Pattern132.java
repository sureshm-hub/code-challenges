package proj.hobby.dsa.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pattern132 {

    public boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>(); // decreasing stack
        int ak = Integer.MIN_VALUE;

        for(int i = nums.length - 1; i >= 0; i --) {
            if(nums[i] < ak) return true;
            while(!stack.isEmpty() && stack.peek() < nums[i])
                ak = stack.pop();
            stack.push(nums[i]);
        }

        return false;
    }
}
