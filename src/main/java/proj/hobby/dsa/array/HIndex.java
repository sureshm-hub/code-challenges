package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/h-index/description/
 */
public class HIndex {

    public int hIndex(int[] citations) {

        int N = citations.length;
        int[] h = new int[N + 1];

        for(int c : citations) {
            for(int j = 0; j <= c && j < h.length; j++) {
                ++h[j];
            }
            // System.out.println(Arrays.toString(h));
        }


        int hMax = 0;
        for(int j = 0; j < h.length; j++) {
            if(h[j] >= j) {
                hMax = j;
            } else {
                break;
            }
        }

        return hMax;

    }

}
