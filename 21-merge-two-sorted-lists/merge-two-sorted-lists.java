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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        var pointer1 = list1;
        var pointer2 = list2;
        
        ListNode prevNode = null;
        ListNode head = null;
        
        while (pointer1 != null || pointer2 != null) {
            
            ListNode node = null;
            
            if (pointer1 == null || pointer2 != null && pointer2.val < pointer1.val) {
                
                node = pointer2;
                pointer2 = pointer2.next;
            
            } else if (pointer2 == null || pointer1 != null && pointer1.val <= pointer2.val) {
                
                node = pointer1;
                pointer1 = pointer1.next;   
            }
            
            if (head == null) {
                head = node;   
            }
            
            if (prevNode != null) {
                prevNode.next = node;
            }
            
            node.next = null;
            prevNode = node;
        }
        
        return head;
    }
}