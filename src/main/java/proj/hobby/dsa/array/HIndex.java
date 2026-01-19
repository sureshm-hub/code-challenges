package proj.hobby.dsa.array;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/h-index/description/
 */
public class HIndex {

    // Bucket Sorting
    public int hIndex(int[] citations) {

        Map<Integer, Integer> counts = new HashMap<>(); // # of citations, # of papers
        int n = citations.length;
        for(int c : citations) {
            if(c > n) c = n; // h max is capped at # of papers
            counts.merge(c, 1, Integer::sum);
        }
        // this technique is also called "bucket sort" - we can replace Map with int[] buckets

        // lo can be 0 & hi can be Min of(# of citations or # citations length)
        int sum = 0;
        for(int h = n; h >= 0; h--) {
            if(counts.containsKey(h)) {
                sum += counts.get(h);
            }
            if(sum >= h) return h;
        }

        return 0;
    }

    public int hIndex2(int[] citations) {

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
