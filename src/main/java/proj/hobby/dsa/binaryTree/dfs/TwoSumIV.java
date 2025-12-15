package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst
 */
public class TwoSumIV {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> val = new HashSet<>();
        return findTarget(root, k, val);
    }

    private boolean findTarget(TreeNode node, int k, Set<Integer> vals) {
        if(node == null) return false;

        if(vals.contains(node.val)) return true;

        vals.add(k - node.val);
        return findTarget(node.left, k, vals) || findTarget(node.right, k, vals);
    }
}
