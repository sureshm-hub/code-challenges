package proj.hobby.dsa;

import org.junit.jupiter.api.Test;
import proj.hobby.dsa.greedy.ContainerWaterMax;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWaterMaxTest {

    @Test
    public void testMaxAmount() {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        ContainerWaterMax cw = new ContainerWaterMax();
        int max = cw.maxAmount(heights);
        assertEquals(49, max);

        heights = new int[]{1,1};
        max = cw.maxAmount(heights);
        assertEquals(1,max);
    }

}