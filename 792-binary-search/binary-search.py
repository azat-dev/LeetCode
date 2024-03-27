class Solution:

    def _search(self, nums: List[int], target: int, from_index: int, to_index: int) -> int:

        if from_index > to_index:
            return -1

        if from_index == to_index: 
            if nums[from_index] == target:
                return from_index

            return -1

        middle_index = (to_index - from_index) // 2 + from_index
        middle_value = nums[middle_index]

        if middle_value == target:
            return middle_index

        if middle_value < target:
            return self._search(
                nums,
                target,
                middle_index + 1,
                to_index,
            )

        return self._search(
            nums,
            target,
            from_index,
            middle_index - 1,
        )

    def search(self, nums: List[int], target: int) -> int:
        return self._search(nums, target, 0, len(nums) - 1)