package proj.hobby.dsa.twopointer;

/**
 *
 * https://leetcode.com/problems/permutation-in-string/description
 */
public class PermutationInString {

    // Given s1 and s2, check if any substring of s2 is a permutation (anagram) of s1.
    // Does s2 contain a substring of length |s1| with identical frequency counts?
    // Time: O(n * 26), Space: O(1)
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if(m > n) return false;

        int[] need = new int[26];
        int[] window = new int[26];

        for(int i = 0; i < m; i++) {
            ++need[s1.charAt(i) - 'a'];
            ++window[s2.charAt(i) - 'a'];
        }

        if(matches(need, window)) return true;

        for(int i = m; i < n; i++) {
            window[s2.charAt(i) - 'a']++; // add right
            window[s2.charAt(i-m)-'a']--; // remove left

            if(matches(need, window)) return true;
        }

        return false;
    }

    private boolean matches(int[] need, int[] window) {
        for(int i = 0 ; i < 26; i++) {
            if(need[i] != window[i]) return false;
        }
        return true;
    }
}
