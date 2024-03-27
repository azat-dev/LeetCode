class Solution {
    func numberOfSteps(_ num: Int) -> Int {
        
        var currentValue = num
        var steps = 0

        while currentValue > 0 {

            steps += 1
            
            if currentValue % 2 == 0 {
                
                currentValue /= 2
                continue
            }

            currentValue -= 1
        }

        return steps
    }
}