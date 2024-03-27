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
        existing_hashes = set()
        hashes_in_duplicates = set()
        
        def addNodeToDict(node, hash):
            
            
            if hash not in existing_hashes:
                existing_hashes.add(hash)
                return
                
            if hash in hashes_in_duplicates:
                return
            
            hashes_in_duplicates.add(hash)
            duplicates.append(node)
            
            
        self.walkTree(root, addNodeToDict)
        return duplicates
        
        