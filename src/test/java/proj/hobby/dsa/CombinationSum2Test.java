package proj.hobby.dsa;

import java.util.*;
import org.junit.jupiter.api.Test;
import proj.hobby.dsa.backtracking.CombinationSum2;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSum2Test {


    @Test
    public void test(){
        CombinationSum2 cs2 = new CombinationSum2();
        List<List<Integer>>  result;

        result = cs2.combinationSum2(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 30);
        System.out.println(result);
        assertEquals(1, result.size());

        result =cs2.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(result);
        assertEquals(4, result.size());

        result =cs2.combinationSum2(new int[]{5}, 5);
        System.out.println(result);
        assertEquals(1, result.size());

        result =cs2.combinationSum2(new int[]{2,5,2,1,2}, 5);
        System.out.println(result);
        assertEquals(2, result.size());
    }



}