package org.adamtungleetcode.trees;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null || root.right != null) {
            TreeNode node = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(node);
        }
        return root;
    }
}
