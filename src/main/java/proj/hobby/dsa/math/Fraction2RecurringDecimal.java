package proj.hobby.dsa.math;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/fraction-to-recurring-decimal
 *
 */
public class Fraction2RecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {

        if(numerator == 0) return "0";

        StringBuilder decimal = new StringBuilder();

        long nl = (long) numerator;
        long dl = (long) denominator;

        if(nl  < 0 ^ dl  < 0) {
            decimal.append("-");
            nl = Math.abs(nl);
            dl = Math.abs(dl);
        }

        long intPart = nl / dl ;
        decimal.append(intPart);

        long reminder = nl % dl;

        if(reminder == 0) {
            return decimal.toString();
        }

        decimal.append(".");

        Map<Long, Integer> map = new HashMap<>();

        while(reminder != 0) {

            if(map.containsKey(reminder)) {
                decimal.insert(map.get(reminder), "(");
                decimal.append(")");
                break;
            }
            map.put(reminder, decimal.length());

            reminder *= 10;

            intPart = reminder / dl;
            decimal.append(intPart);

            reminder = reminder % dl;
        }

        return decimal.toString();
    }

}
