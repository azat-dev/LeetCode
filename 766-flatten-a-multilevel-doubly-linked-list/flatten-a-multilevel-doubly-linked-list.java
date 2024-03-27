/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    
    private Node getLastNode(Node head) {
        
        while (head != null && head.next != null) {
            head = head.next;
        }
        
        return head;
    }
    
    public Node flatten(Node head) {
        
        var currentNode = head;
        final var headsStack = new LinkedList<Node>();
        
        while (currentNode != null) {
            
            if (currentNode.child != null) {
                // Save the parent node
                final var parentNode = currentNode;
                // Go to the child list
                currentNode = currentNode.child;
                parentNode.child = null;
                
                // Save the parent node
                currentNode.prev = parentNode;
                headsStack.push(currentNode);
                continue;
            }
            
            if (currentNode.next != null) {
                // Skip the node
                currentNode = currentNode.next;
                continue;
            }
            
            // We are at the end of the current list
            if (headsStack.isEmpty()) {
                // We are in the top level list
                break;
            }
            
            // We reached the end one of child lists
            final var currentListHead = headsStack.pop();
            final var parentNode = currentListHead.prev;
            final var parentNodeNext = parentNode.next;
            
            // Connect the next node from parent to the end of current list
            currentNode.next = parentNodeNext;
            if (parentNodeNext != null) {
                parentNodeNext.prev = currentNode;
            }
            
            // Connect the parent node to the start of current list
            parentNode.next = currentListHead;
            
            if (parentNodeNext != null) {
                currentNode = parentNodeNext;   
            }
        }
        
        return head;
    }
}