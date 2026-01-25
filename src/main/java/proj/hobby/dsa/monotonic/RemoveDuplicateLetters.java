package proj.hobby.dsa.monotonic;

/**
 *
 * https://leetcode.com/problems/remove-duplicate-letters/description/
 *
 * "Monotonic Stack" Solution
 *
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()) freq[c - 'a']++;

        boolean[] used = new boolean[26];//char used in stack
        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()) {
            int idx = c - 'a';
            freq[idx]--;

            if(used[idx]) continue;

            while(!sb.isEmpty()) {
                char top = sb.charAt(sb.length() - 1);
                int topIdx = top - 'a';
                if(top > c && freq[topIdx] > 0) {
                    used[topIdx] = false;
                    sb.deleteCharAt(sb.length() - 1);
                } else break;
            }
            sb.append(c);
            used[idx] = true;
        }
        return sb.toString();
    }

}
