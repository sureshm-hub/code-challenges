package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/solve-the-equation/description
 *
 */
public class SolveTheEquation {

    public String solveEquation(String equation) {
        String[] parts = equation.split("=");
        int[] lhs = parse(parts[0]);
        int[] rhs = parse(parts[1]);

        int xCoeff = lhs[0] - rhs[0];
        int constant = lhs[1] - rhs[1];

        if(xCoeff == 0) {
            if(constant == 0) return "Infinite solutions";
            return "No solution";
        }

        int x = -constant / xCoeff;
        return "x="+Integer.toString(x);
    }

    private int[] parse(String part) {
        int xCoeff = 0;
        int constant = 0;

        int sign = 1;
        int num = 0;
        boolean hasNum = false;

        for(char c : part.toCharArray()) {
            if(c == '+' || c == '-') { // capture current const
                if(hasNum) {
                    constant += sign * num;
                    num = 0;
                    hasNum = false;
                }
                sign = (c == '+') ? 1 : -1;
            } else if(Character.isDigit(c)) {
                int digit = c - '0';
                num = num * 10 + digit;
                hasNum = true;
            } else if(c == 'x') {
                int coeff = hasNum ? num : 1;
                xCoeff += sign * coeff;

                num = 0;
                hasNum = false;
            }

        }

        if(hasNum) constant += sign * num;
        return new int[] {xCoeff, constant};
    }
}
