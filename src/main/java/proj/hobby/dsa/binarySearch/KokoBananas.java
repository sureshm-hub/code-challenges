package proj.hobby.dsa.binarySearch;

/**
 * https://leetcode.com/problems/koko-eating-bananas/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Binary Search
 *
 * Complexity:
 *  Time: O(NlogK) - N piles and K: Largest Pile
 *  Space: O(1) - for binary search of k
 *
 */
public class KokoBananas {

    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = 0;// lo, hi to track the values of k
        long loHrs = 0; //long to avoid integer overflow
        for(int p : piles) {
            loHrs += p;
            hi = Math.max(hi, p);
        }
        if(h >= loHrs) {
            return lo; // there are more hours than eating 1 every hour
        }

        while (lo < hi) {
            int mid = (hi+lo)/2;
            int hrs = 0;
            for(int p: piles) {
                hrs += Math.ceilDiv(p, mid);
            }
            if(hrs > h) {
                lo = mid+1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }


    public static void main(String[] args) {
        KokoBananas kb = new KokoBananas();
        System.out.println("min Eating Speed: "+kb.minEatingSpeed(new int[]{3,6,7,11}, 8));
        System.out.println("min Eating Speed: "+kb.minEatingSpeed(new int[]{30,11,23,4,20}, 5));
        System.out.println("min Eating Speed: "+kb.minEatingSpeed(new int[]{30,11,23,4,20}, 6));
        System.out.println("min Eating Speed: "+kb.minEatingSpeed(new int[]{300}, 6));
        System.out.println("min Eating Speed: "+kb.minEatingSpeed(new int[]{299}, 6));
        System.out.println("min Eating Speed: "+kb.minEatingSpeed(new int[]{332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184}, 823855818));
    }
}
