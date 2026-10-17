/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> childs = new LinkedList<>();
        childs.offer(root);

        while (!childs.isEmpty()) {
            int levelSize = childs.size();

            for (int i = 0; i < levelSize; i++) {
                Node node = childs.remove();
            
                if (node.left != null) {
                    childs.add(node.left);
                }

                if (node.right != null) {
                    childs.add(node.right);
                }

                if (i != levelSize-1) {
                    node.next = childs.peek();
                }
            }
        }

        return root;
    }
}