package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/excel-sheet-column-title/description
 *
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {

        StringBuilder title = new StringBuilder();
        int n = columnNumber;

        while( n > 0) {
            int rem = n % 26;
            if(rem == 0) {
                title.append('Z');
                n = n/26 - 1;
            } else {
                title.append((char) ('A'+ rem - 1));
                n /= 26;
            }
        }
        return title.reverse().toString();
    }

}
