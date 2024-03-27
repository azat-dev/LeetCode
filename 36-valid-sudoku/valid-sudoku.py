RowIndex = int
ColIndex = int
BoxIndex = int

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        seen_row: Dict[char, List[bool]] = {}
        seen_col: Dict[char, List[bool]] = {}
        seen_box: Dict[char, List[bool]] = {}
        
        board_size = len(board)
        
        for row in range(board_size):
            box_row = row // 3
            row_items = board[row]
            
            for col in range(board_size):
                box_col = col // 3
                box = box_row * board_size + box_col
                
                value = row_items[col]
                
                if value == '.':
                    continue
                
                seen_ch_in_row = seen_row.get(value) or [False for _ in range(board_size)]
                if seen_ch_in_row[row]:
                    return False
                
                seen_ch_in_col = seen_col.get(value) or [False for _ in range(board_size)]
                if seen_ch_in_col[col]:
                    return False
                
                seen_ch_in_box = seen_box.get(value) or [False for _ in range(board_size * board_size)]
                if seen_ch_in_box[box]:
                    return False
                
                seen_ch_in_row[row] = True
                seen_row[value] = seen_ch_in_row
                
                seen_ch_in_col[col] = True
                seen_col[value] = seen_ch_in_col
                
                seen_ch_in_box[box] = True
                seen_box[value] = seen_ch_in_box
        
        return True
        