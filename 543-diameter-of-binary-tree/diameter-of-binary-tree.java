/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = height(node.left);
        int right = height(node.right);

        return Math.max(left, right) + 1;
    }

    public int diameter(TreeNode node, int dia, int max) {
        if (node == null) {
            return max;
        }

        dia = height(node.left) + height(node.right);
        max = Math.max(dia, max);

        return Math.max(diameter(node.left, dia, max), diameter(node.right, dia, max));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return diameter(root, 0, 0);
    }
}