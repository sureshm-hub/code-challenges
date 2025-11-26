package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/longest-uncommon-subsequence-i/description
 */
public class LongestUncommonSubseqI {

    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
