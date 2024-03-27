class Solution {

    private static let brackets = Set<Character>(["[", "]", "(", ")", "{", "}"])

    private func isBracket(_ ch: Character) -> Bool {
        return Self.brackets.contains(ch)
    }

    func isValid(_ s: String) -> Bool {
        
        var stack = [Character]()

        let closeOpenBracketsMapping: [Character: Character] = [
            ")": "(",
            "]": "[",
            "}": "{"
        ]

        for character in s where isBracket(character) {

            let bracket = character
            let openBracketForCurrentType = closeOpenBracketsMapping[bracket]

            guard let openBracketForCurrentType = openBracketForCurrentType else {
                stack.append(bracket)
                continue
            }

            guard let lastBracket = stack.last else {
                stack.append(bracket)
                continue
            }

            let isLastBracketOpen = (lastBracket == openBracketForCurrentType)

            if isLastBracketOpen {
                stack.removeLast()
                continue
            }

            stack.append(bracket)
        }

        return stack.isEmpty
    }
}