package proj.hobby.dsa.monotonic;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/daily-temperatures/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Use Stack to find the montonically increasing sequence and find answer
 *
 * Complexity:
 *  Time: O(N)
 *  Space: O(N)
 *
 */
public class DailyTemperature {

    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) {
            return temperatures;
        }

        int[] answer = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>(); // Deque to keep track of indexes
        for(int i = 0 ; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i]  > temperatures[stack.peek()])  {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i); // push the index
        }

        return answer; // unfilled indexes already have zero
    }

    public static void main(String[] args) {
        DailyTemperature dt = new DailyTemperature();
        System.out.println("Monotonic Sequece: "+Arrays.toString(dt.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
        System.out.println("Monotonic Sequece: "+Arrays.toString(dt.dailyTemperatures(new int[]{30,40,50,60})));
        System.out.println("Monotonic Sequece: "+Arrays.toString(dt.dailyTemperatures(new int[]{30,60,90})));
        System.out.println("Monotonic Sequece: "+Arrays.toString(dt.dailyTemperatures(new int[]{30})));
    }

}
