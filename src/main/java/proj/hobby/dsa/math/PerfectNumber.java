package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/perfect-number/description
 */
public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        for(int i = 1; i <= num/2; i++) {
            if(num % i == 0 ) {
                sum += i;
            }
        }
        return num == sum;
    }
}
