class Solution {
    public int[] replaceElements(int[] arr) {
        
        if (arr == null) {
            return arr;
        }
        
        if (arr.length == 1) {
            return new int[] { -1 };
        }
        
        final var endIndex = arr.length - 1;
        int maxValue = arr[endIndex];
        
        for (int i = endIndex; i >= 0; i--) {
            
            final var temp = arr[i];
            arr[i] = maxValue;
            
            maxValue = Math.max(temp, maxValue);
        }
        
        arr[endIndex] = -1;
        
        return arr;
    }
}