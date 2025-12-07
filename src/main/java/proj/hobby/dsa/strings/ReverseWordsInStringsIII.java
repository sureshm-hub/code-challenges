package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/reverse-words-in-a-string-iii
 */
public class ReverseWordsInStringsIII {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();
        char[] chars = s.toCharArray();
        for(int i = 0, prev = 0; i < chars.length; i++) {
            char c = chars[i];
            if(!Character.isWhitespace(c)) {
                word.append(c);
            } else {
                if(!word.isEmpty()) {
                    sb.append(word.reverse().toString());
                    word = new StringBuilder();// reset word
                }
                sb.append(c);
            }
        }
        if(!word.isEmpty()) {
            sb.append(word.reverse().toString());
        }
        return sb.toString();
    }
}
