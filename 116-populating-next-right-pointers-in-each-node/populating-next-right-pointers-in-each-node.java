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

        final var queue = new LinkedList<Node>();

        var numberOfItemsInCurrentLevel = 1;
        queue.add(root);

        while(numberOfItemsInCurrentLevel > 0) {

            var nextLevelNumberOfItems = 0;
            Node prevNode = null;

            for (;numberOfItemsInCurrentLevel > 0; numberOfItemsInCurrentLevel--) {
                
                final var currentNode = queue.poll();
                currentNode.next = prevNode;

                prevNode = currentNode;

                if (currentNode.right == null) {
                    continue;
                }

                queue.add(currentNode.right);
                queue.add(currentNode.left);
                nextLevelNumberOfItems += 2;
            }

            numberOfItemsInCurrentLevel = nextLevelNumberOfItems;
        }

        return root;
    }
}