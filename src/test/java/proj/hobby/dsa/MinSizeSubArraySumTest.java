package proj.hobby.dsa;

import org.junit.jupiter.api.Test;
import proj.hobby.dsa.twopointer.MinSizeSubArraySum;

import static org.junit.jupiter.api.Assertions.*;

class MinSizeSubArraySumTest {

    MinSizeSubArraySum minSum = new MinSizeSubArraySum();

    @Test
    void minSubArrayLen() {
        int min = minSum.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
        assertEquals(2, min);

        min = minSum.minSubArrayLen(4, new int[]{1,4,4});
        assertEquals(1, min);

        min = minSum.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1});
        assertEquals(0, min);
    }
}