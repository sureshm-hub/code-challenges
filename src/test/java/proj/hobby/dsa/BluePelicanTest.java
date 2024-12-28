package proj.hobby.dsa;

import org.junit.jupiter.api.Test;

public class BluePelicanTest {

    @Test
    public void test() {
        final double Area;
        Area = 203.49;

        double d5 = 78.1;
        int fg = (int)d5;
        System.out.println(fg);

        double f4 = 22;

        System.out.println( (double)(90/9) );
        System.out.println(4 + 6.0/4 + 5 * 3 - 3);

        int p3 = 3;
        double d4 = 10.3;
        int j3 = (int)5.9;
        System.out.println(p3 + p3 * d4 - 3 * j3);


        int p = 3;
        double d = 10.3;
        int j2 = (int)5.9;
        System.out.println(p + p * (int)d - 3 * j2);


        int dividend = 12, divisor = 4, quotient = 0, remainder = 0;
        int dividend2 = 13, divisor2 = 3, quotient2 = 0, remainder2 = 0;
        quotient = dividend/divisor;
        remainder = dividend % divisor;
        quotient2 = dividend2 / divisor2;
        remainder2 = dividend2 % divisor2;

        System.out.println(quotient);
        System.out.println(remainder);
        System.out.println(quotient2);
        System.out.println(remainder2);

        int j  = 7;
        j *= 0.5;
        System.out.println(j);
    }
}
