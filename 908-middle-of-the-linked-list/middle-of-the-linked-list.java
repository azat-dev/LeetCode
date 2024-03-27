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
    public ListNode middleNode(ListNode head) {
        
        ListNode currentNode = head;
        ListNode fastNode = head;

        if (currentNode.next == null) {
            return currentNode;
        }

        while (fastNode != null && fastNode.next != null) {
            currentNode = currentNode.next;   
            fastNode = fastNode.next.next;
        }

        return currentNode;
    }
}