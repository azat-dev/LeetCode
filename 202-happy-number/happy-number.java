class Solution {

    private static int calcSum(int n) {
        
        int sum = 0;

        while (n > 0) {
            final var digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public boolean isHappy(int n) {

        int slowSum = n;
        int fastSum = n;

        do {

            slowSum = calcSum(slowSum);
            fastSum = calcSum(calcSum(fastSum));

            if (slowSum == 1 || fastSum == 1) {
                return true;
            }

        } while (slowSum != fastSum);

        return false;
    }
}