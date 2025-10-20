package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/additive-number/description/
 */
public class AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        for(int i = 1; i <= num.length() - 2; i++) {
            if (num.charAt(0) == '0' && i != 1) continue;
            String prev1 = num.substring(0, i);
            for(int j = i + 1; j <= num.length() - 1; j++) {
                if (num.charAt(i) == '0' && j > i + 1) continue;
                //System.out.println(num.charAt(i + 1)+" === "+num.charAt(j - 1));
                String prev2 =  num.substring(i, j);
                if(isAdditive(num, j, prev1, prev2)) return true;
            }
        }
        return false;
    }

    private boolean isAdditive(String num, int right, String prev1, String prev2) {
        if(right >= num.length()) return true;

        String s = stringSum(prev1, prev2);

        //System.out.println(right+" -- "+prev1 + " + "+ prev2+" = " +s);

        if(right + s.length() > num.length()) return false;
        //System.out.println("--");

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != num.charAt(right+i)) return false;
        }

        return isAdditive(num, right + s.length(), prev2, s);
    }

    private String stringSum(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = s1.length() - 1, j = s2.length() - 1;
        while( i >= 0 || j >= 0) {
            int n1 =  i < 0 ? 0 : (s1.charAt(i) - '0');
            int n2 =  j < 0 ? 0 : (s2.charAt(j) - '0');
            int sum = n1 +  n2 + carry;
            //System.out.println(n1+"+"+n2+"+"+carry+" = "+ sum);
            sb.append(sum%10);
            carry  = sum/10;
            i--;
            j--;
            //System.out.println(sb+".."+carry);

        }
        if(carry != 0) sb.append(carry);
        String val = sb.reverse().toString();
        //System.out.println(">>"+s1+" + "+ s2+" = "+ val);
        return val;
        //return Integer.toString(Integer.parseInt(s1)+Integer.parseInt(s2));
    }
}
