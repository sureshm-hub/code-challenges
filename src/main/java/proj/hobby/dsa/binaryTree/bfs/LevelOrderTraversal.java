package proj.hobby.dsa.binaryTree.bfs;

import proj.hobby.dsa.binaryTree.TreeNode;
import java.util.*;

/**
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal
 *
 * Complexity:
 *   Time: O(N) - visit each element once
 *   Space: O(N) - for all elements & O(log N) for call stack with worst case of O(N) for skewed tree's
 *      N # number of elements in Tree
 *
 */
public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfsHelper(root, 0, result);
        return result;
    }

    void dfsHelper(TreeNode root, int level, List<List<Integer>> result) {

        if(root == null) {
            return;
        }

        if(result.size()  < level+1) {
            result.add(new ArrayList<>()); //dfs visit will ensure we need to add only next level
        }

        result.get(level).add(root.val);
        dfsHelper(root.left, level+1, result);
        dfsHelper(root.right, level+1, result);
    }

}
