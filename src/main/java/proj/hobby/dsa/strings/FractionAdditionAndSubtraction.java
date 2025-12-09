package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/fraction-addition-and-subtraction
 */
public class FractionAdditionAndSubtraction {

    public String fractionAddition(String expression) {

        int L = expression.length();

        int N = 0; // running Nr
        int D = 1; // running Dr

        int i = 0;
        while( i < L) {

            int sign  = 1;
            char c = expression.charAt(i);

            // 1. parse sign
            if(c == '+' || c == '-') {
                sign = (c == '-') ? -1 : 1;
                i++;
            }

            // 2. parse Nr.
            int n = 0;
            while(i  < L && Character.isDigit(expression.charAt(i))) {
                n = n * 10 + (expression.charAt(i) - '0');
                i++;
            }

            n *= sign;

            // 3. skip /
            i++;

            // 4. parse Dr.
            int d = 0;
            while( i < L  && Character.isDigit(expression.charAt(i))) {
                d = d * 10 + (expression.charAt(i) - '0');
                i++;
            }


            // N/D + n/d = (N * d + n * D)/(d * D)
            N = N * d + n * D;
            D *= d;

            int g = gcd(N, D);

            N /= g;
            D /= g;
        }

        return N + "/" + D;
    }

    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        if(b == 0) return a;

        return gcd(b, a % b);
    }
}
