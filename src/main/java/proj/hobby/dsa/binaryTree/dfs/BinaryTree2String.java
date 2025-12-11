package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 *
 * https://leetcode.com/problems/construct-string-from-binary-tree/description
 */
public class BinaryTree2String {

    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if(node == null) return;

        boolean root = sb.isEmpty();
        if(root) {
            sb.append(node.val);
        } else {
            sb.append("(").append(node.val);
        }
        if(node.left == null && node.right != null) {
            sb.append("()");
        }
        dfs(node.left, sb);
        dfs(node.right, sb);
        if(!root) sb.append(")");
    }
}
