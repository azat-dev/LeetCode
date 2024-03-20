class Solution:
    def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
        number_of_rows = len(mat)
        source_number_of_cols = len(mat[0])

        size1 = number_of_rows * source_number_of_cols
        size2 = r * c

        if size1 != size2 or number_of_rows == r and source_number_of_cols == c:
            return mat

        def map_position_to_source(target_row_index: int, target_col_index: int) -> Tuple[int, int]:
            item_index = target_row_index * c + target_col_index
            return (
                item_index // source_number_of_cols,
                item_index % source_number_of_cols
            )

        def get_row(target_row: int):
            row_items = []

            for target_col in range(c):
                (source_row, source_col) = map_position_to_source(target_row, target_col)
                row_items.append(mat[source_row][source_col])
            
            return row_items

        return [get_row(row) for row in range(r)]