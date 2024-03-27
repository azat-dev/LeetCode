# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def walkTree(self, root: Optional[TreeNode], callback: Any):
        if not root:
            return None
        
        left_hash = self.walkTree(root.left, callback)
        right_hash = self.walkTree(root.right, callback)
        
        hash = (
            root.val,
            left_hash,
            right_hash
        )
        
        callback(root, hash)
        return hash
            
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        duplicates = list()
        groups = dict()
        
        def addNodeToDict(node, hash):

            group = groups.setdefault(hash, set())

            if not group:
                group.add(node)
                return

            if len(group) == 1:
                group.add(node)
                duplicates.append(node)
                return
            
            
        self.walkTree(root, addNodeToDict)
        return duplicates
        
        