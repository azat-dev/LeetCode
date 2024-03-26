# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return head
        
        current_node = head

        while current_node.next:
            new_head = current_node.next
            current_node.next = new_head.next
            new_head.next = head
            head = new_head

        return head    