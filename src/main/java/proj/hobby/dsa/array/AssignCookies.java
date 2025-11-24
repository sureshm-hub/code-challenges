package proj.hobby.dsa.array;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/assign-cookies
 */
public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int ans = 0, i = 0, j = 0;
        while(j < s.length && i < g.length) {
            if(s[j] >= g[i] ) {
                ans++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return ans;
    }
}
