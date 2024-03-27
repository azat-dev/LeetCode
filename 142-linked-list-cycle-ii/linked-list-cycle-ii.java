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
    public ListNode detectCycle(ListNode head) {
        
        var pointer = head;
        ListNode somePointInsideCycle = null;
        
        // For each node
        while (pointer != null) {
            
            // Check if is inside the loop
            var loopPointer = pointer.next;
            var fastLoopPointer = pointer.next;
            
            if (somePointInsideCycle != null) {
                loopPointer = somePointInsideCycle;
                fastLoopPointer = somePointInsideCycle;
            } 
            
            while (true) {
                
                // End of sequence
                if (loopPointer == null || fastLoopPointer == null || fastLoopPointer.next == null) {
                    return null;
                }
                
                // Current point is a start of the loop
                if (loopPointer == pointer || fastLoopPointer == pointer) {
                    return pointer;
                }
                
                loopPointer = loopPointer.next;
                fastLoopPointer = fastLoopPointer.next.next;
                
                // Cycle completed
                if (loopPointer == fastLoopPointer) {
                    somePointInsideCycle = loopPointer;
                    break;
                }
            }
            
            pointer = pointer.next;
        }
        
        return null;
    }
}