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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        var node1 = l1;
        var node2 = l2;

        ListNode sumNode = null;
        ListNode sumHead = null;
        int carry = 0;

        while (node1 != null || node2 != null || carry > 0) {
            
            var sum = carry;

            if (node1 != null) {
                sum += node1.val;
            }

            if (node2 != null) {
                sum += node2.val;
            }

            carry = sum / 10;
            sum %= 10;

            final var newNode = new ListNode(sum);
            if (sumNode != null) {
                sumNode.next = newNode;
            }

            sumNode = newNode;

            if (sumHead == null) {
                sumHead = sumNode;
            }

            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
        }

        return sumHead;
    }
}