/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Node newHead = null;
        Node prevNode = null;
        Node currentNode = head;
        
        final var newNodesByOldNodes = new IdentityHashMap<Node, Node>();
        
        while (currentNode != null) {
            
            final var newNode = new Node(currentNode.val);
                
            if (newHead == null) {
                newHead = newNode;
            } else {
                prevNode.next = newNode;
            }
            
            newNode.random = currentNode.random;
            newNodesByOldNodes.put(currentNode, newNode);
            
            prevNode = newNode;
            currentNode = currentNode.next;
        }
        
        currentNode = newHead;
        
        while (currentNode != null) {

            if (currentNode.random != null) {
                currentNode.random = newNodesByOldNodes.get(currentNode.random);
            }
            
            currentNode = currentNode.next;
        }
        
        return newHead;
    }
}