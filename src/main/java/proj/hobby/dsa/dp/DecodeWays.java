package proj.hobby.dsa.dp;

/**
 *
 * https://leetcode.com/problems/decode-ways/description/
 */
public class DecodeWays {

    public int numDecodings(String s) {

        int[] mem = new int[s.length()+1];
        mem[s.length()] = 1;

        for(int i = s.length()-1; i >= 0; i--) {

            char c = s.charAt(i);
            int countOne = '1' <= c && c <= '9'  ? 1 : 0;
            if(countOne == 1) {
                mem[i] = mem[i+1];
            }

            if(i + 1 < s.length()) {
                char b = s.charAt(i+1);
                int countTwo = 0;
                if(c == '1') {
                    countTwo = '0' <= b && b <= '9'  ? 1 : 0;
                } else if (c == '2') {
                    countTwo = '0' <= b && b <= '6'  ? 1 : 0 ;
                }
                if(countTwo == 1) {
                    mem[i] += mem[i+2];
                }
            }
        }
        return mem[0];
    }
}
