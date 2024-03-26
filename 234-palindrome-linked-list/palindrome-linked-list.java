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
    
    private int getLength(ListNode head) {
        
        var count = 0;
        
        while (head != null) {
            head = head.next;
            count++;
        }
        
        return count;
    }
    
    public boolean isPalindrome(ListNode head) {
    
        // Time Complexity: O(n)
        final var length = getLength(head);
        
        if (length == 1) {
            return true;
        }
        
        if (length == 2) {
            return head.val == head.next.val;
        }
        
        // Reverse the list and move to the pointer2
        // Time Complexity: O(n/2)
        
        final var leftSideLength = (length / 2);
        int i = 1;
        var currentNode = head;
        
        while (i < leftSideLength) {
            
            final var nextNode = currentNode.next;
            currentNode.next = nextNode.next;
            nextNode.next = head;
            head = nextNode;
            i++;
        }
        
        var pointer1 = head;
        var pointer2 = currentNode.next;
        
        if (length % 2 != 0) {
            pointer2 = pointer2.next;
        }
        
        // Compare values
        // Time Compexity: O(n/2)
        while (pointer2 != null) {
            
            if (pointer1.val != pointer2.val) {
                return false;
            }
            
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        
        return true;
    }
}