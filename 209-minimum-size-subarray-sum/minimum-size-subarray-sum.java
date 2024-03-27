class Solution {
    
    // [1, 1, 1, 1  [4], 2, 2, 2,2, 1, 1, 1, 1]
    // 5
// [1, 1, 2, 1,  10]
    public int minSubArrayLen(int target, int[] arr) {
        
        var minLength = arr.length + 1;
        var sum = 0;
        
        for (int i = 0, j = -1; j < arr.length;) {
            
            if (sum < target) {
                
                j++;
                if (j >= arr.length) {
                    break;
                }
                
                sum += arr[j];
                continue;
            }
            
            final var length = j - i + 1;
            minLength = Math.min(length, minLength);
            
            if (minLength == 1) {
                return minLength;
            }
            
            sum -= arr[i];
            i++;
        }
        
        return minLength == arr.length + 1 ? 0 : minLength;
    }
}