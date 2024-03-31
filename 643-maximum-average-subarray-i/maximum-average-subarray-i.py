class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        
        items_sum = 0
        j = 0
        max_average = None

        for i in range (0, len(nums)):
            value = nums[i]
            items_sum += value

            if i >= k - 1:
                average = items_sum / k

                if max_average is None or average > max_average:
                    max_average = average

            if i >= k - 1:
                items_sum -= nums[j]
                j += 1

        return max_average
