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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        var currentNode = head;
        
        while (currentNode.next != null) {
            
            final var newHead = currentNode.next;
            currentNode.next = newHead.next;
            newHead.next = head;
            head = newHead;
        }
        
        return head;
    }
}