package proj.hobby.dsa.stack;

import java.util.LinkedList;

/**
 *
 * https://leetcode.com/problems/evaluate-reverse-polish-notation
 *
 */
public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for(String s: tokens) {
            if("+-*/".indexOf(s) != -1) {
                int val2 = stack.pop();
                int val1 = stack.pop();
                if("+".equals(s)) {
                    stack.push(val1 + val2);
                } else if("-".equals(s)) {
                    stack.push(val1 - val2);
                } else if("*".equals(s)) {
                    stack.push(val1 * val2);
                } else if("/".equals(s)) {
                    stack.push(val1 / val2);
                }
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

}
