package proj.hobby.dsa.backtracking;

/**
 *
 * https://leetcode.com/problems/next-greater-element-iii/
 */
public class NextGreaterElementIII {

    public int nextGreaterElement(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int len = digits.length;

        // 1. find first i where digits[i] < digits[i+1]
        int i = len - 2;
        while(i >= 0 && digits[i] >= digits[i+1]) i--;

        if(i < 0) return -1; // all permutations are grater than n

        // 2. find index j from right where digits[j] > digits[i]
        int j = len - 1;
        while(j >= 0 && digits[j] <= digits[i]) j--;

        // 3. swap for the min greater than n
        swap(digits, i, j);

        // 4. reverse all suffix starting at i+1
        reverse(digits, i + 1, len - 1);

        // 5. conert num and check for validity
        long val = 0;
        for(int k = 0; k < len; k++) {
            val = val * 10 + (digits[k] - '0');
            if(val > Integer.MAX_VALUE) {
                return  -1;
            }
        }
        return (int) val;
    }

    private void swap(char[] digits, int i, int j) {
        char temp = digits[j];
        digits[j] = digits[i];
        digits[i] = temp;
    }

    private void reverse(char[] digits, int i, int j) {
        while( i < j) {
            swap(digits, i, j);
            i++;
            j--;
        }
    }

    // this  causes TLE
    // int min = -1;
    // public int nextGreaterElement(int n) {
    //     min = n;
    //     String s = Integer.toString(n);
    //     boolean[] used = new boolean[s.length()];

    //     backtrack(s.toCharArray(), n, used, new StringBuilder());
    //     return min == n ? -1 : min;
    // }

    // private void backtrack(char[] chars, int n,   boolean[] used, StringBuilder sb) {
    //     if(sb.length() == chars.length) {
    //         long val = Long.parseLong(sb.toString());
    //         if(val > n && val <= Integer.MAX_VALUE) {
    //             if (min == n || val < min) {
    //                 min = (int) val;
    //             }
    //         }
    //         return;
    //     }

    //     for(int i = 0; i < chars.length; i++) {
    //         if(!used[i]) {
    //             char c = chars[i];
    //             sb.append(c);
    //             used[i] = true;
    //             backtrack(chars, n,  used, sb);
    //             used[i] = false;
    //             sb.deleteCharAt(sb.length()-1);
    //         }
    //     }
    // }
}
