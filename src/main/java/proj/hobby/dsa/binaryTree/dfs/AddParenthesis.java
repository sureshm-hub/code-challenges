package proj.hobby.dsa.binaryTree.dfs;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 *
 * pattern: num op num op ... num
 *  - divide‑and‑conquer pattern: “choose a split point, recurse on left and right, combine”
 */
public class AddParenthesis {

    Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        // memoized result
        if(memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> result = new ArrayList<>();

        int L = expression.length() - 1;
        for(int i = 0; i < L; i++) {
            char op = expression.charAt(i);
            if(op == '+' || op == '-' || op == '*' ) {
                List<Integer> left = diffWaysToCompute(expression.substring( 0 , i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                for(int l : left) {
                    for(int r : right) {
                        result.add(eval(String.valueOf(op), l, r));
                    }
                }



            }
        }
        memo.put(expression, result);// memoize for later use

        // Base Case
        if(result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        return result;
    }

    public List<Integer> diffWaysToCompute2(String expression) {
        List<String> exp = parse(expression);
        return dfs(exp, 0, exp.size() - 1, new HashMap<>());
    }

    private List<Integer> dfs(List<String> exp, int l, int r, Map<String, List<Integer>> memo) {

        if(l == r) {
            return Arrays.asList(Integer.parseInt(exp.get(l)));
        }

        String key = l+","+r;
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        List<Integer> result = new ArrayList<>();

        for(int i = l+1; i <= r-1; i += 2) {
            String op = exp.get(i);

            for(int lVal : dfs(exp, l, i - 1, memo)) {
                for(int rVal : dfs(exp, i + 1, r, memo)) {
                    result.add(eval(op, lVal, rVal));
                }
            }
        }
        memo.put(key, result);
        return result;
    }

    private int eval(String op, int lVal, int rVal) {
        return switch(op) {
            case "+" -> lVal + rVal;
            case "-" -> lVal - rVal;
            case "*" -> lVal * rVal;
            case "/" -> lVal / rVal;
            default -> lVal + rVal;
        };
    }

    private List<String> parse(String expression) {
        List<String> exp = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for(char c : expression.toCharArray()) {
            if(Character.isDigit(c)) {
                sb.append(c);
            } else {
                exp.add(sb.toString());
                exp.add(String.valueOf(c));
                sb.setLength(0);
            }
        }
        exp.add(sb.toString());
        return exp;
    }

}
