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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); 

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean isXPresent = false;
            boolean isYPresent = false;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) || (node.right.val == x && node.left.val == y)) {
                        return false;
                    }
                }   

                if (node.left != null) {
                    queue.offer(node.left);
                }
            
                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (node.val == x) {
                    isXPresent = true;
                }

                if (node.val == y) {
                    isYPresent = true;
                }
            }

            if (isXPresent && isYPresent) {
                return true;
            }

            if (isXPresent) {
                return false;
            }
    
            if (isYPresent) {
                return false;
            }
        }

        return false;
    }
}