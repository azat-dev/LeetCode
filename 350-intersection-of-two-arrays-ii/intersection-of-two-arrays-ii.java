class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        final var map = new HashMap<Integer, Integer>();
        for(var x : nums1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        
        final var list = new LinkedList<Integer>();
        
        for (var x : nums2) {
            
            final var n = map.getOrDefault(x, 0);
            
            if (n == 0) {
                continue;
            }
            
            list.add(x);
            map.put(x, n - 1);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}