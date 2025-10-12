package proj.hobby.dsa.math;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/description/
 */
public class HappyNumber {

    public boolean isHappy(int n) {

        String digits = Integer.toString(n);
        Set<Integer> seen = new HashSet<>();

        while (digits.length() > 0) {
            int sum = 0;
            for(char c : digits.toCharArray()) {
                int i = c - '0';
                sum += (i * i);
            }
            if(sum == 1) return true;
            if(seen.contains(sum)) break;
            seen.add(sum);
            digits = Integer.toString(sum);
        }
        return false;
    }
}
