package proj.hobby.dsa.maps;

import java.util.*;s

/**
 * https://leetcode.com/problems/roman-to-integer/description/
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        int sum = 0;
        Map<Character, Integer> romans = new HashMap<>();
        char[] symbols = new char[]{'I','V','X','L','C','D','M'};
        int[] values = new int[]{1,5,10,50,100,500,1000};

        for(int i = 0; i< symbols.length; i++) {
            romans.put(symbols[i], values[i]);
        }

        for(int i =0; i< s.length(); i++) {
            char symbol = s.charAt(i);
            int value  = romans.get(symbol), nextVal =0;
            if(i  < s.length() -1){
                char next = s.charAt(i+1);
                if(
                        (symbol == 'I' && (next == 'V' || next == 'X')) ||
                        (symbol == 'X' && (next == 'L' || next == 'C')) ||
                        (symbol == 'C' && (next == 'D' || next == 'M'))
                ) {
                    nextVal = romans.get(next);
                    i++;
                }
            }
            if(nextVal != 0) {
                sum += nextVal - value;
            } else {
                sum += value;
            }
        }
        return sum;
    }

}
