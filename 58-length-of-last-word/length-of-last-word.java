class Solution {
    public int lengthOfLastWord(String s) {
        
        int wordEndIndex = -1;
        int wordStartIndex = -1;

        for (int i = s.length() - 1; i >= 0; i--) {
            
            final var ch = s.charAt(i);
            final var isSpace = (ch == ' ');
            
            if (isSpace) {
                if (wordEndIndex == -1) {
                    continue;
                } 

                break;
            }

            if (wordEndIndex == -1) {
                wordEndIndex = i + 1;
            }

            wordStartIndex = i;
        }

        return wordEndIndex - wordStartIndex;
    }
}