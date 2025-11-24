package proj.hobby.dsa.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/keyboard-row/description
 */
public class KeyboardRow {

    public String[] findWords(String[] words) {

        List<char[]> rows = Arrays.asList("asdfghjkl".toCharArray(), "qwertyuiop".toCharArray(), "zxcvbnm".toCharArray());
        final int[] map = new int[26]; // char groups
        int group = 0;
        for(char[] row : rows) {
            for(char c : row) {
                map[c-'a'] = group;
            }
            group++;
        }

        List<String> res = new ArrayList<>();
        for(String word : words) {
            if(word.isEmpty()) continue;

            final int match = map[Character.toLowerCase(word.charAt(0)) -'a'];
            int count = (int) word.chars().filter(c -> map[Character.toLowerCase(c) - 'a'] == match).count();
            if(count == word.length()) res.add(word);
        }

        return res.toArray(new String[0]);

        // char[] a = "asdfghjkl".toCharArray();
        // char[] q = "qwertyuiop".toCharArray();
        // char[] z = "zxcvbnm".toCharArray();

        // int[] map = new int[26];
        // for(char c : a) {
        //     map[c - 'a']  = 1;
        // }
        // for(char c : q) {
        //     map[c-'a'] = 2;
        // }
        // for(char c : z) {
        //     map[c-'a'] = 3;
        // }

        // List<String> res = new ArrayList<>();
        // for(String word : words) {
        //     if(word.isEmpty()) continue;

        //     char[] c = word.toCharArray();
        //     int match = map[Character.toLowerCase(word.charAt(0)) -'a'];
        //     boolean add = true;
        //     for(int i = 1; i < c.length; i++) {
        //         int next = map[Character.toLowerCase(c[i]) -'a'];
        //         if(match != next) {
        //             add = false;
        //             break;
        //         }
        //     }
        //     if(add) res.add(word);
        // }

        // return res.toArray(new String[0]);
    }
}
