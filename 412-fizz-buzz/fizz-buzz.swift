class Solution {

    private func getItem(for itemIndex: Int) -> String {

        if itemIndex % 3 == 0 && itemIndex % 5 == 0 {
            return "FizzBuzz"
        }

        if itemIndex % 3 == 0 {
            return "Fizz"
        }

        if itemIndex % 5 == 0 {
            return "Buzz"
        }

        return String(itemIndex)
    }

    func fizzBuzz(_ n: Int) -> [String] {
        
        return (1...n).map { self.getItem(for: $0) }
    }
}