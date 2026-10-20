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
    public void storeAllNodes(TreeNode node, Queue<TreeNode> queue) {
        if (node == null) {
            return;
        }

        queue.offer(node);

        if (node.left != null) {
            queue.offer(node.left);
            storeAllNodes(node.left, queue);
        }

        if (node.right != null) {
            queue.offer(node.right);
            storeAllNodes(node.right, queue);
        }
    }
     
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        storeAllNodes(root, queue);

        root = queue.poll(); 
        root.left = null;
        root.right = null;

        TreeNode node = root;

        while (!queue.isEmpty()) {
            node.right = queue.poll();

            node = node.right;
            node.left = null;
            node.right = null;
        }
    }
}