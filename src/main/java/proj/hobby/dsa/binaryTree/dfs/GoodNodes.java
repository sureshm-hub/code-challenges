package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;
/**
 *
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: BinaryTree DFS
 *
 * Complexity:
 *  Time: O(N)
 *  Space: O(H) - H  is the height of the tree for recursive stack.
 *
 */
public class GoodNodes {

    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    private int goodNodes(TreeNode root, int maxParentNode) {

        if(root == null) return 0;

        int goodNodesInTree = 0;
        // check current node is good node
        if(root.val >= maxParentNode)  goodNodesInTree++;
        // good Nodes in Left
        goodNodesInTree += goodNodes(root.left, Math.max(maxParentNode, root.val));
        // good Nodes in Right
        goodNodesInTree += goodNodes(root.right, Math.max(maxParentNode, root.val));

        return goodNodesInTree;
    }

    public static void main(String[] args) {
        GoodNodes gn = new GoodNodes();
        System.out.println("Good Nodes in Tree: "+gn.goodNodes(TreeNode.fromArray(new Integer[]{3,1,4,3,null,1,5})));
        System.out.println("Good Nodes in Tree: "+gn.goodNodes(TreeNode.fromArray(new Integer[]{3,3,null,4,2})));
    }

}
