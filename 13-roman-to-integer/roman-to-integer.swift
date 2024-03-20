// 1.  Example: MDCLXIV
// 2. 
// 3.

class Solution {
    func romanToInt(_ string: String) -> Int {
        
        let decimalByRoman: [Character: Int] = [
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000
        ]

        var result = 0
        var lastDigit: Int?
        var lastDigitsSum = 0

        for index in string.indices  {

            let currentCharacter = string[index]
            guard let currentDigit = decimalByRoman[currentCharacter] else {
                return -1
            }

            guard let lastDigitUnwrapped = lastDigit else {
                lastDigit = currentDigit
                lastDigitsSum = currentDigit
                continue
            }

            if lastDigitUnwrapped == currentDigit {
                
                lastDigitsSum += currentDigit
            
            } else if lastDigitUnwrapped < currentDigit {
                
                result -= lastDigitsSum
                lastDigitsSum = currentDigit
                
            } else {

                result += lastDigitsSum
                lastDigitsSum = currentDigit
            }

            lastDigit = currentDigit
        }

        result += lastDigitsSum
        return result
    }
}