package proj.hobby.dsa.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/longest-uncommon-subsequence-ii/description
 *
 */
public class LongestUncommonSubseqII {

    public int findLUSlength(String[] strs) {
        Set<String> dups = new HashSet<>();
        Set<String> seen = new HashSet<>();
        for(String s : strs) {
            if(seen.contains(s)) {
                dups.add(s);
            } else {
                seen.add(s);
            }
        }

        Arrays.sort(strs, (a, b) -> b.length() - a.length());

        for(int i = 0; i < strs.length; i++) {
            if(dups.contains(strs[i])) continue;

            boolean isSub = false;
            for(int j = 0; j < i; j++) {
                isSub |= isSubSeq(strs[i], strs[j]);
            }
            if(!isSub) return strs[i].length();
        }

        return -1;
    }

    private boolean isSubSeq(String s, String t){
        int i = 0;
        for(char c : t.toCharArray()) {
            if(i < s.length() && c == s.charAt(i)) ++i;
        }
        return i == s.length();
    }
}
