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
    private List<List<Integer>> BFSearch(Queue<TreeNode> childs, List<List<Integer>> ans) {
        if (childs.isEmpty()) {
            return ans;
        }

        List<Integer> level = new ArrayList<>();
        int levelSize = childs.size();

        for (int i = 0; i < levelSize; i++) {
            TreeNode node = childs.remove(); 
            
            if (node.left != null) {
                childs.add(node.left);
            }

            if (node.right != null) {
                childs.add(node.right);
            }

            level.add(node.val);
        }

        ans.add(level);
        return BFSearch(childs, ans);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<TreeNode> childs = new LinkedList<>();
        childs.offer(root);

        // while (!childs.isEmpty()) {
        //     int levelSize = childs.size();
        //     List<Integer> level = new ArrayList<>();

        //     for (int i = 0; i < levelSize; i++) {
        //         TreeNode node = childs.remove();
            
        //         if (node.left != null) {
        //             childs.add(node.left);
        //         }

        //         if (node.right != null) {
        //             childs.add(node.right);
        //         }

        //         level.add(node.val);
        //     }

        //     ans.add(level);
        // }

        return BFSearch(childs, ans);
    }
}