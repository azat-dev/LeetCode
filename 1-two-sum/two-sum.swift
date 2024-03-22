class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        
        var indexesByNums = Dictionary<Int, Int>()

        for i in 0..<nums.count {
            
            let currentValue = nums[i]
            let complimentaryNumber = target - currentValue

            if let indexOfComplimentaryNumber = indexesByNums[complimentaryNumber] {
                return [i, indexOfComplimentaryNumber]
            }

            indexesByNums[currentValue] = i
        }

        return []
    }
}