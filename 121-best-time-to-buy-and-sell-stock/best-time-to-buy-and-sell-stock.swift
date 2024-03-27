class Solution {

    func maxProfit(_ prices: [Int]) -> Int {

        guard prices.count > 1 else {
            return 0
        }

        var prevMaxPrice = -1
        var maxProfit = -1
        let lastIndex = prices.count - 1

        for priceIndex in stride(from: lastIndex - 1, through: 0, by: -1) {

            let currentPrice = prices[priceIndex]
            let nextFuturePrice = prices[priceIndex + 1]

            let maxPrice = max(
                nextFuturePrice,
                prevMaxPrice
            )

            let profit = maxPrice - currentPrice

            if profit > maxProfit {
                maxProfit = profit
            }

            prevMaxPrice = maxPrice
        }

        return maxProfit < 0 ? 0 : maxProfit
    }
}