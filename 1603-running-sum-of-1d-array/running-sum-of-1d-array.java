class Solution {
    public int[] runningSum(int[] nums) {
        int lastValue = 0;
        final var result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            final var value = nums[i];
            lastValue += value;
            result[i] = lastValue; 
        }

        return result;
    }
}