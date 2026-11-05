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
    private int sum(TreeNode node, int pathNum) {
        if (node == null) {
            return 0;
        }

        pathNum = pathNum*10 + node.val;

        if (node.left == null && node.right == null) {
            return pathNum;
        }

        return sum(node.left, pathNum) + sum(node.right, pathNum);
    }

    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }
}