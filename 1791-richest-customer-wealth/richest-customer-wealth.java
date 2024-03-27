class Solution {
    public int maximumWealth(int[][] accounts) {
        
        var result = 0;

        // We are going to iterate over all customers
        for(int[] customerAccounts: accounts) {

            // We need to store amount of current customer
            var currentCustomerWealth = 0;

            // We are going to iterate over all bank account of current customer

            for (int accountValue : customerAccounts) {
                currentCustomerWealth += accountValue;
            }

            result = Math.max(result, currentCustomerWealth);
        }

        return result;
    }
}