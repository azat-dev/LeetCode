# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        if not l1 or not l2:
            return l1 or l2
        
        head, prev_node = None, None
        carry = 0
        
        pointer1, pointer2 = l1, l2
        
        while carry > 0 or pointer1 or pointer2:
            
            sum = carry
            
            if pointer1:
                sum += pointer1.val
                pointer1 = pointer1.next
                
            if pointer2:
                sum += pointer2.val
                pointer2 = pointer2.next
            
            carry = sum // 10
            
            new_node = ListNode(val=sum % 10)
            
            if prev_node:
                prev_node.next = new_node
            else:
                head = new_node
                
            prev_node = new_node
        
        return head