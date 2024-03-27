class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        for (int i = 0; i < numbers.length; i++) {
            
            final var currentValue = numbers[i];
            final var secondValue = target - currentValue;
            
            if (secondValue > numbers[numbers.length - 1]) {
                continue;
            }
            
            if (secondValue < currentValue) {
                continue;
            }
            
            for (int j = i + 1; j < numbers.length; j++) {
            
                final var value = numbers[j];

                if (value == secondValue) {
                    return new int[] {i + 1, j + 1};
                }
                
                if (value > secondValue) {
                    break;
                }
                

            }
        }
        
        return new int[0];
    }
}