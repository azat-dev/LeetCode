class Solution {

    func cleanString(_ string: String) -> String {

        var result = ""

        for character in string.lowercased() {

            if character.isNumber || character.isLetter {
                result.append(character)
            }
        }

        return result
    }


    func isPalindrome(_ s: String) -> Bool {
        
        let cleanedString = cleanString(s)
        var reverseIndex = cleanedString.endIndex

        for character in cleanedString {
            
            reverseIndex = cleanedString.index(before: reverseIndex)

            if character != cleanedString[reverseIndex] {
                return false
            }
        }

        return true
    }
}