class Solution {

    public int islandPerimeter(int[][] grid) {
        
        final var gridHeight = grid.length;
        final var gridWidth = grid[0].length;

        var count = 0;
        var endColIndex = gridWidth - 1;
        var endRowIndex = gridHeight - 1;

        var lastRowWithIsland = -1;
        
        for (int rowIndex = 0; rowIndex < gridHeight; rowIndex++) {

            final var row = grid[rowIndex];

            for (int colIndex = 0; colIndex < gridWidth; colIndex++) {

                final var value = row[colIndex];

                if (value == 0) {
                    continue;
                }

                lastRowWithIsland = rowIndex;
                count += 4 * value;

                if (rowIndex > 0) {
                    count -= 2 * grid[rowIndex - 1][colIndex];
                }
                
                if (colIndex > 0) {
                    count -= 2 * row[colIndex - 1];
                }
            }

            if (lastRowWithIsland != -1 && lastRowWithIsland < rowIndex - 1) {
                break;
            }
        }

        return count;
    }
}