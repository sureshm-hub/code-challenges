package proj.hobby.dsa.binaryTree.bst;

import proj.hobby.dsa.binaryTree.TreeNode;
import proj.hobby.dsa.binaryTree.TreeNodeUtil;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 *
 * Complexity:
 *  Time: O(N) - visit all nodes in arr
 *  Space: O(N) - Node for each element in arr
 *
 */
public class MakeBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] arr) {
        if(arr == null) return null;// handle null case

        return binarySearchTree(arr, 0, arr.length-1);
    }

    private TreeNode binarySearchTree(int[] arr,   int start, int end) {
        if(start > end) {
            return null; // base case
        }
        if(start == end) {
            return new TreeNode(arr[start]); // base case
        }

        int mid = start + (end-start)/2 ;
        TreeNode current = new TreeNode(arr[mid]);
        current.left = binarySearchTree(arr, start, mid-1); // min node
        current.right = binarySearchTree(arr, mid+1, end); //max node

        return current;
    }

    public static void main(String[] args) {
        MakeBinarySearchTree mst = new MakeBinarySearchTree();
        TreeNode root = mst.sortedArrayToBST(new int[]{0,1,2,3,4});
        TreeNodeUtil.printTree(root);

        root = mst.sortedArrayToBST(new int[]{10,11,12,13,14,15});
        TreeNodeUtil.printTree(root);
    }
}
