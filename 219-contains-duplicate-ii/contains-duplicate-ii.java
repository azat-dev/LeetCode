class Solution {

    // Time complexity: O(n)
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        final var lastIndexesByNums = new HashMap<Integer, Integer>(10000);
        
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            
            final var currentValue = nums[currentIndex];
            final var lastIndexOfCurrentValue = lastIndexesByNums.get(currentValue);

            if (lastIndexOfCurrentValue == null) {
                lastIndexesByNums.put(currentValue, currentIndex);
                continue;
            }

            if (currentIndex - lastIndexOfCurrentValue <= k) {
                return true;
            }

            lastIndexesByNums.put(currentValue, currentIndex);
        }
        
        return false;
    }
}