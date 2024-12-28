package proj.hobby.dsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideTwoIntegersTest {

    @Test
    public void testDivide() {
        DivideTwoIntegers div = new DivideTwoIntegers();
        int quotient = div.divide(110, 7);
        assertEquals(15, quotient);

        quotient = div.divide(10, 3);
        assertEquals(3, quotient);

        quotient = div.divide(7, -3);
        assertEquals(-2, quotient);
    }
}