class Solution {
    public int hammingDistance(int x, int y) {
        
        var result = x ^ y;
        var count = 0;

        while (result != 0) {
            
            count += result & 1;
            result >>= 1;
        }

        return count;
    }
}