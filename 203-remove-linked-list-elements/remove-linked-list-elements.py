# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        if not head:
            return head
        
        prev_node = None
        current_node = head
        
        while current_node:

            if current_node.val != val:
                prev_node = current_node
                current_node = current_node.next
                continue
            

            # Remove the element
            if not prev_node:
                head = current_node.next
                current_node = head
                continue
            
            prev_node.next = current_node.next
            current_node = prev_node.next
        
        return head
