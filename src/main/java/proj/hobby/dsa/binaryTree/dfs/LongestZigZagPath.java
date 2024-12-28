package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

public class LongestZigZagPath {

    public int longestZigZag(TreeNode root) {

        if(root == null) return 0;

        int leftPath = longestZigZagHelper(root.left, 1, true); //get longest zigzag path on left tree
        int rightPath = longestZigZagHelper(root.right, 1, false); // get longest zigzag path on right tree

        return Math.max(leftPath, rightPath);
    }

    private int longestZigZagHelper(TreeNode root, int depth, boolean isLeft) {

        if(root == null) return depth-1; // we have hit end of path and we can retrun depth

        if(isLeft) {
            // coming from left - increase depth on right and reset on left and propagate max up call tree
            return Math.max(
                    longestZigZagHelper(root.left, 1, true),
                    longestZigZagHelper(root.right, depth+1, false));

        } else {
            // coming from right - increase depth on left and reset on right and propagate max up call tree
            return Math.max(
                    longestZigZagHelper(root.left, depth+1, true),
                    longestZigZagHelper(root.right, 1, false));
        }
    }

    public static void main(String[] args) {
        LongestZigZagPath lzp = new LongestZigZagPath();
        System.out.println("Longest ZigZagPath: "+lzp.longestZigZag(TreeNode.fromArray(new Integer[]{1,null,1,1,1,null,null,1,1,null,1,null,null,null,1})));
        System.out.println("Longest ZigZagPath:"+lzp.longestZigZag(TreeNode.fromArray(new Integer[]{1,1,1,null,1,null,null,1,1,null,1})));
    }

}
