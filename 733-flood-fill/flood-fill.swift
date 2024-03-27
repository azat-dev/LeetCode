class Solution {

    struct MatrixPosition: Equatable, Hashable {
        let row: Int
        let col: Int
    }

    func floodFill(_ image: [[Int]], _ sr: Int, _ sc: Int, _ color: Int) -> [[Int]] {
        
        var outputImage = image
        let directions = [(row: -1, col: 0), (row: 1, col: 0), (row: 0, col: -1), (row: 0, col: 1)]

        var seen = Set<MatrixPosition>()

        var queue = [MatrixPosition]()
        queue.append(.init(row: sr, col: sc))

        let valueToReplace = image[sr][sc]

        while !queue.isEmpty {

            let position = queue.removeFirst()
            if seen.contains(position) {
                continue
            }
            
            seen.insert(position)

            let value = outputImage[position.row][position.col]

            if value != valueToReplace {
                continue
            }

            outputImage[position.row][position.col] = color
            
            for direction in directions {

                print(direction.row)
                let nextPosition = MatrixPosition(
                    row: position.row + direction.row,
                    col: position.col + direction.col
                )

                guard 
                    nextPosition.row >= 0,
                    nextPosition.col >= 0,
                    nextPosition.row < outputImage.count,
                    nextPosition.col < outputImage[nextPosition.row].count,
                    !seen.contains(nextPosition)
                else {
                    continue
                }

                queue.append(nextPosition)
            }
        }

        return outputImage
    }
}