package proj.hobby.dsa.twopointer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 */
public class StringAnagrams {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        int[] freq = new int[26];
        for(char c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        for(int l = 0, r = 0; r < s.length(); r++) {

            char c = s.charAt(r);
            freq[c - 'a']--;

            while ( r - l + 1 > p.length()) {
                char lc = s.charAt(l);
                freq[lc - 'a']++;
                l++;
            }

            if(r - l + 1 == p.length()) {
                boolean anag = true;
                for(int i = 0; i < 26; i ++) {
                    if(freq[i] != 0) {
                        anag = false;
                        break;
                    }
                }
                if(anag)  res.add(l);
            }

        }
        return res;
    }
}
