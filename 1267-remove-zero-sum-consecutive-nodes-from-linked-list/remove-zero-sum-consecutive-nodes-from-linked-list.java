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

    public ListNode removeZeroSumSublists(ListNode head) {

        ListNode pointerBeforePointer1 = null;
        var pointer1 = head;

        while (pointer1 != null) {

            var pointer2 = pointer1;
            var sum = 0;

            while (pointer2 != null) {

                sum += pointer2.val;

                if (sum != 0) {
                    pointer2 = pointer2.next;
                    continue;
                }

                // remove sequence
                if (pointer1 == head || pointerBeforePointer1 == null) {
                    head = pointer2.next;
                    pointer2 = pointer2.next;
                    continue;
                }

                pointerBeforePointer1.next = pointer2.next;
                pointer2 = pointer2.next;
            }

            pointerBeforePointer1 = pointer1;
            pointer1 = pointer1.next;
        }

        return head;
    }
}