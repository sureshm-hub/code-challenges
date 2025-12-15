package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/palindromic-substrings/description/
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();

        for(int cntr = 0; cntr < n; cntr++) {
            count += extendPalindrome(s, cntr, cntr); // odd palindromes
            count += extendPalindrome(s, cntr, cntr+1); //even palindromes
        }
        return count;
    }

    private int extendPalindrome(String s, int l , int r) {

        int count = 0;

        while( l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r) ) {
            l--;
            r++;
            count++;
        }

        return count;
    }
}
