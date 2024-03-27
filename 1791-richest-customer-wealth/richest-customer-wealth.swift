class Solution {
    func maximumWealth(_ accounts: [[Int]]) -> Int {
        
        var maxWealth = 0

        for customerAccounts in accounts {

            var customerWealth = 0

            for amountInBank in customerAccounts {
                customerWealth += amountInBank
            }

            maxWealth = max(maxWealth, customerWealth)
        }

        return maxWealth
    }
}