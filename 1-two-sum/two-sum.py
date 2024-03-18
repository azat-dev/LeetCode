class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:

        n = len(nums)

        for i in range(n):
            val1 = nums[i]
            
            for j in range(i + 1, n):
                val2 = nums[j]
                needed_value = target - val1

                if val2 == needed_value:
                    return [i, j]
            