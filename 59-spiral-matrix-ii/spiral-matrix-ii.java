class Solution {
    public int[][] generateMatrix(int n) {
        final var size = n * n;
        final var matrix = new int[n][n];
        final var emptyValue = 0;

        // Setup the first value
        int value = 1;

        // Setup initial index
        var rowIndex = 0;
        var colIndex = 0;

        // Setup initial direction (from bottom to right)
        var rowStep = 0;
        var colStep = 1;

        while (value <= size) {

            matrix[rowIndex][colIndex] = value;
            value += 1;

            final var nextRowIndex = rowIndex + rowStep;
            final var nextColIndex = colIndex + colStep;

            final var isNextCellInsideOfBoundaries = (
                nextRowIndex < n && 
                nextColIndex < n && 
                nextRowIndex >= 0 &&
                nextColIndex >= 0
            );

            if (
                isNextCellInsideOfBoundaries &&
                matrix[nextRowIndex][nextColIndex] == emptyValue
            ) {
                // The next cell is inside of the boundaries
                rowIndex = nextRowIndex;
                colIndex = nextColIndex;
                continue;
            }

            // The next cell is outside of boundaries
            // Change direction
            if (colStep != 0) {
                // Use vertical direction now
                rowStep = colStep > 0 ? 1 : -1;
                colStep = 0;
            } else {
                // Use horizontal direction now
                colStep = rowStep > 0 ? -1 : 1;
                rowStep = 0;
            }

            // Move to the next cell
            rowIndex += rowStep;
            colIndex += colStep;
        }

        return matrix;
    }
}