class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        final var numberOfRows = mat.length;
        final var numberOfCols = mat[0].length;

        final var matrixSize1 = numberOfRows * numberOfCols;
        final var matrixSize2 = r * c;
        
        if (matrixSize1 != matrixSize2) {
            return mat;
        }

        if (numberOfRows == r && numberOfCols == c) {
            return mat;
        }

        final var newMatrix = new int[r][c];

        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            for (int colIndex = 0; colIndex < numberOfCols; colIndex++) {
                
                final var itemIndex = rowIndex * numberOfCols + colIndex;
                final var mappedRow = itemIndex / c;
                final var mappedCol = itemIndex % c;

                newMatrix[mappedRow][mappedCol] = mat[rowIndex][colIndex];
            }
        }

        return newMatrix;
    }
}