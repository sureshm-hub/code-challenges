package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/beautiful-arrangement-ii/description
 */
public class BeautifulArrangementII {

    public int[] constructArray(int n, int k) {
        int[] res = new int[n];

        for(int i = 0; i <  n - k; i++) {
            res[i] = i + 1;
        }

        for(int i = 0; i < k; i++) {
            if(i % 2 == 0) res[n - k + i] = n - i  / 2;
            else res[n - k + i] = n - k  + (i + 1) / 2;
        }

        return res;
    }
}
