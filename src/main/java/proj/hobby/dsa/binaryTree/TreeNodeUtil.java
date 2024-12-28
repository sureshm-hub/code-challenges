package proj.hobby.dsa.binaryTree;

import java.util.*;

public class TreeNodeUtil {

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        int maxLevel = maxDepth(root);
        printTreeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printTreeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || allElementsNull(nodes)) {
            return;
        }

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        printSpaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                System.out.print(" ");
                newNodes.add(null);
                newNodes.add(null);
            }
            printSpaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printSpaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printSpaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null) {
                    System.out.print("/");
                } else {
                    printSpaces(1);
                }

                printSpaces(i + i - 1);

                if (nodes.get(j).right != null) {
                    System.out.print("\\");
                } else {
                    printSpaces(1);
                }

                printSpaces(edgeLines + edgeLines - i);
            }
            System.out.println();
        }

        printTreeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private static int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    private static boolean allElementsNull(List<TreeNode> list) {
        for (TreeNode node : list) {
            if (node != null) {
                return false;
            }
        }
        return true;
    }

}
