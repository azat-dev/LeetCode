class Solution {
    func search(_ nums: [Int], _ target: Int) -> Int {
        
        var left = 0
        var right = nums.count - 1

        while left <= right {

            let mid = (right - left) / 2 + left

            if nums[mid] == target {
                return mid
            }

            if nums[mid] < target {
                left = mid + 1
                continue
            }

            right = mid - 1
        }

        return -1
    }
}