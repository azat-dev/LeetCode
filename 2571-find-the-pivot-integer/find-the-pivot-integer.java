class Solution {
    public int pivotInteger(int n) {
        
        int total = 0;

        for (int i = 1; i <= n; i++) {
            total += i;
        }

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