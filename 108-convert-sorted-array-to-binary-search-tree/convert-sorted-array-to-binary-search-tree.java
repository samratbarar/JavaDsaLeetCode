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
    public TreeNode populatedSorted(int[] nums, int start, int end, TreeNode node) {
        if (start >= end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        node = new TreeNode(nums[mid]);

        node.left = populatedSorted(nums, start, mid, node.left);
        node.right = populatedSorted(nums, mid + 1, end, node.right);

        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        TreeNode root = null;
        
        root = populatedSorted(nums, 0, nums.length, root);

        return root;
    }
}