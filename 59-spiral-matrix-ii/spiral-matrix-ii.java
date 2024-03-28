class Solution {
    public int[][] generateMatrix(int n) {
        
        int value = 1;
        final var size = n * n;

        final var matrix = new int[n][n];

        var rowIndex = 0;
        var colIndex = 0;

        var rowStep = 0;
        var colStep = 1;

        while (value <= size) {

            matrix[rowIndex][colIndex] = value;
            value += 1;

            final var nextRowIndex = rowIndex + rowStep;
            final var nextColIndex = colIndex + colStep;

            if (
                nextRowIndex < n && 
                nextColIndex < n && 
                nextRowIndex >= 0 &&
                nextColIndex >= 0 &&
                matrix[nextRowIndex][nextColIndex] == 0
            ) {
                rowIndex = nextRowIndex;
                colIndex = nextColIndex;
                continue;
            }

            // Change direction
            if (colStep != 0) {
                rowStep = colStep > 0 ? 1 : -1;
                colStep = 0;
            } else {
                colStep = rowStep > 0 ? -1 : 1;
                rowStep = 0;
            }

            rowIndex += rowStep;
            colIndex += colStep;
        }

        return matrix;
    }
}