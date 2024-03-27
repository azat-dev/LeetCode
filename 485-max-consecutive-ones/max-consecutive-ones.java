class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int maxSequence = 0;
        int currentSequence = 0;
        
        for(int value : nums) {
            if (value == 0) {
                currentSequence = 0;
                continue;
            }
            
            currentSequence++;
            maxSequence = Math.max(currentSequence, maxSequence);
        }
        
        return Math.max(currentSequence, maxSequence);
    }
}