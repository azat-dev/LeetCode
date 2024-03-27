class Solution {
    func countBits(_ n: Int) -> [Int] {
        
        var result = [Int]()
        result.reserveCapacity(n + 1)

        for i in 0...UInt(n) {

            var digit = i
            var number_of_ones = 0

            while digit != 0 {

                if digit & 1 == 1 {
                    number_of_ones += 1
                }

                digit = digit >> 1
            }

            result.append(number_of_ones)
        }

        return result
    }
}