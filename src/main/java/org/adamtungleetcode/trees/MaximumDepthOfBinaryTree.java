package org.adamtungleetcode.trees;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 1;
        if (root.left != null && root.right != null) {
            return count + Integer.max(maxDepth(root.left), maxDepth(root.right));
        } else if (root.left != null) {
            return count + maxDepth(root.left);
        } else if (root.right != null) {
            return count + maxDepth(root.right);
        } else {
            return 1;
        }
    }
}
