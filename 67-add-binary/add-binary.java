class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder sb = new StringBuilder();
        
        final var aLength = a.length();
        final var bLength = b.length();
        final var maxLength = Math.max(aLength, bLength);
        
        var carry = false;
        
        for (int i = 0; carry || i < maxLength; i++) {
            
            char aChar = '0';
            char bChar = '0';
            char value = '0';
            
            if (i < aLength) {
                aChar = a.charAt(aLength - i - 1);
            }
            
            if (i < bLength) {
                bChar = b.charAt(bLength - i - 1);
            }
            
            if (aChar == '1' && bChar == '1') {
                
                if (carry) {
                    carry = true;
                    value = '1';
                } else {
                    value = '0';
                    carry = true;
                }
                
            } else if (aChar == '1' || bChar == '1') {
                
                if (carry) {
                    value = '0';
                    carry = true;
                } else {
                    value = '1';
                }
            } else {
                
                if (carry) {
                    value = '1';
                    carry = false;
                } else {
                    value = '0';
                }
            }
            
            sb.insert(0, value);
        }
        
        return sb.toString();
    }
}