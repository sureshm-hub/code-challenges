package proj.hobby.dsa.graph.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description
 *
 */
public class FindLargestVal {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        largest(root, 0, res);
        return res;
    }

    private void largest(TreeNode node, int level, List<Integer> res) {
        if(node == null) return;

        if(res.size() <= level) {
            res.add(node.val);
        } else {
            res.set(level, Math.max(res.get(level), node.val));// set max for current level
        }

        largest(node.left, level + 1, res);
        largest(node.right, level + 1, res);
    }

}
