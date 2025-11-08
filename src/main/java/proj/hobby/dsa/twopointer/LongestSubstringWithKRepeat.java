package proj.hobby.dsa.twopointer;

/**
 *
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 */
public class LongestSubstringWithKRepeat {

    public int longestSubstring(String s, int k) {
        int ans = 0;
        for(int n = 1; n<= 26; n++) {
            ans = Math.max(ans, longestSubString(s, k, n));
        }
        return ans;
    }

    private int longestSubString(String s, int k, int n) {
        int res = 0;
        int unq = 0;   // # unique letters
        int kFreq = 0; // # letters with atleast kFreq
        int[] count = new int[26];

        for(int l = 0, r = 0; r < s.length(); r++) {
            int rCount = ++count[s.charAt(r) - 'a'];
            if(rCount == 1) unq++;
            if(rCount == k) kFreq++;

            while(unq > n) {
                int lCount = count[s.charAt(l) - 'a'];
                if(lCount == k) kFreq--;
                lCount = --count[s.charAt(l) - 'a'];
                if(lCount == 0) unq--;
                ++l;
            }

            if(kFreq == n) res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
