import java.util.ArrayList;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        final var numOfRows = matrix.length;
        final var numOfCols = matrix[0].length;
        final var length = numOfRows * numOfCols;
    
        final var result = new ArrayList<Integer>(length);
        var col = 0;
        var row = 0;
        
        var rowStep = 0;
        var colStep = 1;
        
        var leftBoundary = -1;
        var rightBoundary = numOfCols;
        var topBoundary = -1;
        var bottomBoundary = numOfRows;
        
        while (col > leftBoundary &&  col < rightBoundary && row > topBoundary && row < bottomBoundary) {
            
            result.add(matrix[row][col]);
            
            final var nextRow = row + rowStep;
            final var nextCol = col + colStep;
            
            if (nextCol >= rightBoundary) {
            
                topBoundary += 1;
                colStep = 0;
                rowStep = 1;
            
            } else if (nextRow >= bottomBoundary) {
                
                rightBoundary -= 1;
                colStep = -1;
                rowStep = 0;
            
            } else if (nextCol <= leftBoundary) {
                
                bottomBoundary -= 1;
                rowStep = -1;
                colStep = 0;
            
            } else if (nextRow <= topBoundary) {
                
                leftBoundary += 1;
                rowStep = 0;
                colStep = 1;
            }
            
            row += rowStep;
            col += colStep;
        }
        
        return result;
    }
}