package proj.hobby.dsa.dp;
import java.util.*;

/**
 *
 * https://leetcode.com/problems/jump-game-ii/description/
 */
public class JumpGameII {

    public int jump(int[] nums) {

        int L = nums.length;
        int[] steps = new int[L];
        List<Integer> jumps = Arrays.asList(0);
        int counter = 0;
        //System.out.println(counter+": "+jumps);
        while(steps[L-1] == 0 && !jumps.isEmpty()) {
            counter++;
            List<Integer> temp = new ArrayList<>();
            for(int jump : jumps) {
                int curr = nums[jump];
                for(int i = 1; i <= curr; i++) {
                    int next = jump+i;
                    if( next < L  && steps[next]  == 0) {
                        steps[next] = counter;
                        temp.add(next);
                    }
                }
            }
            jumps = temp;
            //System.out.println(counter+": "+jumps);
            //jumps = next.stream().mapToInt(Integer::intValue).toArray();
        }
        return steps[L-1];
    }
}
