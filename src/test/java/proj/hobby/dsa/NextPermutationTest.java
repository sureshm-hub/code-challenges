package proj.hobby.dsa;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class NextPermutationTest {

    @Test
    public  void testNextPermutation() {
        NextPermutation np = new NextPermutation();
        int[] nums = {3,2,1,};
        np.nextPermutation(nums);
        System.out.println(" >> "+ Arrays.stream(nums).boxed().toList());
        assertArrayEquals(new int[]{1,2,3}, nums);

        nums = new int[] {1,3,2};
        np.nextPermutation(nums);
        System.out.println(" >> "+ Arrays.stream(nums).boxed().toList());
        assertArrayEquals(new int[]{2,1,3}, nums);

        nums = new int[] {1,5,1};
        np.nextPermutation(nums);
        System.out.println(" >> "+ Arrays.stream(nums).boxed().toList());
        assertArrayEquals(new int[]{5,1,1}, nums);
    }
}