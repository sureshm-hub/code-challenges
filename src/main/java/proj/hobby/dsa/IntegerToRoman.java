package proj.hobby.dsa;

import java.util.HashMap;
import java.util.Map;

/**
 Problem:
    https://leetcode.com/problems/integer-to-roman/?envType=study-plan-v2&envId=top-interview-150

 Symbol	Value
 I	1
 V	5
 X	10
 L	50
 C	100
 D	500
 M	1000

 Complexity: O(N)

 */

public class IntegerToRoman {

    private static Map<String, String> intToRoman = new HashMap<>();

    static {
        intToRoman.put("3000", "MMM");
        intToRoman.put("2000", "MM");
        intToRoman.put("1000", "M");
        intToRoman.put("900", "CM");
        intToRoman.put("800", "DCCC");
        intToRoman.put("700", "DCC");
        intToRoman.put("600", "DC");
        intToRoman.put("500", "D");
        intToRoman.put("400", "CD");
        intToRoman.put("300", "CCC");
        intToRoman.put("200", "CC");
        intToRoman.put("100", "C");
        intToRoman.put("90", "XC");
        intToRoman.put("80", "LXXX");
        intToRoman.put("70", "LXX");
        intToRoman.put("60", "LX");
        intToRoman.put("50", "L");
        intToRoman.put("40", "XL");
        intToRoman.put("30", "XXX");
        intToRoman.put("20", "XX");
        intToRoman.put("10", "X");
        intToRoman.put("9", "IX");
        intToRoman.put("8", "VIII");
        intToRoman.put("7", "VII");
        intToRoman.put("6", "VI");
        intToRoman.put("5", "V");
        intToRoman.put("4", "IV");
        intToRoman.put("3", "III");
        intToRoman.put("2", "II");
        intToRoman.put("1", "I");
    }

    public String intToRoman(int num) {
        int[] vals = {1000,100,10,1};
        StringBuilder roman = new StringBuilder();
        for(int val: vals) {
            int multiplier = num/val;
            if(multiplier > 0) {
                roman.append(intToRoman.get(Integer.toString(multiplier * val)));
            }
            num = num % val;
        }
        return  roman.toString();
    }
}
