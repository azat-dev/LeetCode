class Solution {

    private class CharInfo {

        Set<Integer> seenAtRow;
        Set<Integer> seenAtCol;
        Set<Integer> seenAtBox;

        CharInfo() {
            this.seenAtRow = new HashSet(9);
            this.seenAtCol = new HashSet(9);
            this.seenAtBox = new HashSet();
        }
    }

    public boolean isValidSudoku(char[][] board) {
        
        final var boxSize = 3;
        final var seen = new HashMap<Character, CharInfo>(9);

        for (int rowIndex = 0; rowIndex < board.length; rowIndex++) {

            final var row = board[rowIndex];
            
            for (int colIndex = 0; colIndex < row.length; colIndex++) {

                final var boxCol = colIndex / boxSize;
                final var boxRow = rowIndex / boxSize;
                final var boxIndex = boxRow * boxSize + boxCol;
                
                final var value = row[colIndex];
                if (value == '.') {
                    continue;
                }
                
                var charInfo = seen.get(value);
                
                if (charInfo == null) {
                    final var newCharInfo = new CharInfo();

                    newCharInfo.seenAtRow.add(rowIndex);
                    newCharInfo.seenAtCol.add(colIndex);
                    newCharInfo.seenAtBox.add(boxIndex);
                    
                    seen.put(value, newCharInfo);
                    continue;
                }

                if (!charInfo.seenAtRow.add(rowIndex) || 
                    !charInfo.seenAtCol.add(colIndex) || 
                    !charInfo.seenAtBox.add(boxIndex)) {
                    return false;
                }
            }
        }

        return true;
    }
}