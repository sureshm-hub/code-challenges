package proj.hobby.dsa.binarySearch;

/**
 *
 * https://leetcode.com/problems/first-bad-version/description/
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int lo = 1, hi = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            boolean isBad = isBadVersion(mid);

            if(isBad) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }


    // Different Convergence
    public int firstBadVersion2(int n) {
        int lo = 1, hi  = n;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2 ;
            if(isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    private boolean isBadVersion(int version) {
        return  true;
    }
}
