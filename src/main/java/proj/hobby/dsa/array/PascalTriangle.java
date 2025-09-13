package proj.hobby.dsa.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/description/
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<Integer> prev = Arrays.asList(1);
        List<List<Integer>> res = new ArrayList<>();
        res.add(prev);
        int i = 1;
        while( ++i <= numRows) {
            List<Integer> curr = new ArrayList<>(prev.size() + 1);
            curr.add(prev.get(0));
            for(int j = 1; j < prev.size(); j++) {
                curr.add(prev.get(j)+prev.get(j-1));
            }
            curr.add(prev.get(0));
            res.add(curr);
            prev = curr;
        }
        return res;
    }

}
