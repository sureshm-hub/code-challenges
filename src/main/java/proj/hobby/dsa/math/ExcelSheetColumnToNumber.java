package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/excel-sheet-column-number
 */
public class ExcelSheetColumnToNumber {

    public int titleToNumber(String columnTitle) {

        int n = 0;
        int mul = 1;

        for(char c : columnTitle.toCharArray()) {
            int d = c - 'A' + 1;

            n *= 26;
            n += d;
        }

        return n;
    }

}
