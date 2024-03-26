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
    public ListNode oddEvenList(ListNode head) {
        
        if (head == null) {
            return null;
        }
        
        ListNode lastOddNode = head;
        ListNode evenHead = head.next;
        
        var currentNode = evenHead == null ? null : evenHead.next;
        var prevNode = evenHead;
        var isOdd = true;
        
        while (currentNode != null) {
            
            final var nextNode = currentNode.next;
            
            if (isOdd) {
                // Remove from the list
                prevNode.next = nextNode;
                
                // Put into the odd group
                lastOddNode.next = currentNode;
                lastOddNode = currentNode;
                
                // Append the even group
                lastOddNode.next = evenHead;
            } else {
                prevNode = currentNode;
            }
            
            // Move to the next node
            currentNode = nextNode;
            isOdd = !isOdd;
        }
        
        return head;
    }
}