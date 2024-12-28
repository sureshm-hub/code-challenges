package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: PostOrder DFS and propagate the answer up the call stack
 *
 * Complexity:
 *  Time: O(N)
 *  Space: O(H) - H is height for storing left, right in the call stack
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // Basecase: if root is null or root is p or q return root
        if(root == null || root == p || root == q) {
            return root;
        }

        // dfs to find in left or right tree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // if left and right are found  then root is lca
        if(left != null && right != null) {
            return root;
        }

        // propagate the left or right to the  answer
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        LowestCommonAncestor lca = new LowestCommonAncestor();
        TreeNode root = TreeNode.fromArray(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        System.out.println("Lowest Common Ancestor: "+lca.lowestCommonAncestor(root, root.treeNodeOf(5), root.treeNodeOf(4)).val);
        System.out.println("Lowest Common Ancestor: "+lca.lowestCommonAncestor(root, root.treeNodeOf(5), root.treeNodeOf(8)).val);
    }
}
