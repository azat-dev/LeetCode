class Solution {
    public int[] plusOne(int[] digits) {
        
        int carryOutValue = 1;
        
        for (int i = digits.length - 1; i >= 0; i--) {
            
            if (carryOutValue == 0) {
                return digits;
            }
            
            final var val = digits[i];
            final var sum = (val + carryOutValue);
            
            carryOutValue = sum / 10;
            digits[i] = sum % 10;
        }
        
        if (carryOutValue == 0) {
            return digits;
        }
        
        final var newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        
        return newDigits;
    }
}