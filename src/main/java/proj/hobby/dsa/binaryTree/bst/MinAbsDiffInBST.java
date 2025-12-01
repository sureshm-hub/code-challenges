package proj.hobby.dsa.binaryTree.bst;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/description
 *
 */
public class MinAbsDiffInBST {

    public int getMinimumDifference(TreeNode root) {
        List<Integer> sorted = new ArrayList<>();
        dfs(root, sorted);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < sorted.size(); i++) {
            min = Math.min(min, Math.abs(sorted.get(i) - sorted.get(i-1)));
        }
        return min;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if(node == null) return;

        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }
}
