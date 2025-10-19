package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/add-digits/description/
 */
public class AddDigits {

    public int addDigits(int num) {
        String str = Integer.toString(num);

        while(str.length() != 1) {
            int result = 0;
            for(char c : str.toCharArray()) {
                result += c - '0';
            }
            str = Integer.toString(result);
        }

        return Integer.parseInt(str);
    }
}
