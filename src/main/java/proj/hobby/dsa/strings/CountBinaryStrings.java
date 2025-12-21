package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/count-binary-substrings/description
 *
 */
public class CountBinaryStrings {

    public int countBinarySubstrings(String s) {

        int count = 0;
        int prev = 0; // prev substring grouped
        int cur = 1;

        for(int i = 0; i + 1 < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i + 1)) {
                cur++;
            } else {
                count += Math.min(cur, prev);
                prev = cur;
                cur = 1;
            }
        }

        count += Math.min(cur, prev);
        return count;
    }
}
