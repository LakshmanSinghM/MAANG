// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

package coding_patterns.trees.hard;

import coding_patterns.trees.basic.TreeNode;

public class FlattenBinaryTree {

    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;

        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        new FlattenBinaryTree().flatten(root);
    }
}