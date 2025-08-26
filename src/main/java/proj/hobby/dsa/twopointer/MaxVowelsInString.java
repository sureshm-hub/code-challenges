package proj.hobby.dsa.twopointer;

/**
 *
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach:
 *
 * Complexity:
 *  Time: O(N)
 *  Space: O(1)
 *
 */
public class MaxVowelsInString {

    public int maxVowels(String s, int k) {
        int i = 0, j = 0, max = 0, curr =0;
        for(; i < s.length();i++) {
            if("aeiouAEIOU".indexOf(s.charAt(i)) != -1) curr++;
            if(i >= k-1){
                max = Math.max(curr, max);
                if("aeiouAEIOU".indexOf(s.charAt(j)) != -1) curr--;
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxVowelsInString mvw = new MaxVowelsInString();
        int max = mvw.maxVowels("leetcode",3);
        System.out.println("Max Vowels In String: "+max);

        max = mvw.maxVowels("les",3);
        System.out.println("Max Vowels In String: "+max);

        max = mvw.maxVowels("abciiidef",3);
        System.out.println("Max Vowels In String: "+max);

        max = mvw.maxVowels("aeiou",2);
        System.out.println("Max Vowels In String: "+max);

    }

}
