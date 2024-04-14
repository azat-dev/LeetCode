# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True

        def _isBalanced(root):
            if not root:
                return (True, 0)
            
            left_result = _isBalanced(root.left)
            (is_left_balanced, left_height) = left_result
            
            if not is_left_balanced:
                return (False, 0)
            
            right_result = _isBalanced(root.right)
            (is_right_balanced, right_height) = right_result
            
            if not is_right_balanced:
                return (False, 0)
            
            return (
                abs(left_height - right_height) <= 1,
                max(left_height, right_height) + 1
            )
        
        (balanced, _) = _isBalanced(root)
        return balanced

        