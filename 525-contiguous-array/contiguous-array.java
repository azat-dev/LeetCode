class Solution {
    public int findMaxLength(int[] nums) {
        int ans = 0;
        int prefixSum = 0;
        Map<Integer, Integer> prefixToIndex = new HashMap<>();

        prefixToIndex.put(0, -1);

        for (int i = 0; i < nums.length; ++i) {

            prefixSum += nums[i] == 1 ? 1 : -1;

            if (prefixToIndex.containsKey(prefixSum)) {
                ans = Math.max(ans, i - prefixToIndex.get(prefixSum));
                continue;
            }

            prefixToIndex.put(prefixSum, i);
        }

        return ans;
    }
}