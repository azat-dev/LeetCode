class Solution {
    
    private String getCommonPrefix(String str1, String str2) {
    
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < str1.length() && i < str2.length(); i++) {
            
            final var ch = str1.charAt(i);
            
            if (ch != str2.charAt(i)) {
                break;
            }

            sb.append(ch);
        }
        
        return sb.toString();
    }
    
    public String longestCommonPrefix(String[] strs) {
        
        var maxCommonPrefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            
            final var str = strs[i];
            maxCommonPrefix = getCommonPrefix(str, maxCommonPrefix);
            
            if (maxCommonPrefix.length()  == 0) {
                break;
            }
        }
        
        return maxCommonPrefix;
    }
}