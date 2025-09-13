package proj.hobby.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 */
public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = Arrays.asList(1);
        int i = 0;
        while( ++i <= rowIndex) {
            List<Integer> curr = new ArrayList<>(prev.size() + 1);
            curr.add(prev.get(0));
            for(int j = 1; j < prev.size(); j++) {
                curr.add(prev.get(j)+prev.get(j-1));
            }
            curr.add(prev.get(0));
            prev = curr;
        }
        return prev;
    }

}
