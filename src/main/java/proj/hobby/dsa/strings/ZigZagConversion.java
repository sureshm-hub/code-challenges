package proj.hobby.dsa.strings;

/**
 *
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length() <= numRows) return s;
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0 ; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int y = 0, dir = 1;
        for(char c : s.toCharArray()) {
            if(y == numRows - 1) {
                dir = -1;
            } else if(y == 0) {
                dir = 1;
            }
            rows[y].append(c);
            y += dir;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}
