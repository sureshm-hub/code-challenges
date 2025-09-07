package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 *
 */
public class BinaryTreeLevelOrderII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Map<Integer, int[]> levelIdx = new HashMap<>();
        levelIdx.put(1, new int[]{0, 0});
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        int start = 0, end = 0, i = 0, level = 1;
        while(i <= end) {
            TreeNode curr = nodes.get(i++);
            if (curr.left != null) {
                nodes.add(curr.left);
            }
            if (curr.right != null) {
                nodes.add(curr.right);
            }
            if (i > end && end < nodes.size() - 1) {
                start = end + 1;
                end = nodes.size() - 1;
                levelIdx.put(++level, new int[]{start, end});
            }
        }

        while(level >= 1) {
            List<Integer> levelList = new ArrayList<>();
            int[] idx = levelIdx.get(level--);
            for(int j = idx[0]; j <= idx[1]; j++) {
                levelList.add(nodes.get(j).val);
            }
            res.add(levelList);
        }

        return res;
    }

}
