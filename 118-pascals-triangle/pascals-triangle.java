import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        final var result = new ArrayList<List<Integer>>(numRows);
        
        // We are going to iterate over all rows
        
        List<Integer> prevRow = null;
        
        for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
            
            final var n = rowIndex + 1;
            final var row = new ArrayList(n);
            
            for (int j = 0; j < n; j++) {
                
                if (j == 0 || j == n - 1) {
                    row.add(1);
                    continue;
                }
                
                if (prevRow == null) {
                    row.add(999);
                    continue;
                }
                
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            
            result.add(row);
            prevRow = row;
        }
        
        return result;
    }
}