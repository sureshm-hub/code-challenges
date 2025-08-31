package proj.hobby.dsa.strings;

/**
 * https://leetcode.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int length = 0;
        boolean word = false;
        for(char c: s.toCharArray()){
            if(c == ' ') {
                word = false;
                continue;
            } else if (!word) {
                word = true;
                length=0;
            }
            length++;
        }
        return length;
    }

}
