package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/reverse-string-ii/description
 */
public class ReverseStringII {

    public String reverseStr(String s, int k) {
        int N = s.length();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < N) {

            int end = Math.min(N, i + k);
            StringBuilder temp = new StringBuilder(s.substring(i, end));
            sb.append(temp.reverse());

            int end2 = Math.min( N, i + (2 * k));
            if(end2  <= N) sb.append(s.substring(end,  end2));
            i +=2 * k;
        }
        return sb.toString();
    }
}
