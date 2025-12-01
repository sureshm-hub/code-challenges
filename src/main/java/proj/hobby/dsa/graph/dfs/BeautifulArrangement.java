package proj.hobby.dsa.graph.dfs;

/**
 *
 * https://leetcode.com/problems/beautiful-arrangement
 */
public class BeautifulArrangement {

    public int countArrangement(int n) {
        boolean[] used = new boolean[n+1];
        return backtrack(1, n, used);
    }

    private int backtrack(int pos, int n, boolean[] used) {
        if(pos > n) return 1;// we filled pos 1..n

        int count = 0;

        //try each num at this position to see if the arrangement is beautiful
        for(int num = 1; num <= n; num++) {
            // check arrangement
            if(!used[num] && (num % pos == 0 || pos % num == 0)) { // prune early
                used[num] = true;
                count += backtrack(pos + 1, n, used);
                used[num] = false;
            }
        }

        return count;
    }

}
