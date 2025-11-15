package proj.hobby.dsa.twopointer;

/**
 *
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/?envType=problem-list-v2&envId=vorqfplg
 */
public class LongestRepeating {

    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l = 0, r = 0, maxFreq = 0, max = 0;

        while(r < s.length()) {
            int idx = s.charAt(r) - 'A';
            freq[idx]++;

            maxFreq = Math.max(maxFreq, freq[idx]);
            // manage l by shrinking if converted > k; coverted = window_length - maxFreq; windowLength = r - l +1
            while((r - l + 1) - maxFreq > k) {
                --freq[s.charAt(l)-'A'];
                l++;// advance l to shrink window
            }

            max = Math.max(max, (r - l + 1));
            r++;
        }

        return max;
    }

}
