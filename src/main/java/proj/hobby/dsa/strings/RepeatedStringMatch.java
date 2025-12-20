package proj.hobby.dsa.strings;

import java.util.Collections;

/**
 *
 * https://leetcode.com/problems/repeated-string-match
 *
 */
public class RepeatedStringMatch {

    public int repeatedStringMatch(String a, String b) {
        int n = b.length() / a.length();
        if(b.length() % a.length() != 0) n++; // ceil n

        String s = String.join("", Collections.nCopies(n, a));

        if(s.contains(b)) return n;

        if((s + a).contains(b)) return n + 1;

        return -1;
    }
}
