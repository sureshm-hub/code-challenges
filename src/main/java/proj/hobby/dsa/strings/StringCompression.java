package proj.hobby.dsa.strings;

import java.util.*;

/**
 * https://leetcode.com/problems/string-compression/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Single Pass
 *
 * Complexity:
 * Time: O(N)
 * Space: O(1)
 *
 */
public class StringCompression {

    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        char curr = chars[0];
        int count = 1;
        for(int i=1; i < chars.length; i++) {
            char temp = chars[i];
            if(curr == temp) {
                count++;
            } else {
                sb.append(curr);
                if(count > 1){
                    sb.append(count);
                }
                curr = temp;
                count = 1;
            }
        }
        sb.append(curr);// boundary
        if(count > 1) {
            sb.append(count);
        }
        String compressed = sb.toString();
        int i=0;
        for(; i < compressed.length(); i++) {
            chars[i] = compressed.charAt(i);
        }
        return compressed.length();
    }

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();

        char[] compress = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int compressLength = sc.compress(compress);
        System.out.println("String Compression Length: "+compressLength+" - "+Arrays.toString(compress));

        compress = new char[]{'a'};
        compressLength = sc.compress(compress);
        System.out.println("String Compression Length: "+compressLength+" - "+Arrays.toString(compress));

        compress = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        compressLength = sc.compress(compress);
        System.out.println("String Compression Length: "+compressLength+" - "+Arrays.toString(compress));
    }
}
