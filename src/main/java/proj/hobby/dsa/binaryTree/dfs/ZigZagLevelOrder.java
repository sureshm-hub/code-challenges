package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 */
public class ZigZagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zz = new ArrayList<>();
        if(root == null) return zz;
        zz.add(Arrays.asList(root.val));

        List<TreeNode> parent = new ArrayList<>();
        parent.add(root);
        boolean reverse = true;
        while(!parent.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            List<Integer> vals = new ArrayList<>();
            for(TreeNode p : parent) {
                if(p.left != null) {
                    temp.add(p.left);
                    vals.add(p.left.val);
                }
                if(p.right != null) {
                    temp.add(p.right);
                    vals.add(p.right.val);
                }
            }
            if(reverse) {
                Collections.reverse(vals);
                reverse = false;
            } else {
                reverse = true;
            }
            if(!vals.isEmpty()) {
                zz.add(vals);
            }
            parent = temp;
        }
        return zz;
    }
}
