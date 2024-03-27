class Solution {
    
    private int calcNumberOfDigits(int value) {
        int count = 0;
        
        while (value > 0) {
            value /= 10;
            count++;
        }
        
        return count;
    }
    
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int value : nums) {
            final var numberOfDigits = calcNumberOfDigits(value);
            
            if (numberOfDigits % 2 == 0) {
                count++;    
            }
        }
        
        return count;
    }
}