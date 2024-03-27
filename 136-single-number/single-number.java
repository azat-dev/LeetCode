class Solution {
    public int singleNumber(int[] nums) {
        
        final var existingNums = new HashSet<Integer>();
        
        for (var num : nums) {
            
            if (existingNums.contains(num)) {
                existingNums.remove(num);
                continue;
            }
            
            existingNums.add(num);
        }
        
        for (var x : existingNums) {
            return x;
        }
        
        return -1;
    }
}