class Solution {

    public int findKthLargest(int[] nums, int k) {
        
        final var queue = new PriorityQueue<Integer>(k);
        var size = 0;

        for (final var value : nums) {

            queue.add(value);
            size++;

            if (size > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }
}