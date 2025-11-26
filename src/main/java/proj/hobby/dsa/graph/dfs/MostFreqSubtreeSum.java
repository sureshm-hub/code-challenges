package proj.hobby.dsa.graph.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/most-frequent-subtree-sum/description
 *
 */
public class MostFreqSubtreeSum {

    public int[] findFrequentTreeSum(TreeNode root) {
        final Map<Integer, Integer> sums = new HashMap<>();
        int rootSum = findTreeSum(root, sums);

        final int max = sums.values().stream().mapToInt(Integer::intValue).max().getAsInt();

        int[] freqs = sums.keySet().stream().filter( k -> sums.get(k) == max).mapToInt(Integer::intValue).toArray();
        return freqs;
    }

    private int findTreeSum(TreeNode node, Map<Integer, Integer> sums) {

        if(node == null) return 0;

        int left = findTreeSum(node.left, sums);
        int right = findTreeSum(node.right, sums);
        int sum = left + right + node.val;

        sums.merge(sum, 1, (oldVal, newVal) -> oldVal + newVal);

        return sum;
    }
}
