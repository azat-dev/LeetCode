class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        left_side_product = 1
        prev_value = 1
        result = [0] * len(nums)

        for i in range(len(nums)):
            left_side_product *= prev_value
            result[i] = left_side_product
            prev_value = nums[i]
        
        right_side_product = 1

        for i in reversed(range(len(nums))):
            result[i] *= right_side_product
            right_side_product *= nums[i]

        return result