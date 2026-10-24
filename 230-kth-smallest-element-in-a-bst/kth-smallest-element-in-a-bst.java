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
    public List<Integer> list = new ArrayList<>();

    public void store(TreeNode node) {
        if (node == null) {
            return;
        }

        store(node.left);
        list.add(node.val);
        store(node.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        store(root);

        return list.get(k-1);
    }
}