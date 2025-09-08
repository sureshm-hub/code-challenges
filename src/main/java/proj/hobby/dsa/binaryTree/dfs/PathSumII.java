package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        if(root == null) {
            return paths;
        }

        buildPath(root, targetSum, paths, new ArrayList<>());
        return paths;
    }

    private void buildPath(TreeNode node, int target, List<List<Integer>> paths, List<Integer> curr) {
        if(node == null) return;

        int val = target - node.val;
        curr.add(node.val);
        //System.out.println(" curr >> "+curr);
        if (val == 0 && node.left == null && node.right == null) {
            paths.add(new ArrayList<>(curr));
            curr.remove(curr.size() - 1);
            return;
        }
        buildPath(node.left, val, paths, curr);
        buildPath(node.right, val, paths, curr);
        //System.out.println(" remove >> "+curr.get(curr.size() - 1));
        curr.remove(curr.size() - 1);
    }
}
