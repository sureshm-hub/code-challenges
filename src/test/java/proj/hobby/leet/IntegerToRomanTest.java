package proj.hobby.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerToRomanTest {

    IntegerToRoman i2r = new IntegerToRoman();

    @Test
    void intToRoman() {
        String s = i2r.intToRoman(1994);
        assertEquals("MCMXCIV", s);
        assertEquals("LVIII", i2r.intToRoman(58));
        assertEquals("MMMDCCXLIX", i2r.intToRoman(3749));
    }
}