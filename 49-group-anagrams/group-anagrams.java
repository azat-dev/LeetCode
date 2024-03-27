class Solution {
    
    private String sortString(String value) {
        final var chars = value.toCharArray();
        Arrays.sort(chars);
        
        return new String(chars);
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        final var groups = new HashMap<String, List<String>>();
        
        for (var value : strs) {
            
            final var key = sortString(value);
            final var existingGroup = groups.get(key);
            
            if (existingGroup != null) {
                existingGroup.add(value);
                continue;
            }
            
            final var newGroup = new LinkedList<String>();
            newGroup.add(value);
            
            groups.put(key, newGroup);
        }
        
        final var resultArray = (List<String>[]) groups.values().toArray(new List[0]);
        return Arrays.asList(resultArray);
    }
}