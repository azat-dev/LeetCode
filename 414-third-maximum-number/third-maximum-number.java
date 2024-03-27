class Solution {
    
    private void putValue(Integer[] maximums, int value) {
        
        for (int j = 0; j < maximums.length; j++) {

            final var currentMaximum = maximums[j];

            if (currentMaximum == null || value == currentMaximum) {
                maximums[j] = value;
                return;
            }

            if (value > currentMaximum) {
                maximums[j] = value;
                value = currentMaximum;
            }
        }
    }
    
    public int thirdMax(int[] nums) {
        
        final var maximums = new Integer[3];
        
        for (int i = 0; i < nums.length; i++) {
            putValue(maximums, nums[i]);
        }
        
        if (maximums[2] != null) {
            return maximums[2];
        }
        
        return maximums[0];
    }
}