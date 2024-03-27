class Solution {
    public int majorityElement(int[] nums) {
        
        final var freq = new HashMap<Integer, Integer>();
        var maxFrequency = -1;
        var maxFrequencyValue = -1;
        var leastNeededCount = nums.length / 2;

        for (int i = 0; i < nums.length; i++) {

            final var value = nums[i];
            final var newFrequency = freq.getOrDefault(value, 0) + 1;

            if (newFrequency > maxFrequency) {
                maxFrequency = newFrequency;
                maxFrequencyValue = value;
            }

            if (newFrequency > leastNeededCount) {
                return value;
            }

            freq.put(value, newFrequency);
        }

        return maxFrequencyValue;
    }
}