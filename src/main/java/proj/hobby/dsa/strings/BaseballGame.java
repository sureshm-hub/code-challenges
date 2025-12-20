package proj.hobby.dsa.strings;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * https://leetcode.com/problems/baseball-game/description
 *
 */
public class BaseballGame {

    public int calPoints(String[] operations) {

        Deque<Integer> scores = new ArrayDeque<>();
        int score = 0;
        for(String s : operations) {
            int sz = scores.size();
            if("+".equals(s)) {
                int num1 = scores.pollLast();
                int num2 = scores.peekLast();
                scores.add(num1);
                scores.add( num1 + num2);
            } else if("D".equals(s)) {
                scores.add(scores.peekLast() * 2);
            } else if("C".equals(s)) {
                scores.pollLast();
            } else { // record new score
                scores.add(Integer.parseInt(s));
            }
        }

        // int sum = 0;
        // while(!scores.isEmpty()) sum += scores.poll();
        // return sum;

        return scores.stream().mapToInt(x -> x).sum();
    }
}
