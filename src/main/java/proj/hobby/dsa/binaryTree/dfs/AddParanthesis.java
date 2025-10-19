package proj.hobby.dsa.binaryTree.dfs;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 */
public class AddParanthesis {

    public List<Integer> diffWaysToCompute(String expression) {

        List<String> exp = parse(expression);

        List<Integer> result = dfs(exp, 0, exp.size() - 1, new HashMap<>() );

        return result;

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

        for(int i = l + 1; i <= r - 1; i += 2 ) {

            String op = exp.get(i);

            List<Integer> left = dfs(exp, l, i - 1, memo);
            List<Integer> right = dfs(exp, i + 1, r, memo);

            for(int lVal : left) {
                for(int rVal : right) {
                    result.add(op(lVal, rVal, op));
                }
            }
        }
        memo.put(key, result);
        return result;
    }

    private int op(int lVal, int rVal, String op) {
        int result = switch (op) {
            case "+" -> lVal + rVal;
            case "-" -> lVal - rVal;
            case "*" -> lVal * rVal;
            case "/" -> lVal / rVal;
            default -> lVal + rVal;
        };
        return result;
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
