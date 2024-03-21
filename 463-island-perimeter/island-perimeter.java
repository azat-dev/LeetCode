class Solution {

    public int islandPerimeter(int[][] grid) {
        
        final var gridHeight = grid.length;

        var perimeter = 0;
        var lastRowIndexWithIsland = -1;

        for (int row_index = 0; row_index < gridHeight; row_index++) {

            final var row = grid[row_index];
            final var gridWidth = row.length;
            var bottomEdgesCount = 0;
            var islandsCountInRow = 0;

            for (int col_index = 0; col_index < gridWidth; col_index++) {

                if (grid[row_index][col_index] == 0) {
                    continue;
                }
                
                islandsCountInRow++;

                final var hasTopEdge = (row_index == 0) || (grid[row_index - 1][col_index] == 0);
                if (hasTopEdge) {
                    perimeter += 1;
                }

                final var hasLeftEdge = (col_index == 0) || (row[col_index - 1] == 0);
                if (hasLeftEdge) {
                    perimeter += 1;
                }

                final var hasRightEdge = (col_index == gridWidth - 1) || (row[col_index + 1] == 0);
                if (hasRightEdge) {
                    perimeter += 1;
                }

                final var hasBottomEdge = (row_index == gridHeight - 1) || (grid[row_index + 1][col_index] == 0);
                if (hasBottomEdge) {
                    perimeter += 1;
                    bottomEdgesCount++;
                }
            }

            if (islandsCountInRow > 0 && islandsCountInRow == bottomEdgesCount) {
                return perimeter;
            }
        }

        return perimeter;
    }
}