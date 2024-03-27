class Solution {
    func runningSum(_ nums: [Int]) -> [Int] {
        
        var prevSum = 0
        var results = [Int]()
        results.reserveCapacity(nums.count)

        for num in nums {

            prevSum += num
            results.append(prevSum)
        }

        return results
    }
}