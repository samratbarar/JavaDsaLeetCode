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
    public TreeNode build(TreeNode node, int[] pre, int[] in) {
        if (pre.length == 0) {
            return null;
        }

        TreeNode left = new TreeNode();
        TreeNode right = new TreeNode();

        node.val = pre[0];

        node.left = left;
        node.right = right;

        int i = 0;

        for (i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                break;
            }
        }

        node.left = build(node.left, Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
        node.right = build(node.right, Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));

        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);

        return build(root, preorder, inorder);
    }
}