package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/to-lower-case/description
 *
 */
public class ToLowerCase {

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            c = Character.isUpperCase(c) ? Character.toLowerCase(c) : c;
            sb.append(c);
        }
        return sb.toString();
    }
}
