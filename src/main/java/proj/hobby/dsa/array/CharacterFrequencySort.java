package proj.hobby.dsa.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * https://leetcode.com/problems/sort-characters-by-frequency/description
 */
public class CharacterFrequencySort {

    public String frequencySort(String s) {

        int[][] counts = new int[62][2];
        for(char c : s.toCharArray()) {
            int index = 0;
            if(Character.isDigit(c)) {
                index = c-'0';
            } else if(Character.isLowerCase(c)) {
                index = (c - 'a') + 10;
            } else if(Character.isUpperCase(c)) {
                index = (c-'A') + 36;
            }
            counts[index][0]++;
            counts[index][1] = (int) c;
        }

        Arrays.sort(counts, Comparator.comparingInt(k -> k[0]));
        StringBuilder sb = new StringBuilder();
        for(int[] cf : counts) {
            while(cf[0] != 0) {
                sb.append((char)cf[1]);
                cf[0]--;
            }
        }
        return sb.reverse().toString();
    }
}
