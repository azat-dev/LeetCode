/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    private final static ListNode next(ListNode node) {
        if (node == null) {
            return null;
        }
        
        return node.next;
    }
    
    public boolean hasCycle(ListNode head) {
        
        var slowPointer = head;
        var fastPointer = head;
        
        while (true) {
            
            slowPointer = next(slowPointer);
            fastPointer = next(next(fastPointer));
            
            if (fastPointer == null) {
                return false;
            }
            
            if (slowPointer == fastPointer) {
                return true;
            }
        }
    }
}