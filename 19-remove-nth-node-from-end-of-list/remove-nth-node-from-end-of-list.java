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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        var currentNode = head;
        
        var pointer1 = head;
        ListNode pointer2 = null;
        ListNode prevPointer2 = null;
        
        var count = 1;
        
        while (pointer1 != null) {
            
            pointer1 = pointer1.next;
            
            if (count == n) {
                prevPointer2 = pointer2;
                pointer2 = head;
            } else if (count > n) {
                prevPointer2 = pointer2;
                pointer2 = pointer2.next;
            }
            
            count++;
        }
        
        // Remove
        if (pointer2 == head) {
            return pointer2.next;
        }
        
        if (prevPointer2 != null) {
            prevPointer2.next = prevPointer2.next == null ? null : prevPointer2.next.next;
        }
        
        return head;
    }
}