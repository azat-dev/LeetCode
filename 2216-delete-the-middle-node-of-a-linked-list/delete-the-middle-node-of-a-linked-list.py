# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return head

        prev_pointer1 = None
        pointer1 = head
        pointer2 = head

        while pointer2 and pointer2.next:
            prev_pointer1 = pointer1
            pointer1 = pointer1.next
            pointer2 = pointer2.next.next
        
        if pointer1 is head:
            return head.next

        prev_pointer1.next = pointer1.next
        return head