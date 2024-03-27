class Solution {
    public int singleNumber(int[] nums) {
        
        var result = 0;
        
        for (var num : nums) {
            result ^= num;
        }
        
        return result;
    }
}