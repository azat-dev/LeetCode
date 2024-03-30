class Solution {

    public int maxProduct(int[] nums) {
        
        final var minHeap = new PriorityQueue<Integer>(2);
        var size = 0;

        for (final var value : nums) {

            minHeap.add(value);
            size++;

            if (size > 2) {
                minHeap.poll();
                size--;
            }
        }

        return (minHeap.poll() - 1) * (minHeap.peek() - 1);
    }
}