class Solution {
    public int strStr(String haystack, String needle) {
        
        for (int i = 0; i < haystack.length(); i++) {
            
            if (haystack.length() - i < needle.length()) {
                return -1;
            }
            
            var isEqual = true;
            
            for (int j = 0; j < needle.length(); j++) {
                
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    isEqual = false;
                    break;
                }
            }
            
            if (isEqual) {
                return i;
            }
        }
        
        return -1;
    }
}
