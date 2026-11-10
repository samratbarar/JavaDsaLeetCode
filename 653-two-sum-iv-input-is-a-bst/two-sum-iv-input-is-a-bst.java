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
    HashSet<Integer> set;
    private boolean find(TreeNode node, int k) {
        if (node == null) {
            return false;
        }

        if (set.contains(k - node.val)) {
            return true;
        }
        
        set.add(node.val);

        return find(node.left, k) || find(node.right, k);
    }

    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        return find(root, k);
    }
}