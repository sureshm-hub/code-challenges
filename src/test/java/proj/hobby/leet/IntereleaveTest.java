package proj.hobby.leet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntereleaveTest {

    private static Intereleave il;

    @BeforeAll
    static void setUp(){
      il = new Intereleave();
    }

    @Test
    void isInterleave() {
        assertFalse(il.isInterleave("", "ab", "cd"));
        assertFalse(il.isInterleave("ab", "", "cd"));
        assertTrue(il.isInterleave("ab", "", "ab"));
        assertTrue(il.isInterleave("", "ab", "ab"));
        assertTrue(il.isInterleave("", "", ""));
        assertTrue(il.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        assertTrue(il.isInterleave("", "", "a"));
    }

    @Test
    void testDebug() {
        assertFalse(il.isInterleave("a", "b", "a"));
        assertFalse(il.isInterleave("a", "b", "b"));
    }
}