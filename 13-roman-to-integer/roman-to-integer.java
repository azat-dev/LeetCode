class Solution {
    final static int romanToDigit(char roman) {
        switch (roman) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                throw new RuntimeException("Wrong value");
        }
    }
    
    public int romanToInt(String s) {

        var result = 0;
        var lastMaxDigit = -1;

        for (int i = s.length() - 1; i >= 0; i--) {

            final var roman = s.charAt(i);
            final var digit = romanToDigit(roman);

            if (digit >= lastMaxDigit) {
                result += digit;
            } else {
                result -= digit;
            }

            if (lastMaxDigit < digit) {
                lastMaxDigit = digit;
            }
        }

        return result;
    }
}