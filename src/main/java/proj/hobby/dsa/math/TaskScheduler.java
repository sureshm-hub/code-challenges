package proj.hobby.dsa.math;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/task-scheduler/description
 *
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char c : tasks) {
            ++freq[c-'A'];
        }


        final int maxFreq = Arrays.stream(freq).max().getAsInt();
        // slot1: slots occupied by "maxFreq" task
        int slot1 = (maxFreq - 1)  * (n + 1);

        // tasks with same freq as "maxFreq" task - these spill over into the last block after "maxFreq" task
        int count = (int) Arrays.stream(freq).filter(x  -> x == maxFreq).count();

        return Math.max(slot1 + count, tasks.length);
    }
}
