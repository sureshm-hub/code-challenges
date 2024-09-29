package proj.hobby.leet;

/**

 Problem:
    https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

 CLarifying Q's:
    only Alpha numeric?

 PseudoCode:

    int start = 0, end =0
    int max = Math.min(1, string.length)

    while (end < string.length)
        if(end == string.length-1)
            return  max

        end++
        for(int i= start; i< end; i++)
            if (chars[i] == chars[end])
                start = i+1;
                   break;

        currentMax = end-start;
        max = currentMax > max ? currentMax : max:

 Complexity:
    Time: O(N*K)
    K is length of longest Substring

 */

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstring(s.toCharArray());
    }

    private int lengthOfLongestSubstring(char[] c) {

        int start =0, end=0;
        int max = Math.min(1,c.length);

         for(; end < c.length; end++) {
            for(int i=start; i < end; i++) {
                if(c[end] == c[i]) {
                    start = i+1;
                    break;
                }
            }
            max = Math.max(end - start + 1, max);
        }
        return max;
    }


    public static void main(String[] args) {
        LongestSubstring ls = new LongestSubstring();
        int max = ls.lengthOfLongestSubstring("");
        System.out.println("max: "+max);

        max = ls.lengthOfLongestSubstring("aa");
        System.out.println("max: "+max);

        max = ls.lengthOfLongestSubstring("acbb");
        System.out.println("max: "+max);

        max = ls.lengthOfLongestSubstring("acbba");
        System.out.println("max: "+max);

    }
}
