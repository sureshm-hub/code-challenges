package proj.hobby.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * https://leetcode.com/problems/longest-absolute-file-path/description/
 *
 */
public class LongestFilePath {

    public int lengthLongestPath(String input) {

        record T(int depth, int length){}

        int max = 0;
        Deque<T> stack = new ArrayDeque<>();
        stack.push(new T(-1, 0));

        for(String part : input.split("\n")) {
            int deep = getDepth(part);
            while(deep <= stack.peek().depth()) stack.pop();
            part = part.replaceAll("\t","");
            int totLen = stack.peek().length() + part.length();
            if(part.contains("."))
                max = Math.max(max, totLen );
            else
                stack.push(new T(deep, totLen + 1));
        }
        return max;
    }

    private int getDepth(String part) {
        return  (int) part.chars().filter(c -> c == '\t').count();
    }
}
