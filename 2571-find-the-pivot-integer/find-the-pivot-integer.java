class Solution {
    public int pivotInteger(int n) {
        
        final int total = n * (n + 1) / 2;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            
            sum += i;

            if (total - sum + i == sum) {
                return i;
            }
        }

        return -1;
    }
}