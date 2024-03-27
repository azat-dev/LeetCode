class Solution {

    // Time complexity: O(n)
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        final var lastIndexesByNums = new HashMap<Integer, Integer>(1000);
        
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

            if (currentIndex % 1000 == 0) {

                // Clean unused values
                final var iterator = lastIndexesByNums.values().iterator();

                while (iterator.hasNext()) {

                    final var index = iterator.next();
                    
                    if (currentIndex - index > k) {
                        iterator.remove();
                    }
                }
            }
        }
        
        return false;
    }
}