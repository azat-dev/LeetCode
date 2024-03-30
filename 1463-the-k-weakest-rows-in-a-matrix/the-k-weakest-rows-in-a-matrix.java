class Solution {

    private record Row(int numberOfSoldiers, int index) {}

    private int getNumberOfSoldiers(int[] row) {

        for (int i = 0; i < row.length; i++) {

            if (row[i] != 1) {
                return i;
            }
        }

        return row.length;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        
        final var maxHeap = new PriorityQueue<Row>(
            (a, b) -> {
                if (a.numberOfSoldiers == b.numberOfSoldiers) {
                    return b.index - a.index;
                }

                return b.numberOfSoldiers - a.numberOfSoldiers;
            }
        );

        int size = 0;

        for (int index = 0; index < mat.length; index++) {

            final var numberOfSoldiers = getNumberOfSoldiers(mat[index]);

            maxHeap.add(
                new Row(numberOfSoldiers, index)
            );
            size++;

            if (size > k) {
                maxHeap.poll();
                size--;
            }
        }

        final var result = new int[size];

        for(int i = size - 1; !maxHeap.isEmpty(); i--) {

            final var row = maxHeap.poll();
            result[i] = row.index;
        }

        return result;
    }
}