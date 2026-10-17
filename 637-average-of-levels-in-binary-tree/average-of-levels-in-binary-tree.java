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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> childs = new LinkedList<>();
        childs.offer(root);

        while (!childs.isEmpty()) {
            int levelSize = childs.size();
            long sum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = childs.remove();
            
                if (node.left != null) {
                    childs.add(node.left);
                }

                if (node.right != null) {
                    childs.add(node.right);
                }

                sum += node.val;
            }

            ans.add((double)sum / levelSize);
        }

        return ans;
    }
}