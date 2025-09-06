package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;
import java.util.*;

/**
 *
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 */
public class RecoverBST {

    public void recoverTree(TreeNode root) {
        List<TreeNode> path = new ArrayList<>();
        traverse(root, path);

        TreeNode first = null, sec = null;

        for(int i = 0; i+1 < path.size(); i++) {
            if(path.get(i).val >= path.get(i+1).val) {
                if(first == null) first = path.get(i);
                sec = path.get(i+1);
            }
        }

        if(first != null && sec != null) {
            int temp = first.val;
            first.val = sec.val;
            sec.val = temp;
        }
    }

    private void traverse(TreeNode node, List<TreeNode> path) {
        if(node == null) return;
        traverse(node.left, path);
        path.add(node);
        traverse(node.right, path);
    }
}
