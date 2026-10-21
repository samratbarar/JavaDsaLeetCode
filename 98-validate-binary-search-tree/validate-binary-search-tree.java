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
    public void SaveAllNodes(TreeNode node, Queue<TreeNode> queue) {
        if (node == null) {
            return;
        }

        SaveAllNodes(node.left, queue);
        queue.offer(node);
        SaveAllNodes(node.right, queue);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        SaveAllNodes(root, queue);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();
            if (queue.isEmpty()) {
                break;
            }
            TreeNode next = queue.peek();

            if (next.val <= curr.val) {
                return false;
            }
        }

        return true;
    }
}