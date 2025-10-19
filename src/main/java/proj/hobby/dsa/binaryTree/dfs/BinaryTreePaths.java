package proj.hobby.dsa.binaryTree.dfs;

import proj.hobby.dsa.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> paths = new ArrayList<>();

        if(root == null) return paths;

        dfsString(root, paths, new StringBuilder());

        return paths;
    }

    private void dfsString(TreeNode root, List<String> paths, StringBuilder sb) {
        if(root == null) {
            return;
        }
        String val = root.val+"->";
        sb.append(val);

        if(root.left == null && root.right == null) {
            paths.add(sb.substring(0, sb.length() - 2));
        }
        dfsString(root.left, paths, sb);
        dfsString(root.right, paths, sb);
        sb.setLength(sb.length() - val.length());
    }
}
