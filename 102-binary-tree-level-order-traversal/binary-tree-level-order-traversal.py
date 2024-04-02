# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def _levelOrder(self, root: Optional[TreeNode], level: int, levels: List[List[int]]) -> List[List[int]]:
        if not root:
            return levels
        
        if level >= len(levels):
            levels.append([])
            
        level_items = levels[level]
        
        level_items.append(root.val)
        
        if root.left:
            self._levelOrder(root.left, level + 1, levels)
            
        if root.right:
            self._levelOrder(root.right, level + 1, levels)
        
        return levels
        
        
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        return self._levelOrder(root, 0, [])