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
    public TreeNode findNode(TreeNode node, int value) {
        if (node == null) {
            return null;
        }

        if (node.val == value) {
            return node;
        }

        TreeNode left = findNode(node.left, value);
        if (left != null) {
            return left;
        }

        return findNode(node.right, value);
    }

    public int level(TreeNode node, TreeNode levNode, int lev) {
        if (node == null) {
            return 0;
        }

        if (node == levNode) {
            return lev;
        }

        int levOfNode = level(node.left, levNode, lev+1);
        if (levOfNode != 0) {
            return levOfNode;
        }

        return level(node.right, levNode, lev+1);
    }

    public boolean isSiblings(TreeNode node, TreeNode x, TreeNode y) {
        if (node == null) {
            return false;
        }

        return ((node.left == x && node.right == y) || (node.left == y && node.right == x) || isSiblings(node.left, x, y) || isSiblings(node.right, x, y));
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xNode = findNode(root, x);
        TreeNode yNode = findNode(root, y);

        return (level(root, xNode, 0) == level(root, yNode, 0) && (!isSiblings(root, xNode, yNode)));
    }
}