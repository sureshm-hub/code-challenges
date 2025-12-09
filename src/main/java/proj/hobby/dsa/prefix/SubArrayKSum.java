package proj.hobby.dsa.prefix;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/subarray-sum-equals-k
 *
 */
public class SubArrayKSum {

    public int subarraySum(int[] nums, int k) {
        // O(N) - prefix + hashMap
        // prefix[t] = nums[0] + ... + nums[t-1]
        // sum(i..j) = prefix[j+1] - prefix[i]
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        int curr = 0;
        int ans = 0;

        for(int x : nums) {
            curr += x;
            int need = curr - k;
            ans += prefixCount.getOrDefault(need, 0);

            prefixCount.merge(curr, 1, Integer::sum);
        }

        return ans;

        // O(N^2)
        // doubleLoop(nums, k);

        // backtracking
        // return dfs(nums, k, 0);
    }

    private int doubleLoop(int[] nums, int k) {
        int N = nums.length;
        int count = 0;
        for(int i = 0; i < N; i++) {
            int sum = 0;
            for(int j = i; j < N; j++) {
                sum += nums[j];
                if(sum == k) count++;
            }
        }

        return count;
    }

    private int dfs(int[] nums, int k, int start) {
        if(k == 0) return 1;
        if(start >= nums.length) return 0;

        int l = dfsSubArray(nums, k, start, start, 0);
        int r = dfs(nums, k , start + 1);
        return l + r;
    }

    private int dfsSubArray(int[] nums, int k, int start, int end, int sum) {
        if(end >= nums.length) return 0;

        sum += nums[end];
        int count = (sum == k) ? 1 : 0;

        count += dfsSubArray(nums, k, start, end+1, sum);

        return count;
    }
}
