class Solution {
    public int romanToInt(String s) {

        Map<Character, Integer> digitsByRoman = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );

        var result = 0;
        var lastMaxDigit = -1;

        for (int i = s.length() - 1; i >= 0; i--) {

            final var roman = s.charAt(i);
            final var digit = digitsByRoman.get(roman);

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