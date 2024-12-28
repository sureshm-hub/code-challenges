package proj.hobby.meta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxAdditionalDinersTest {

    MaxAdditionalDiners diners = new MaxAdditionalDiners();

    @Test
    void getMaxAdditionalDinersCountBase0() {
        long maxAdditionalDinersCount = diners.getMaxAdditionalDinersCount(1, 1, 0, new long[]{});
        assertEquals(1L, maxAdditionalDinersCount);
    }

    @Test
    void getMaxAdditionalDinersCountBase1() {
        long maxAdditionalDinersCount = diners.getMaxAdditionalDinersCount(2, 1, 0, new long[]{});
        assertEquals(1L, maxAdditionalDinersCount);
    }

    @Test
    void getMaxAdditionalDinersCountBase2() {
        long maxAdditionalDinersCount = diners.getMaxAdditionalDinersCount(3, 1, 0, new long[]{});
        assertEquals(2L, maxAdditionalDinersCount);
    }

    @Test
    void getMaxAdditionalDinersCountBase3() {
        long maxAdditionalDinersCount = diners.getMaxAdditionalDinersCount(1, 5, 0, new long[]{});
        assertEquals(1L, maxAdditionalDinersCount);
    }

    @Test
    void getMaxAdditionalDinersCountBase4() {
        long maxAdditionalDinersCount = diners.getMaxAdditionalDinersCount(0, 5, 0, new long[]{});
        assertEquals(0L, maxAdditionalDinersCount);
    }

    @Test
    void getMaxAdditionalDinersCountTC1() {
        long maxAdditionalDinersCount = diners.getMaxAdditionalDinersCount(10, 1, 2, new long[]{2, 6});
        assertEquals(3L, maxAdditionalDinersCount);
    }

    @Test
    void getMaxAdditionalDinersCountTC2() {
        long maxAdditionalDinersCount = diners.getMaxAdditionalDinersCount(15, 2, 3, new long[]{11, 6, 14});
        assertEquals(1L, maxAdditionalDinersCount);
    }

    @Test
    void getMaxAdditionalDinersCountTC2_1() {
        long maxAdditionalDinersCount = diners.getMaxAdditionalDinersCount(6, 2, 2, new long[]{1, 6});
        assertEquals(0L, maxAdditionalDinersCount);
    }
}