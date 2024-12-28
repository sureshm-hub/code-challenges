package proj.hobby.meta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhotographyTest {
    Photography p = new Photography();

    @Test
    void testPhotography1() {
        int count = p.getArtisticPhotographCount(5, "APABA", 1, 2);
        assertEquals(1, count);
    }

    @Test
    void testPhotography2() {
        int count = p.getArtisticPhotographCount(5, "APABA", 2, 3);
        assertEquals(0, count);
    }

    @Test
    void testPhotography3() {
        int count = p.getArtisticPhotographCount(8, ".PBAAP.B",1,3);
        assertEquals(3, count);
    }

    @Test
    void testPhotography4() {
        int count = p.getArtisticPhotographCount(6, "P.A..B",1,3);
        assertEquals(1, count);
    }
}