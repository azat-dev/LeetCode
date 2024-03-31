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
    private ListNode findStartOfRightSide(ListNode head) {

        if (head == null) {
            return null;
        }

        var pointerSlow = head;
        var pointerFast = head;
        
        while(pointerFast != null && pointerFast.next != null) {
            pointerSlow = pointerSlow.next;
            pointerFast = pointerFast.next.next;
        }

        return pointerSlow;
    }

    public int pairSum(ListNode head) {

        if (head == null) {
            return -1;
        }
        
        final var rightSideStart = findStartOfRightSide(head);
        
        // Reverse the left side

        var currentNode = head;

        while (currentNode.next != null && currentNode.next != rightSideStart) {

            final var nextNode = currentNode.next;
            currentNode.next = nextNode.next;
            
            nextNode.next = head;
            head = nextNode;
        }

        // Find the max sum
        int sum = -1;

        var leftPointer = head;
        var rightPointer = rightSideStart;

        while (rightPointer != null) {

            final var newSum = leftPointer.val + rightPointer.val;
            if (sum < newSum) {
                sum = newSum;
            }

            rightPointer = rightPointer.next;
            leftPointer = leftPointer.next;
        }

        return sum;
    }
}