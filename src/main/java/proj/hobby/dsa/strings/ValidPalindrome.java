package proj.hobby.dsa.strings;

/**
 * https://leetcode.com/problems/valid-palindrome/description/
 */
public class ValidPalindrome {


    public boolean isPalindrome(String s) {

        int l = 0, r = s.length() - 1;
        while(l < r) {
            /**
             *
             * this approach increments in condition - which makes it harder to read
             */
            // char lc = s.charAt(l);
            // while(!(Character.isLetter(lc) || Character.isDigit(lc)) && ++l < s.length()) {
            //     lc = s.charAt(l);// incr & check
            // }

            // char rc = s.charAt(r);
            // while(!(Character.isLetter(rc) || Character.isDigit(rc)) && 0 <= --r) {
            //     rc = s.charAt(r);// decr &  check
            // }

            // lc = Character.toLowerCase(lc);
            // rc = Character.toLowerCase(rc);

            // if(l < r && lc != rc) return false;

            // l++;
            // r--;

            while(l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }

            while(l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))
                return false;

            ++l;
            --r;
        }

        return true;
    }

    /**
     *
     * Not stable as invariant is verified after reading char
     *
     * @param s
     * @return
     */
    public boolean isPalindromeUnstable(String s) {
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

    private boolean isPal(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(">> "+vp.isPal("a", 0, 0));
        System.out.println(">> "+vp.isPal("aa", 0, 1));
        System.out.println(">> "+vp.isPal("ab", 0, 1));
        System.out.println(">> "+vp.isPal("aab", 0, 2));
        System.out.println(">> "+vp.isPal("aaa", 0, 2));

        System.out.println(">> "+vp.isPalindromeUnstable(".,,,!!!"));
    }
}
