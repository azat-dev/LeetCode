# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return head
        
        even_head = head.next
        last_odd_node = head

        is_odd = True
        prev_node = even_head
        current_node = even_head.next if even_head else None

        while current_node:

            next_node = current_node.next

            if is_odd:
                # Move the node

                # Remove from the list
                prev_node.next = current_node.next

                # Put into the odd group
                last_odd_node.next = current_node
                last_odd_node = current_node
                last_odd_node.next = even_head
            else:
                prev_node = current_node
            

            # Move to the next
            is_odd = not is_odd
            current_node = next_node

        return head
