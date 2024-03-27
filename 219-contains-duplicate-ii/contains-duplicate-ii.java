class Solution {

    // 0, 1, 2 , 3 , 4
    // Time complexity: O(n)
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        final var seen = new HashSet<Integer>(1000);
        
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            
            final var currentValue = nums[currentIndex];
            final var seenBefore = !seen.add(currentValue);

            if (seenBefore) {
                return true;
            }

            if (currentIndex >= k) {
                // Remove old values
                seen.remove(nums[currentIndex - k]);
            }
        }
        
        return false;
    }
}