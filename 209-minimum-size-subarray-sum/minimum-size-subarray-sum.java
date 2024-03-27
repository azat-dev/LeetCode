class Solution {
    
    // [1, 1, 1, 1  [4], 2, 2, 2,2, 1, 1, 1, 1]
    // 5
// [1, 1, 2, 1,  10]
    public int minSubArrayLen(int target, int[] arr) {
        
        final var n = arr.length;
        var minLength = n + 1;
        var sum = 0;
        
        for (int i = 0, j = -1; j < n;) {
            
            final var length = j - i + 1;
            
            if (length > 0 && length >= minLength) {
                sum -= arr[i];
                i++;
                continue;
            }
            
            if (sum < target) {
                
                j++;
                if (j >= arr.length) {
                    break;
                }
                
                sum += arr[j];                
                continue;
            }
            
            if (length >= minLength) {
                continue;
            }
            
            minLength = length;
            
            if (minLength == 1) {
                break;    
            }
        }
        
        return minLength == n + 1 ? 0 : minLength;
    }
}