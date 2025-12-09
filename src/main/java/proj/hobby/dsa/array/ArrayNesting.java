package proj.hobby.dsa.array;

/**
 *
 * https://leetcode.com/problems/array-nesting/description
 */
public class ArrayNesting {

    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];

        int ans = 0;

        for(int i = 0; i < n; i++) {

            // permutation of disjoint cycles
            if(! visited[i]) {

                int cur = i;
                int count = 0;

                // walk the cycle starting from i
                while(!visited[cur]) {
                    visited[cur] = true;
                    cur = nums[cur]; //jump to next  index;
                    count++;
                }

                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
}
