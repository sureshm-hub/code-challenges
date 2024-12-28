package proj.hobby.dsa;

import java.util.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSumTest {

    @Test
    public void testComboSum(){
        CombinationSum cs = new CombinationSum();
        List<List<Integer>> result = cs.combinationSum(new int[]{2,3,5}, 8);
        assertEquals(3, result.size());
    }
}