package proj.hobby.dsa.binarySearch;

import java.util.*;

/**
 * https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Sort followed by binary search
 *
 * Complexity:
 *  Time: O(NLogN + K log N) - NlogN for sorting K for finding success ; N potions and K Spells
 *  Space: O(N) - N potions for sorting
 *
 */
public class SuccessfulPairs {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);// sort potions for binary search

        int[] pairs = new int[spells.length];// Result pairs

        for(int i = 0 ; i < spells.length ; i++) {
            int curr = spells[i];
            int hi = potions.length-1, lo = 0;

            //Binary Search for first valid potion
            while(lo <= hi) {
                int mid = lo + (hi-lo)/2;
                long value = (long) curr * potions[mid];
                if(value < success) {
                    lo = mid+1; // narrow down lower half
                } else  {
                    hi = mid-1; // narrow down upper half
                }
            }
            pairs[i] =  potions.length - lo;
        }
        return pairs;
    }

    /**
     * This implementation uses Arrays.binarySearch
     *
     * @param spells
     * @param potions
     * @param success
     * @return
     */
    public int[] successfulPairsV1(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);// sort potions for binary search

        int[] pairs = new int[spells.length];// Result pairs

        for(int i = 0 ; i < spells.length ; i++) {
            int curr = spells[i];
            int minPotion = (int)Math.ceil((double)success/curr); //minimum potion required for success
            int lo = Arrays.binarySearch(potions, minPotion);
            if(lo <  0) {
                lo = -(lo+1); //adjust index for -ve values "insertion point"
            }
            pairs[i] =  potions.length - lo;
        }
        return pairs;
    }

    public static void main(String[] args) {
        SuccessfulPairs sp = new SuccessfulPairs();
        System.out.println("Successful Pairs: "+Arrays.toString(sp.successfulPairs(new int[]{5,1,3}, new int[]{1,2,3,4,5}, 7)));
        System.out.println("Successful Pairs: "+Arrays.toString(sp.successfulPairs(new int[]{5,1,3}, new int[]{1,2,3,4,5}, 10)));
        System.out.println("Successful Pairs: "+Arrays.toString(sp.successfulPairs(new int[]{3,1,2}, new int[]{8,5,8}, 16)));
        System.out.println("Successful Pairs: "+Arrays.toString(sp.successfulPairs(new int[]{1,2}, new int[]{8,5,8}, 19)));
        System.out.println("====");
        System.out.println("Successful Pairs: "+Arrays.toString(sp.successfulPairsV1(new int[]{5,1,3}, new int[]{1,2,3,4,5}, 7)));
        System.out.println("Successful Pairs: "+Arrays.toString(sp.successfulPairsV1(new int[]{5,1,3}, new int[]{1,2,3,4,5}, 10)));
        System.out.println("Successful Pairs: "+Arrays.toString(sp.successfulPairsV1(new int[]{3,1,2}, new int[]{8,5,8}, 16)));
        System.out.println("Successful Pairs: "+Arrays.toString(sp.successfulPairsV1(new int[]{1,2}, new int[]{8,5,8}, 19)));
   }
}
