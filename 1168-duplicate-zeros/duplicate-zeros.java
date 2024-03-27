class Solution {
    private void shiftValues(int[] arr, int startIndex, int offset) {
        
        for (int i = arr.length - 1; (i - offset) >= startIndex ; i--) {
            arr[i] = arr[i - offset];
        }
    }
    
    public void duplicateZeros(int[] arr) {
        // We are going to iterate over all items in the array
        for (int i = 0; i < (arr.length - 1); i++) {
            
            final var currentValue = arr[i];
            
            if (currentValue != 0) {
                continue;
            }
            
            // The current value is zero
            // Duplicate zero
            shiftValues(arr, i + 1, 1);
            arr[i + 1] = 0;
            i++;
        }
    }
}