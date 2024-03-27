class Solution {
    
    
    public int[] findDiagonalOrder(int[][] mat) {
        
        final var numberOfRows = mat.length;
        final var numberOfCols = mat[0].length;
        final var numberOfItems = numberOfRows * numberOfCols;
        
        int[] result = new int[numberOfItems];
        
        int i = 0;
        int row = 0;
        int col = 0;
        boolean goesUp = true;
        
        while (i < numberOfItems) {
            
            result[i] = mat[row][col];
            i++;
            
            final var rowStep = goesUp ? -1 : 1;
            final var colStep = goesUp ? 1 : -1;
            
            final var nextRow = row + rowStep;
            final var nextCol = col + colStep;
            
            // Go up
            if (goesUp) {
                
                if (nextRow < 0) {
                    
                    goesUp = false;
                    
                    if (nextCol >= numberOfCols) {
                        row +=1;
                        continue;
                    }
                    
                    row = 0;
                    col += 1;
                    continue;
                }
                
                if (nextCol >= numberOfCols) {
                    
                    goesUp = false;
                    row +=1;
                    continue;
                }
                
            } else {
                
                if (nextCol < 0) {
                    
                    goesUp = true;
                    
                    if (nextRow >= numberOfRows) {
                        col += 1;
                        continue;
                    }
                    
                    row +=1;
                    continue;
                }
                
                if (nextRow >= numberOfRows) {
                    
                    goesUp = true;
                    col += 1;
                    continue;
                }
                
            }
            
            row = nextRow;
            col = nextCol;
        }
        
        return result;
    }
}