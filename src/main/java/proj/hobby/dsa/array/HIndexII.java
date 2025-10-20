package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/h-index-ii/
 */
public class HIndexII {

    public int hIndex(int[] citations) {

        int N = citations.length;
        int lo = 0;
        int hi = N - 1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int numCitesWithMid = N - mid;
            if( citations[mid] >= numCitesWithMid) { //index based 1
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return N - lo;
    }

}
