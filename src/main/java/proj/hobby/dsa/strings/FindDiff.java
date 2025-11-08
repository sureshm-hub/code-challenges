package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/find-the-difference/description/
 */
public class FindDiff {

    public char findTheDifference(String s, String t) {
        int[] chars = new int[26];
        int i = 0;
        while(i < s.length()) {
            --chars[s.charAt(i) - 'a'];
            ++chars[t.charAt(i) - 'a'];
            i++;
        }
        ++chars[t.charAt(i) - 'a'];
        for(int j = 0; j < 26; j++) {
            if(chars[j] == 1) return (char) ('a' + j);
        }
        throw new IllegalArgumentException(t+" has no extra letters compared to "+s);
    }
}
