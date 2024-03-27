class Solution {
    func isAnagram(_ s: String, _ t: String) -> Bool {
        
        // 1. Put all characters into Hash [Character: NumberOfCharacters]
        // 2. Loop through all characters in t
        // 3. Check that the character exists in our hash
        // 4. if not exists return false
        // 5. If it exists subtract 1 from corresponding value
        // 6. Repeat loop

        var allowedCharacters = s.reduce(into: [Character: Int]()) { acc, character in
            acc[character] = (acc[character] ?? 0) + 1
        }

        for character in t {

            guard 
                let numberOfCharacters = allowedCharacters[character],
                numberOfCharacters > 0
            else {
                return false
            }

            let newNumberOfCharacters = numberOfCharacters - 1

            if newNumberOfCharacters <= 0 {
                allowedCharacters.removeValue(forKey: character)
                continue
            }

            allowedCharacters[character] = newNumberOfCharacters
        }

        return allowedCharacters.isEmpty
    }
}