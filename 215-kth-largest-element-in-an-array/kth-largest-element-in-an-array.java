class Solution {

    public int findKthLargest(int[] nums, int k) {
        
        final var queue = new PriorityQueue<Integer>(k);

        for (var value : nums) {
            
            queue.add(value);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();
    }
}