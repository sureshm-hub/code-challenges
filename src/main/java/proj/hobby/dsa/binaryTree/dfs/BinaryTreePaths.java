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
        List<String> result = new ArrayList<>();
        dfs(root, result, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode node, List<String> result, List<Integer> path) {
        if(node == null) return;

        if(node.left == null && node.right == null) {
            StringBuilder sb  = new StringBuilder();
            for(int p : path) {
                sb.append(p).append("->");
            }
            sb.append(node.val);
            result.add(sb.toString());
            return;
        }
        path.add(node.val);
        dfs(node.left, result, path);
        dfs(node.right, result, path);
        path.remove(path.size()-1);
    }


    public List<String> binaryTreePaths2(TreeNode root) {

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
