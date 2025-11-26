package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/detect-capital/description
 */
public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        int N = word.length();

        if(N <= 1) return true;

        if(Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            for(int i = 2; i < N; i++) {
                if(!Character.isUpperCase(word.charAt(i))) return false;
            }
            return true; // case: USA
        }

        for(int i = 1; i < N; i++) {
            if(!Character.isLowerCase(word.charAt(i))) return false;
        }
        return true; // case: leetcode & Google
    }
}
