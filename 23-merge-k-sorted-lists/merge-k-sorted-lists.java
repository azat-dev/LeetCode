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

    private ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        if (start + 1 == end) {
            return merge(lists[start], lists[end]);
        }

        final var mid = (start + end) / 2;
        final var a = merge(lists, start, mid);
        final var b = merge(lists, mid + 1, end);

        return merge(a, b);
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        return merge(lists, 0, lists.length - 1);
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