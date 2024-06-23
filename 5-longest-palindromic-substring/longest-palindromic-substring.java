class Solution {

    private boolean isPalindrome(String s, int startIndex, int endIndex) {
        for (int i = startIndex, j = endIndex - 1; i < j; i++, j--) {
            final var currentChar = s.charAt(i);
            final var reverseChar = s.charAt(j);
            
            if (currentChar != reverseChar) {
                return false;
            }
        }

        return true;
    }

    public String longestPalindrome(String s) {

        var maxPalindromeLength = 0;
        Pair<Integer, Integer> maxPalindrome = null;

        var maxIndexByMap = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {

            for (int j = s.length(); i < j; j--) {
                
                final var newLength = j - i;

                if (newLength > maxPalindromeLength && isPalindrome(s, i, j)) {
                    maxPalindromeLength = newLength;
                    maxPalindrome = new Pair<>(i, j);
                }
            }    
        }

        if (maxPalindromeLength == 0) {
            return "";
        }

        return s.substring(maxPalindrome.getKey(), maxPalindrome.getValue());
    }
}