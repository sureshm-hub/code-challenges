package proj.hobby.dsa;

import org.junit.jupiter.api.Test;
import proj.hobby.dsa.backtracking.GenParans;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenParansTest {

    @Test
    public void testParn() {
        GenParans gen = new GenParans();
        List<String> parans = gen.generateParenthesis(1);
        assertEquals("()", parans.get(0));
        assertEquals(1, parans.size());

        parans = gen.generateParenthesis(2);
        System.out.println(parans);
        assertEquals(2, parans.size());

        parans = gen.generateParenthesis(3);
        System.out.println(parans);
        assertEquals(5, parans.size());

        parans = gen.generateParenthesis(4);
        System.out.println(parans);
        assertEquals(14, parans.size());
    }
}