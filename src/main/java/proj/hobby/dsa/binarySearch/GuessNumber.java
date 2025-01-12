package proj.hobby.dsa.binarySearch;

/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Binary Search
 *
 * Complexity:
 *  Time: O(Log N) - N is the input
 *  Space: O(1) - constant for start and end
 *
 */
public class GuessNumber {

    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
     *               otherwise return 0
     * int guess(int num);
     */
    protected int guess(int num){
        return Integer.compare( Integer.MAX_VALUE, num);
    }

    public int guessNumber(int n) {
        int start = 1, end = n, pick = n;
        while(start <= end) {
            pick = start+(end-start)/2; // avoid integer overflow for large n
            int guess = guess(pick);
            if(guess == 1) {
                start = pick + 1;
            } else if( guess == -1) {
                end = pick - 1;
            } else {
                return pick;
            }
        }
        return pick;
    }

    public static void main(String[] args) {
        GuessNumber gn = new GuessNumber();
        System.out.println("Guess Number: "+gn.guessNumber(Integer.MAX_VALUE));
    }

}
