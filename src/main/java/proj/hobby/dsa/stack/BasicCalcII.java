package proj.hobby.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class BasicCalcII {

    public int calculate(String s) {
        Deque<Integer> st = new ArrayDeque<>();

        int cur = 0;
        char op = '+'; // leading +

        int n = s.length();

        for(int i =0 ; i < n; i++) {
            char c = s.charAt(i);

            if(Character.isDigit(c)) cur = cur * 10 + (c - '0');

            if(c == '+' || c == '-' || c == '*' || c == '/' || i == n - 1 ) {
                if(op == '+') st.push(cur);
                else if(op == '-') st.push(-cur);
                else if(op == '*') st.push(st.pop() * cur);
                else if(op == '/') st.push(st.pop() / cur);

                op = c;
                cur = 0;
            }
        }

        int sum = 0;
        while (!st.isEmpty()) sum += st.pop();

        return sum;
    }
}
