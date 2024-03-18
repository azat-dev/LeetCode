class Solution {
    public int maxArea(int[] height) {
        
        // min(height1 , height2) * distance_between heights

        var maxCapacity = 0;

        int i = 0;
        int j = height.length - 1;

        var leftHeight = -1;
        var rightHeight = -1;
        var width = -1;
        var containerHeight = -1;
        var capacity = -1;

        while (i < j) {

            leftHeight = height[i];
            rightHeight = height[j];
            width = j - i;
            
            containerHeight = leftHeight < rightHeight ? leftHeight : rightHeight;
            capacity = width * containerHeight;

            if (maxCapacity < capacity) {
                maxCapacity = capacity;
            }

            if (leftHeight <= rightHeight) {
                i++;
                continue;
            }

            j--;
        }

        return maxCapacity;
    }
}