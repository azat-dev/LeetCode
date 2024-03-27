class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        var currentSum = numbers[0] + numbers[numbers.length - 1];
        int i = 0;
        int j = numbers.length - 1;
        
        while (currentSum != target) {
            
            if (currentSum > target) {
                j--;
            } else {
                i++;
            }
            
            currentSum = numbers[i] + numbers[j];
        }
        
        return new int[] {i + 1, j + 1};
    }
}