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
    List<Integer> list;
    public void createList(TreeNode node) {
        if (node == null) {
            return;
        }

        createList(node.left);
        list.add(node.val);
        createList(node.right);
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        list = new ArrayList<>();

        createList(root);

        int left = 0, right = list.size() - 1;

        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == k) {
                return true;
            }

            if (sum < k) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }
}