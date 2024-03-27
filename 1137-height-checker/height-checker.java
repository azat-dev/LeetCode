import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {
        
        final var sortedArray = Arrays.copyOf(heights, heights.length);
        Arrays.sort(sortedArray);
        
        var count = 0;
        
        for (int i = 0; i < heights.length; i++) {
            
            if (heights[i] != sortedArray[i]) {
                count++;
            }
        }
        
        return count;
    }
}