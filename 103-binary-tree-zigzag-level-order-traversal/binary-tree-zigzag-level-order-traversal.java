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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Deque<TreeNode> childs = new LinkedList<>();
        childs.offer(root);
        boolean alter = false;

        while (!childs.isEmpty()) {
            int levelSize = childs.size();
            List<Integer> level = new ArrayList<>();

            if (alter) {
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = childs.removeLast();
            
                    if (node.right != null) {
                        childs.addFirst(node.right);
                    }
                    
                    if (node.left != null) {
                        childs.addFirst(node.left);
                    }


                    level.add(node.val);
                }
            } else {
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = childs.removeFirst();
            
                    if (node.left != null) {
                        childs.addLast(node.left);
                    }

                    if (node.right != null) {
                        childs.addLast(node.right);
                    }

                    level.add(node.val);
                }
            }

            alter = !alter;

            ans.add(level);
        }

        return ans;
    }
}