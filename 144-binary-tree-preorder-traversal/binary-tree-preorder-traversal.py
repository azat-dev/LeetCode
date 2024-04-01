# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def _preorderTraversal(self, root: Optional[TreeNode], arr: List[int]) -> List[int]:
        
        arr.append(root.val)
        
        if root.left:
            self._preorderTraversal(root.left, arr)
        
        if root.right:
            self._preorderTraversal(root.right, arr)
        
        return arr
    
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        return self._preorderTraversal(root, [])