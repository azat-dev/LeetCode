class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        // if (list1.length < list2.length) {
        //     final var temp = list1;
        //     list1 = list2;
        //     list2 = temp;
        // }
        
        final var list1Indexes = new HashMap<String, Integer>(list1.length);
        
        for (int i = 0; i < list1.length; i++) {    
            list1Indexes.putIfAbsent(list1[i], i);
        }
        
        final var result = new LinkedList<String>();
        var minSum = list1.length + list2.length;
        
        for (int i = 0; i < list2.length && i <= minSum; i++) {
            
            final var currentItem = list2[i];
            final var mappedIndex = list1Indexes.get(currentItem);
            
            if (mappedIndex == null) {
                continue;
            }
            
            final var sum = i + mappedIndex;
            
            if (sum > minSum) {
                break;
            }
            
            if (sum < minSum) {
                result.clear();
            }
            
            minSum = sum;
            result.add(currentItem);
        }
        
        return result.toArray(new String[0]);
    }
}