package proj.hobby.dsa.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/bulls-and-cows/description/
 */
public class BullsAndCows {

    public String getHint(String secret, String guess) {

        int a = 0, b = 0;
        StringBuilder sb = new StringBuilder();
        Map<Character, int[]> charMap = new HashMap<>();
        for(int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if( s == g ) {
                a++;
            } else {
                charMap.computeIfAbsent(s, x -> new int[2])[0]++;
                //val[0]++;

                charMap.computeIfAbsent(g, x -> new int[2])[1]++;
                //val[1]++;
            }
        }
        sb.append(a).append("A");

        for(char c : charMap.keySet()) {
            int[] val = charMap.get(c);
            b += Math.min(val[0], val[1]);
        }
        sb.append(b).append("B");

        String hint = sb.toString();
        return hint;
    }
}
