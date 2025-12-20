package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/valid-palindrome-ii/description
 *
 */
public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        // exhaustive search - TLE
        // if(isPalindrome(s, -1)) return true; // -1 for out of bounds left
        // for(int i = 0; i < s.length(); i++) {
        //     if(isPalindrome(s, i)) return true;
        // }
        // return false;
        for(int l = 0, r = s.length() -1; l < r; l++, r--) {
            if(s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while( l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    // private boolean isPalindrome(String s, int idx) {
    //     int l = 0, r = s.length() - 1;
    //     while (l < r) {
    //         if(l == idx) l++;
    //         if(r == idx) r--;
    //         if(l < r) {
    //             if(s.charAt(l) != s.charAt(r)) return false;
    //             l++;
    //             r--;
    //         }
    //     }
    //     return true;
    // }
}
