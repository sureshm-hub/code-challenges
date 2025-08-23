package proj.hobby.dsa.strings;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        for(; i < strs[0].length(); i ++) {
            char c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[j].substring(0,i);
                }
            }
        }
        return strs[0].substring(0,i);
    }
}
