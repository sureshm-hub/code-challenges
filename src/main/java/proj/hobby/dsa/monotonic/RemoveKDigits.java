package proj.hobby.dsa.monotonic;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/remove-k-digits/description/
 *
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {

        if(num.length() == k) return "0";

        Deque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < num.length(); i++) {
            while(k > 0 && !stack.isEmpty() && stack.getLast() > num.charAt(i)) {
                stack.pollLast();
                --k;
            }
            stack.addLast(num.charAt(i));
        }

        while(k-- > 0) stack.pollLast();

        StringBuilder sb = new StringBuilder();
        for(char c : stack) {
            if(c == '0' && sb.isEmpty()) continue; // skip leading zero's
            sb.append(c);
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }
}
