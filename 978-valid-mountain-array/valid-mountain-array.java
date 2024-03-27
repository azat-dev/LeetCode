class Solution {
    public boolean validMountainArray(int[] arr) {
        
        if (arr.length < 3) {
            return false;
        }
        
        var maxValueIndex = 0;
        
        // Climbing
        for (int i = 1; i < arr.length; i++) {
            
            if (arr[i - 1] < arr[i]) {
                maxValueIndex = i;
                continue;
            }
            
            if (arr[i - 1] == arr[i]) {
                return false;
            }
            
            break;
        }
        
        if (maxValueIndex <= 0 || maxValueIndex == arr.length - 1) {
            return false;
        }
        
        // Downhill
        for (int i = maxValueIndex; i < arr.length - 1; i++) {
            
            if (arr[i] > arr[i+ 1]) {
                continue;
            }
            
            return false;
        }
        
        return true;
    }
}