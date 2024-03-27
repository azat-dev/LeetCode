class Solution {

    // Time complexity: O(n * x)
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        final var indexesOfNums = new HashMap<Integer, List<Integer>>(10000);
        
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            
            final var currentValue = nums[currentIndex];
            final var indexesForCurrentValue = indexesOfNums.get(currentValue);

            if (indexesForCurrentValue == null) {

                final var newList = new LinkedList<Integer>();
                newList.add(currentIndex);

                indexesOfNums.put(currentValue, newList);
                continue;
            } 

            final var iterator = indexesForCurrentValue.iterator();
            
            while (iterator.hasNext()) {

                final var prevIndex = iterator.next();

                if (currentIndex - prevIndex > k) {
                    iterator.remove();
                    continue;
                }

                return true;
            }

            indexesForCurrentValue.add(currentIndex);
            indexesOfNums.put(currentValue, indexesForCurrentValue);
        }
        
        return false;
    }
}