package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        String prev  = "0";
        int shift = 0;
        for(int i = 0; i < n; i++) {

            int n2 = num2.charAt(n-i-1) - '0';
            int carry = 0;
            StringBuilder multiply = new StringBuilder();

            for(int j = 0; j < m; j++) { // product  of 1 st digit of num2 with num1
                int n1 = num1.charAt(m-j-1) - '0';

                int prod = n1*n2;
                int digit =carry+(prod%10);
                int extraCarry  = 0;
                if(digit >= 10) {
                    digit = digit%10;
                    extraCarry++;
                }
                multiply.append(digit);
                carry = (prod)/10+extraCarry;
                //System.out.println("[prod, carry, digit]"+prod+", "+digit+", "+carry);
            }
            if(carry > 0) {
                multiply.append(""+carry);
            }
            multiply = multiply.reverse();
            int temp = shift;
            while(temp-- > 0){
                multiply.append(0);
            }
            String curr = multiply.toString();

            // add current and prev
            int p = curr.length();
            int q = prev.length();
            StringBuilder add = new StringBuilder();
            int carrySum = 0;
            for(int k = 0; k < Math.max(p,q); k++) {
                int t1 =0, t2 =0;
                int currIndex = p-k-1;
                if(currIndex >= 0) {
                    t1 = curr.charAt(currIndex) - '0';
                }
                int prevIndex = q-k-1;
                if(prevIndex >= 0) {
                    t2 = prev.charAt(prevIndex) - '0';
                }
                int sum = t1+t2;
                int digit = carrySum+(sum%10);
                int extraCarrySum = 0;
                if(digit >= 10){
                    digit = digit%10;
                    extraCarrySum++;
                }
                carrySum = extraCarrySum + (sum/10);
                //System.out.println("[sum, t1, t2, digit, carrySum]"+sum+", "+t1+", "+t2+", "+digit+", "+carrySum);
                add.append(digit);
            }
            if(carrySum > 0) {
                add.append(carrySum);
            }
            String temp1 = add.reverse().toString();
            //System.out.println(n2+" [curr, prev, sum] "+curr+", "+prev+", "+temp1);

            prev = temp1;
            //System.out.println("[prev] "+prev);
            shift++;
        }
        int indx = 0;
        while(indx < prev.length() && prev.charAt(indx) == '0') indx++;
        return indx == 0 ? prev : prev.substring(indx-1);
    }

}
