package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/ransom-note/
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] mags = new int[26];
        for(char c : magazine.toCharArray()) {
            int idx = c - 'a';
            ++mags[idx];
        }

        for(char c : ransomNote.toCharArray()) {
            int idx = c - 'a';
            --mags[idx];
            if(mags[idx] < 0) return false;
        }

        return true;
    }
}
