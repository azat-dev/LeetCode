RowIndex = int
ColIndex = int
BoxIndex = int

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        seen_row: Dict[char, Set[RowIndex]] = {}
        seen_col: Dict[char, Set[ColIndex]] = {}
        seen_box: Dict[char, Set[BoxIndex]] = {}
        
        board_size = len(board)
        
        for row in range(board_size):
            for col in range(board_size):
                box_row = row // 3
                box_col = col // 3
                box = box_row * 9 + box_col
                
                value = board[row][col]
                
                if value == '.':
                    continue
                
                seen_ch_in_row = seen_row.get(value) or set()
                if row in seen_ch_in_row:
                    return False
                
                seen_ch_in_col = seen_col.get(value) or set()
                if col in seen_ch_in_col:
                    return False
                
                seen_ch_in_box = seen_box.get(value) or set()
                if box in seen_ch_in_box:
                    return False
                
                seen_ch_in_row.add(row)
                seen_row[value] = seen_ch_in_row
                
                seen_ch_in_col.add(col)
                seen_col[value] = seen_ch_in_col
                
                seen_ch_in_box.add(box)
                seen_box[value] = seen_ch_in_box
        
        return True
        