import java.util.Arrays;

class Solution {
    public int maximumWealth(int[][] accounts) {
        
        return Arrays.stream(accounts)
            .map(customerAccounts -> Arrays.stream(customerAccounts).sum())
            .max(Integer::compareTo)
            .orElse(0);
    }
}