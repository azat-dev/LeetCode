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

    public ListNode deleteDuplicates(ListNode head) {

        ListNode prevNode = null;
        ListNode currentNode = head;

        while (currentNode != null) {

            final var value = currentNode.val;
            
            if (prevNode != null && prevNode.val == value) {
                prevNode.next = currentNode.next;
                currentNode = currentNode.next;
                continue;
            }

            prevNode = currentNode;
            currentNode = currentNode.next;
        }

        return head;
    }
}