class Solution {
    private record Position(int row, int col) {}

    private boolean isWordExist(
        char[][] board, 
        String word,
        int wordStartIndex,
        Position startPosition,
        Set<Position> seen
    ) {

        final var ch = word.charAt(wordStartIndex);

        if (ch != board[startPosition.row][startPosition.col]) {
            return false;
        }

        if (wordStartIndex == word.length() - 1) {
            return true;
        }

        seen.add(startPosition);

        final var newWordStartIndex = wordStartIndex + 1;

        for (int offset = -1; offset <= 1; offset += 2) {
            
            final var position = new Position(startPosition.row, startPosition.col + offset);

            if (
                position.row < 0 || 
                position.col < 0 ||
                position.row >= board.length ||
                position.col >= board[position.row].length ||
                seen.contains(position)
            ) {
                continue;
            }

            if (isWordExist(board, word, newWordStartIndex, position, seen)) {
                return true;
            }
        }

        for (int offset = -1; offset <= 1; offset += 2) {
            
            final var position = new Position(startPosition.row + offset, startPosition.col);

            if (
                position.row < 0 || 
                position.col < 0 ||
                position.row >= board.length ||
                position.col >= board[position.row].length ||
                seen.contains(position)
            ) {
                continue;
            }

            if (isWordExist(board, word, newWordStartIndex, position, seen)) {
                return true;
            }
        }

        seen.remove(startPosition);
        return false;
    }

    public boolean exist(char[][] board, String word) {

        final var boardWidth = board[0].length;
        final var boardSize = board.length * boardWidth;
        
        if (word.length() > boardSize) {
            return false;
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {

                final var seen = new HashSet<Position>();
                
                if (
                    isWordExist(
                        board, 
                        word, 
                        0, 
                        new Position(row, col),
                        seen
                    )
                ) {
                    return true;
                }
            }
        }

        return false;
    }
}