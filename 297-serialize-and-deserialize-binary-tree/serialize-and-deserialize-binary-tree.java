/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    StringBuilder str = new StringBuilder("");

    // Encodes a tree to a single string.
    private void serHelper(TreeNode node) {
        if (node == null) {
            str.append("N,");
            return;
        }

        str.append(node.val).append(",");

        serHelper(node.left);
        serHelper(node.right);
    }

    public String serialize(TreeNode root) {
        str.setLength(0);
        serHelper(root);
        return str.toString();
    }


    int counter = 0;

    // Decodes your encoded data to tree.
    private TreeNode deserHelper(String data) {
        if (counter < data.length()) {
            if (data.charAt(counter) == 'N') {
                counter += 2;
                return null;
            }

            int end = data.indexOf(',', counter);
            int value = Integer.parseInt(data.substring(counter, end));
            counter = end + 1;

            TreeNode node = new TreeNode(value);

            node.left = deserHelper(data); 
            node.right = deserHelper(data); 
 
            return node;
        } else {
            return null;
        }
    }

    public TreeNode deserialize(String data) {
        counter = 0;
        return deserHelper(data);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));