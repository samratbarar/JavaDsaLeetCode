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
    private boolean hasPathSum(TreeNode node, int sum, int target) {
        if (node == null) {
            return false;
        }

        sum += node.val;

        if (node.left == null && node.right == null) {
            return sum == target;
        }

        boolean left = hasPathSum(node.left, sum, target);
        boolean right = hasPathSum(node.right, sum, target);

        return left || right;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, 0, targetSum);
    }
}