class Solution {
    public int maxProfit(int[] prices) {

        var currentMaxProfit = 0;
        var prevMinValue = -1;

        for (int i = 0; i < prices.length; i++) {
            
            final var currentValue = prices[i];
            
            if (prevMinValue != -1) {
                final var profit = currentValue - prevMinValue;

                if (profit > currentMaxProfit) {
                    currentMaxProfit = profit;
                }
            }

            if (prevMinValue == -1 || currentValue < prevMinValue) {
                prevMinValue = currentValue;
            }
        }

        return currentMaxProfit;
    }
}