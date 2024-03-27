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

        if (currentNode == null) {
            return null;
        }

        int size = 0;

        do {
            currentNode = currentNode.next;
            size++;
        } while (currentNode != null);

        int middleNodeIndex = size / 2;

        currentNode = head;

        for (int index = 0; currentNode.next != null; index++) {

            if (index == middleNodeIndex) {
                return currentNode;
            }            

            currentNode = currentNode.next;
        }

        return currentNode;
    }
}