package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 */
public class BuildTreePreIn {

    Map<Integer, Integer> inMap = new HashMap<>();
    int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for(int i =0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(0, inorder.length - 1, preorder);
        return root;
    }

    private TreeNode buildTree(int L, int R, int[] pre) {
        if(L > R) return null;

        int val = pre[preIdx++];
        TreeNode node = new TreeNode(val);
        int idx = inMap.get(val);

        node.left = buildTree(L, idx - 1,  pre);
        node.right = buildTree(idx + 1, R, pre);
        return node;
    }
}
