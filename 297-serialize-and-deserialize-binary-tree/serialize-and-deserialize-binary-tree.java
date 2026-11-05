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
    private String serHelper(TreeNode node) {
        if (node == null) {
            str.append("N,");
            return str.toString();
        }

        str.append(node.val).append(",");

        serHelper(node.left);
        serHelper(node.right);

        return str.toString();
    }

    public String serialize(TreeNode root) {
        str.setLength(0);
        return serHelper(root);
    }


    int counter = 0;

    // Decodes your encoded data to tree.
    private TreeNode deserHelper(String data) {
        if (counter < data.length()) {
            if (data.charAt(counter) == 'N') {
                counter += 2;

                return null;
            }

            int start = counter;
            char ch = data.charAt(counter);

            while (ch != ',') {
                counter++;

                if (counter == data.length()) {
                    break;
                }

                ch = data.charAt(counter);
            }

            TreeNode node = new TreeNode(Integer.parseInt(data.substring(start, counter)));
            counter++;

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