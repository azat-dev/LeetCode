class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        lastValues = set()
        for x in nums:
            if x in lastValues:
                return True
            lastValues.add(x)
        
        return False