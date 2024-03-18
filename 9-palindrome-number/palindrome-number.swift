class Solution {

    func numberToArrayOfDigits(_ x: Int) -> [Int] {

        var result = [Int]()
        var value = x

        repeat {

            let digit = value % 10
            result.append(digit)
            
            value = value / 10

        } while value != 0

        return result
    }

    func isPalindrome(_ x: Int) -> Bool {
        
        if x < 0 {
            return false
        }
        
        let digits = numberToArrayOfDigits(x)
        let numberOfItems = digits.count

        for index in 0..<numberOfItems {

            let reversedIndex = numberOfItems - index - 1

            if digits[index] != digits[reversedIndex] {
                return false
            }
        }

        return true
    }
}