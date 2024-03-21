class Solution {
    public int removeDuplicates(int[] nums) {
    
        var indexOfLastUniqueValue = -1;
        var numberOfUniqueValues = 0;
        var prevValue = -1;
        
        for (int i = 0; i < nums.length; i++) {
            
            final var currentValue = nums[i];
            final var isUniqueValue = (i == 0) || (currentValue != prevValue);
            
            if (!isUniqueValue) {
                
                prevValue = currentValue;
                continue;
            }
                
            if (indexOfLastUniqueValue == -1) {

                indexOfLastUniqueValue = i;
                
            } else {
                int targetIndex = indexOfLastUniqueValue + 1;
                nums[targetIndex] = currentValue;
                indexOfLastUniqueValue = targetIndex;
            }

            numberOfUniqueValues++;
            prevValue = currentValue;
        }
        
        
        return numberOfUniqueValues;
    }
}