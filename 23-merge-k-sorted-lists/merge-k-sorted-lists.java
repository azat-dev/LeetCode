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

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        for (int i = lists.length - 1; i >= 1; i--) {
            final var l1 = lists[i];
            final var l2 = lists[i - 1];
            lists[i - 1] = merge(l1, l2);
        }

        return lists[0];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        }

        if (l1 == null) {
            return l2;
        }

        ListNode root = null;
        ListNode currentNode = null;

        while (l1 != null && l2 != null) {

            ListNode nextNode = null;
            
            if (l2.val < l1.val) {

                nextNode = l2;
                l2 = l2.next;

            } else {
                nextNode = l1;
                l1 = l1.next;
            }

            if (currentNode == null) {
                root = nextNode;
                currentNode = nextNode;
            } else {
                currentNode.next = nextNode;
                currentNode = nextNode;
            }
        }

        if (l2 != null) {
            currentNode.next = l2;
        }

        if (l1 != null) {
            currentNode.next = l1;
        }

        return root;
    }
}