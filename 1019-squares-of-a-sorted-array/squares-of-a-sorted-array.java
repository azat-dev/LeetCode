class Solution {
    public int[] sortedSquares(int[] nums) {
        
        if (nums.length == 0) {
            return new int[0];
        }
        
        int[] result = new int[nums.length];
        int middleIndex = nums.length;
        
        for (int i = 0; i < nums.length; i++) {
            
            if (nums[i] >= 0) {
                middleIndex = i;
                break;
            }
        }
        
        int destIndex = 0;
        int positiveIndex = middleIndex;
        int negativeIndex = middleIndex - 1;
        
        while (true) {
            
            if (destIndex >= nums.length) {
                break;
            }
        
            int negativeSquare = -1;
            int positiveSquare = -1;
            
            if (positiveIndex < nums.length) {
                positiveSquare = nums[positiveIndex] * nums[positiveIndex];
            }
            
            if (negativeIndex >= 0) {
                negativeSquare = nums[negativeIndex] * nums[negativeIndex];
            }
            
            final var shouldPutPositive = negativeSquare == -1 || positiveSquare != -1 && positiveSquare <= negativeSquare;
            result[destIndex] = shouldPutPositive ? positiveSquare : negativeSquare;
            destIndex++;
            
            if (shouldPutPositive) {
                positiveIndex++;
                continue;
            }
            
            negativeIndex--;
        }
        
        return result;
    }
}