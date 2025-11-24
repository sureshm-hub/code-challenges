package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/repeated-substring-pattern
 */
public class RepeatedSubString {

    public boolean repeatedSubstringPattern(String s) {
        String ss = s + s;
        return ss.substring(1, ss.length() - 1).contains(s);
    }
}
