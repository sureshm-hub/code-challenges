package proj.hobby.dsa.strings;

/**
 * https://leetcode.com/problems/valid-palindrome/description/
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length()-1; i < j; i++, j-- ) {
            char left = Character.toLowerCase(s.charAt(i));
            char right = Character.toLowerCase(s.charAt(j));
            while( !(Character.isDigit(left) ||  Character.isLetter(left)) && i < j ) {
                left = Character.toLowerCase(s.charAt(++i));
            }
            while ( !(Character.isDigit(right) ||  Character.isLetter(right)) && j > i) {
                right = Character.toLowerCase(s.charAt(--j));
            }

            if( left != right) {
                return false;
            }
        }
        return true;
    }
}
