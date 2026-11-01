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
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode build(int[] pre, int[] in, int preStart, int inStart, int inEnd) {
        TreeNode node = new TreeNode();

        if (inStart > inEnd) {
            return null;
        }


        node.val = pre[preStart];

        int i = map.get(pre[preStart]);

        node.left = build(pre, in, preStart + 1, inStart, i - 1);
        node.right = build(pre, in, i - inStart + 1 + preStart, i + 1, inEnd);
        
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, 0, inorder.length-1);
    }
}