package proj.hobby.dsa.twopointer;

/**
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 *
 */
public class FirstOccurrence {

    public int strStr(String haystack, String needle) {

        for(int i = 0; i < haystack.length(); i++) {
            int j =0;
            int curr = i;
            while(j < needle.length() && curr < haystack.length()) {
                if(haystack.charAt(curr) == needle.charAt(j)) {
                    curr++;
                    j++;
                } else {
                    break;
                }
            }
            if(j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

}
