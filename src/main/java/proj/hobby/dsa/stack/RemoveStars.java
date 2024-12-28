package proj.hobby.dsa.stack;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/removing-stars-from-a-string/submissions/1477428187/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Stack
 *
 * Complexity:
 * Time: O(N) - N chars in String
 * Space: O(N) -
 *
 *
 */
public class RemoveStars {

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char c : chars) {
            stack.push(c);
            if(c == '*') {
                stack.pop();
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        RemoveStars rm = new RemoveStars();
        System.out.println("Remove Stars: "+rm.removeStars( "leet**cod*e"));
        System.out.println("Remove Stars: "+rm.removeStars( "erase*****"));
    }
}
