package proj.hobby.dsa.strings;

/**
 * https://leetcode.com/problems/add-binary
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int M = a.length();
        int N = b.length();
        int carry = 0;
        for(int i=M-1,j=N-1; i>=0 || j >=0; i--,j--) {
            int ad =0;
            if(i >= 0) ad = a.charAt(i)-'0';
            int bd = 0;
            if(j >= 0) bd = b.charAt(j)-'0';

            int ones = 0;
            if(ad == 1) ones++;
            if(bd == 1) ones++;
            if(carry == 1) ones++;

            int result = 0;
            if(ones == 3) {
                result = 1;
                carry =1;
            } else if (ones == 2) {
                result =0;
                carry = 1;
            } else if(ones == 1) {
                result =1;
                carry = 0;
            }
            //System.out.println(ad+"--"+bd);
            sb.append(result);
        }
        if(carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();

    }
}
