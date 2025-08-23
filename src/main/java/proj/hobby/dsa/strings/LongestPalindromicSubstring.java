package proj.hobby.dsa.strings;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int n = s.length();
        String result = s.substring(0,1);
        for(int i=0; i < n;i++) {
            for(int j=i+1; j < n; j++) {
                int start = i, end=j;
                while(start < end && s.charAt(start) == s.charAt(end)){
                    start++;
                    end--;
                }
                if(start >= end && j-i+1 > result.length()){
                    result = s.substring(i, j+1);
                }
            }
        }
        return result;
    }

}
