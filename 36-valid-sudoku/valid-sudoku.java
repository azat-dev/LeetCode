class Solution {

    public boolean isValidSudoku(char[][] board) {

        final var boxSize = 3;
        final var seen = new HashSet<Integer>(9 * 9);

        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {

            final var row = board[rowIndex];
            
            for (int colIndex = 0; colIndex < row.length; colIndex++) {

                final var boxCol = colIndex / boxSize;
                final var boxRow = rowIndex / boxSize;
                final var boxIndex = boxRow * boxSize + boxCol;
                
                if (row[colIndex] == '.') {
                    continue;
                }

                final int value = (row[colIndex] - '0');

                final var rowCode = ((rowIndex + 1) * 10) + value;
                if (!seen.add(rowCode)) {
                    return false;
                }

                final var colCode = ((colIndex + 1) * 1000) + value;
                if (!seen.add(colCode)) {
                    return false;
                }

                final var boxCode = ((boxIndex + 1) * 10000) + value;
                if (!seen.add(boxCode)) {
                    return false;
                }
            }
        }

        return true;
    }
}