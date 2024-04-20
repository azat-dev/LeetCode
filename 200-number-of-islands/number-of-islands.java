class Solution {
    
    private record Position(int row, int col) {}
    
    private void putIslandCells(char[][] grid, int rowIndex, int colIndex, Set<Position> islandCells) {
        if (rowIndex < 0 || rowIndex >= grid.length) {
            return;
        }
        
        if (colIndex < 0 || colIndex >= grid[rowIndex].length) {
            return;
        }
        
        final var value = grid[rowIndex][colIndex];
        
        if (value == '0') {
            return;
        }
        
        if (!islandCells.add(new Position(rowIndex, colIndex))) {
            return;
        }
        
        putIslandCells(grid, rowIndex + 1, colIndex, islandCells);
        putIslandCells(grid, rowIndex - 1, colIndex, islandCells);
        putIslandCells(grid, rowIndex, colIndex + 1, islandCells);
        putIslandCells(grid, rowIndex, colIndex - 1, islandCells);
    }
    
    public int numIslands(char[][] grid) {
        
        var count = 0;
        
        final var foundIslandCells = new HashSet<Position>();
        
        for(int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            for (int colIndex = 0; colIndex < grid[rowIndex].length; colIndex++) {
                
                final var islandCells = new HashSet<Position>();
                putIslandCells(grid, rowIndex, colIndex, islandCells);
                
                if (islandCells.isEmpty()) {
                    continue;
                }
                
                islandCells.removeAll(foundIslandCells);
                
                if (islandCells.isEmpty()) {
                    continue;
                }
                
                foundIslandCells.addAll(islandCells);
                count++;
            }
        }
        
        return count;
    }
}