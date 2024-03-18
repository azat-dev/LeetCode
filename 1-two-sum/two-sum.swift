class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        
        guard nums.count > 1 else {
            return []
        }

        var indexesByValues = [Int: Int]()

        for index in 0..<nums.count {

            let value = nums[index]
            indexesByValues[value] = index
        }

        for i in 0..<nums.count {
            
            let a = nums[i]
            let b = target - a

            guard 
                let j = indexesByValues[b],
                i != j
            else {
                continue
            }

            return [i, j]
        }

        return []
    }
}