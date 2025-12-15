package proj.hobby.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/exclusive-time-of-functions
 *
 */
public class ExclusiveTimeOfFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] times = new int[n];
        int prev = -1;
        for(String s : logs) {
            String[] parts = s.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];  // start or end
            int ts = Integer.parseInt(parts[2]);
            if("start".equals(type)) {
                if(!stack.isEmpty()) {
                    times[stack.peek()] += ts - prev ;
                }
                stack.push(id);
                prev = ts;
            } else {
                times[stack.pop()] += ts - prev + 1;
                prev = ts + 1;
            }
        }
        return times;
    }
}
