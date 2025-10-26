package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/remove-duplicate-letters/description/
 *
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] last = new int[26];
        for(int i = 0; i < n; i++) last[s.charAt(i) -'a'] = i;

        boolean[] used = new boolean[26];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';

            if(used[idx]) continue;

            while(sb.length() > 0) {
                char top = sb.charAt(sb.length() - 1);
                if(top > c && last[top - 'a'] > i) {
                    used[top - 'a'] = false;
                    sb.deleteCharAt(sb.length() - 1);
                } else break;
            }
            sb.append(c);
            used[idx] = true;
        }
        return sb.toString();
    }

}
