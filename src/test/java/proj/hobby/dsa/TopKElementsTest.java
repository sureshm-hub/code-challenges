package proj.hobby.dsa;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TopKElementsTest {

    @Test
    public void testTopK(){
        TopKElements elem = new TopKElements();
        int[] result = elem.frequentK(new int[]{1,2,1,2,1,2,3,3,3,3,3,4,4,5,6},3);
        List<Integer> resultList = Arrays.stream(result).boxed().toList();
        assertEquals(3, resultList.size());
        assertTrue(resultList.contains(1));
        assertTrue(resultList.contains(2));
        assertTrue(resultList.contains(3));
    }

}