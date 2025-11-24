package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/magical-string
 *
 */
public class MagicalString {

    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");
        int tail= 2;
        char next = '1';
        while(sb.length() < n ) {
            sb.append(String.valueOf(next).repeat(sb.charAt(tail)-'0'));
            if(next == '1') next = '2';
            else next = '1';

            tail++;
        }
        int count = 0;
        return (int) sb.toString().chars().limit(n).filter(c -> c == '1').count();
        // for(int i =0; i < n; i++) {
        //     if(sb.charAt(i) == '1') count++;
        // }
        // return count;

    }
}
