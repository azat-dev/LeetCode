/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode prevNode = null;
        var currentNode = head;
        
        while (currentNode != null) {
            
            if (currentNode.val != val) {
                prevNode = currentNode;
                currentNode = currentNode.next;
                continue;
            }
                
            // Remove the node
            if (prevNode == null) {
                
                head = currentNode.next;
                final var nextNode = currentNode.next;
                currentNode.next = null;
                currentNode = nextNode;
                continue;
            }
            
            prevNode.next = currentNode.next;
            currentNode.next = null;
            currentNode = prevNode.next;
        }
        
        return head;
    }
}