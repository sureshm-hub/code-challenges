package proj.hobby.dsa;

import java.util.*;

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
}
