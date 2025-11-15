package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/add-strings/description/
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder sb1 = new StringBuilder(num1);
        num1 = sb1.reverse().toString();

        StringBuilder sb2 = new StringBuilder(num2);
        num2 = sb2.reverse().toString();

        StringBuilder res = new StringBuilder();

        int c = 0;
        int i = 0;
        while(i < Math.max(num1.length(), num2.length())) {
            int a = i >= num1.length() ? 0 : num1.charAt(i) - '0';
            int b = i >= num2.length() ? 0 : num2.charAt(i) - '0';
            int sum = a+b+c;
            int s = sum % 10;
            c = sum / 10;
            res.append(s);
            i++;
        }

        if(c > 0) res.append(c);

        return res.reverse().toString();
    }
}
