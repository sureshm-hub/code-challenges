package proj.hobby.dsa.binaryTree.dfs;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets
 */
public class KEqualSubsetPartitions {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum % k != 0) return false;

        final int part = sum / k;

        if(Arrays.stream(nums).anyMatch(num -> num > part)) return false;

        //return dfs(nums, 0, k, 0, part, 0);

        boolean[] visited = new boolean[nums.length];
        return dfs2(nums, 0, k, 0, part, visited);
    }

    // using bitwise used
    private boolean dfs(int[] nums, int start, int remain, int cur, int target, int used) {
        if(remain == 0) return true;

        if(cur > target) return false;

        if(cur == target)
            return dfs(nums, 0, remain - 1, 0, target, used); // restart subset search

        for(int i = start; i < nums.length; i++) {
            if((used >> i & 1) == 1) continue;

            if(dfs(nums, i + 1, remain, cur + nums[i], target, used | 1 << i ))
                return true;
        }

        return false;
    }


    // using boolean[] visited
    private boolean dfs2(int[] nums, int start, int remain, int cur, int target, boolean[] visited) {
        if(remain == 0) return true;

        if(cur > target) return false;

        if(cur == target)
            return dfs2(nums, 0, remain - 1, 0, target, visited); // restart subset search

        for(int i = start; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(dfs2(nums, i + 1, remain, cur + nums[i], target, visited)) return true;
                visited[i] = false;
            }
        }

        return false;
    }
}
