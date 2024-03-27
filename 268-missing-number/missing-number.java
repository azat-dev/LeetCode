class Solution {
    public int missingNumber(int[] nums) {
        
        int n = nums.length;
        int sum = n * (1 + n) / 2;
        var hasZero = false;

        for (int i = 0; i < n; i++) {
            final var value = nums[i];
            if (value == 0) {
                hasZero = true;
            }

            sum -= value;
        }

        if (!hasZero) {
            return 0;
        }

        return sum;
    }
}