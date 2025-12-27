package proj.hobby.dsa.backtracking;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 */
public class GenParans {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(n, n, 0, new StringBuilder(), result);
        return result;
    }

    private void generateParenthesis(int left, int right, int index, StringBuilder curr, List<String> result) {
        if(left == 0 && right == 0) {
            result.add(curr.toString());
            return;
        }

        if(right > left) {
            curr.append(")");
            generateParenthesis(left, right -1, index+1, curr, result);
            curr.deleteCharAt(index);
        }
        if(left > 0) {
            curr.append("(");
            generateParenthesis(left-1, right, index+1, curr, result);
            curr.deleteCharAt(index);
        }
    }

    public List<String> paranthesis(int n) {

        List<String> result = new ArrayList<>();
        collect("", 0, 0, n, result);
        return result;

    }

    private void collect(String cur, int left, int right, int n, List<String> result) {

        if(left == n && right == n) {
            result.add(cur);
        }

        if(left < n) {
            collect(cur+"(",left + 1, right, n, result);
        }
        if(right < left) {
            collect(cur+")", left, right + 1, n, result);
        }
    }

    public static void main(String[] args) {
        GenParans gp = new GenParans();
        List<String> paranthesis = gp.paranthesis(3);
        System.out.println(paranthesis);

         paranthesis  = gp.generateParenthesis(3);
        System.out.println(paranthesis);


        System.out.println("====");

        paranthesis = gp.paranthesis(6);
        System.out.println(paranthesis);
        System.out.println(paranthesis.size());
        System.out.println("---");
        paranthesis  = gp.generateParenthesis(6);
        System.out.println(paranthesis.size());
        System.out.println(paranthesis);


    }

}
