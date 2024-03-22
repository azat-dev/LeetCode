class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        final var existingValues = new HashSet();
        
        for (var num : nums) {
            
            if (existingValues.contains(num)) {
                return true;
            }
            
            existingValues.add(num);
        }
        
        return false;
    }
}