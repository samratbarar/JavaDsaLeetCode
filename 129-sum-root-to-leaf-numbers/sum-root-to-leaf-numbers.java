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
    int sum = 0;

    private void sum(TreeNode node, int pathNum) {
        if (node == null) {
            return;
        }

        pathNum = pathNum*10 + node.val;

        if (node.left == null && node.right == null) {
            sum += pathNum;
            return;
        }

        sum(node.left, pathNum);
        sum(node.right, pathNum);
    }

    public int sumNumbers(TreeNode root) {
        sum = 0;
        sum(root, 0);
        return sum;
    }
}