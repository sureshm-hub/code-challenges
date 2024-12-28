package proj.hobby.dsa;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LetterCombinationTest {

    @Test
    public void testCombos() {
        LetterCombination lc = new LetterCombination();
        List<String> combos = lc.letterCombinationsBFS("79");
        assertEquals(16, combos.size());
        assertTrue(combos.contains("sz"));
        assertEquals("rz",combos.get(combos.size()-2));
        assertFalse(combos.contains("sm"));

        combos = lc.letterCombinations("");
        assertEquals(0, combos.size());
    }

    @Test
    public void testCombosDfs() {
        LetterCombination lc = new LetterCombination();
        List<String> combos = lc.letterCombinations("79");
        assertEquals(16, combos.size());
        assertTrue(combos.contains("sz"));
        assertEquals("sy",combos.get(combos.size()-2));
        assertFalse(combos.contains("sm"));

        combos = lc.letterCombinations("");
        assertEquals(0, combos.size());
    }
}