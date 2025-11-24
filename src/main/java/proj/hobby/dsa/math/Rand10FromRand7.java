package proj.hobby.dsa.math;

/**
 *
 * https://leetcode.com/problems/implement-rand10-using-rand7/description
 */
public abstract class Rand10FromRand7 {

    public int rand10() {
        while(true) {
            int x = (rand7()  - 1) * 7 + rand7();
            if(x <= 40) {
                return  1 + (x - 1) % 10;
            }
        }
    }

    /**
     *
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     *
     * @return a random integer in the range 1 to 7
     */
    public abstract int rand7();

}
