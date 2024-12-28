package proj.hobby.dsa.binaryTree.bst;

import proj.hobby.dsa.binaryTree.TreeNode;
import proj.hobby.dsa.binaryTree.TreeNodeUtil;

public class DeleteNodeBst {

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null; //base case

        // search for key
        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else { // found the key

            // case 1,2: node has no or 1 child
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            //case 3: node has both left and right child
            TreeNode minLarge = findMin(root.right); // find min Large for found Node
            root.val = minLarge.val; // replace current val with successor val
            root.right = deleteNode(root.right, minLarge.val); //delete successor

        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        DeleteNodeBst dnb = new DeleteNodeBst();
        TreeNode root = TreeNode.fromArray(new Integer[]{5,3,6,2,4,null,7});
        System.out.println("Root");
        TreeNodeUtil.printTree(root);
        root = dnb.deleteNode(root, 3);
        System.out.println("Delete Operation # 1: Deletion of 3");
        TreeNodeUtil.printTree(root);

        System.out.println("Delete Operation # 2: Deletion of 5");
        root = TreeNode.fromArray(new Integer[]{5,3,6,2,4,null,7});
        root = dnb.deleteNode(root, 5);
        System.out.println("After Deletion of 5");
        TreeNodeUtil.printTree(root);

        System.out.println("Delete Operation # 3: Deletion of 45 - key doesn't exist");
        root = TreeNode.fromArray(new Integer[]{5,3,6,2,4,null,7});
        root = dnb.deleteNode(root, 45);
        System.out.println("After Deletion of 45");
        TreeNodeUtil.printTree(root);
    }

}
