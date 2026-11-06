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
    int maxSum = Integer.MIN_VALUE;

    private int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = sum(node.left); 
        int right = sum(node.right);

        maxSum = Math.max(maxSum, node.val + Math.max(0, left) + Math.max(0, right));

        return Math.max(Math.max(0, left), Math.max(0, right)) + node.val;
    }
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        sum(root);
        return maxSum;
    }
}