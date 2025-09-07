package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 */
public class BuildTreePostIn {

    int pIdx = 0;
    Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int R = postorder.length - 1;
        pIdx = R;
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(0, R, postorder);
        return root;
    }

    private TreeNode buildTree(int L, int R, int[] postorder) {
        if ( L > R) return null;

        int val = postorder[pIdx--];

        TreeNode node = new TreeNode(val);
        int idx = inMap.get(val);

        // Important: build right before left
        node.right = buildTree(idx + 1, R, postorder);
        node.left = buildTree(L, idx - 1, postorder);

        return node;
    }
}
