package proj.hobby.dsa.binaryTree.bst;

import proj.hobby.dsa.binaryTree.TreeNode;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/?envType=study-plan-v2&envId=leetcode-75
 *
 * Approach: Binary Search
 *
 * Complexity:
 *  Time: O(log N)
 *  Space: O(1)
 */
public class BinarySearch {

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) {
            return null;
        }

        TreeNode current = root;
        // search val for Binary Search Tree
        while(current != null) {
            if(current.val == val) {
                return current;
            } else if(current.val > val) { // search left tree
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        System.out.println("BinarySearch: "+binarySearch.searchBST(TreeNode.fromArray(new Integer[]{4,2,7,1,3}), 2).val);
        System.out.println("BinarySearch: "+binarySearch.searchBST(TreeNode.fromArray(new Integer[]{4,2,7,1,3}), 6) );
    }

}
