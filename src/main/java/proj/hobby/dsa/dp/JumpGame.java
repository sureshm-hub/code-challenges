package proj.hobby.dsa.dp;
import java.util.*;

/**
 *
 * https://leetcode.com/problems/jump-game/
 *
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int L = nums.length;
        boolean[] reach = new boolean[nums.length];
        List<Integer> jumps = Arrays.asList(0);
        reach[0] = true;
        while(!reach[L-1] && !jumps.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for(int curr : jumps) {
                int max = nums[curr];
                for(int i = 1; i <= max; i++) {
                    int next = curr+i;
                    if(next < L && !reach[next]) {
                        reach[next] = true;
                        temp.add(next);
                    }
                }
            }
            jumps = temp;
            //System.out.println(Arrays.toString(reach)+" -- "+jumps);
        }
        return reach[L-1];
    }

}
