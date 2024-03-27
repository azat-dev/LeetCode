class Solution {

    private int getNumberOfZeroPermutations(int n) {
        return n * (n + 1) / 2;

        // 1
        // 12
        // 2
        // 123
        // 23
        // 3
        // 1234
        // 234
        // 34
        // 4
        // 12345
        // 2345
        // 345
        // 45
        // 5
    }

    private int numSubarraysWithZeroSum(int[] nums ) {
    
        int zeroSequenceLength = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            
            final var value = nums[i];

            if (value == 0) {
                zeroSequenceLength++;
                continue;
            }

            count += getNumberOfZeroPermutations(zeroSequenceLength);
            zeroSequenceLength = 0;
        }

        if (zeroSequenceLength > 0) {
            count += getNumberOfZeroPermutations(zeroSequenceLength);
        }

        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {

        if (goal == 0) {
            return numSubarraysWithZeroSum(nums);
        }

        int i = 0;
        int count = 0;
        
        while (i < nums.length) {
            
            var isSequence = false;
            int numberOfZerosBefore = 0;
            int numberOfZerosAfter = 0;
            
            // Skip zeros
            for (; i < nums.length; i++) {
                if (nums[i] == 1) {
                    break;
                }

                numberOfZerosBefore++;
            }

            int sum = 0;
            final var startOfSequence = i;

            // Calc sum
            for (; i < nums.length && sum < goal; i++) {
                if (nums[i] == 0) {
                    continue;
                }

                sum += nums[i];
            }

            if (sum < goal) {
                i = startOfSequence + 1;
                continue;
            }

            // Skip zeros after
            for (; i < nums.length; i++) {
                if (nums[i] == 1) {
                    break;
                }

                numberOfZerosAfter++;
            }

            count += 1;
            count += numberOfZerosBefore;
            count += numberOfZerosAfter;
            count += numberOfZerosBefore * numberOfZerosAfter;
            i = startOfSequence + 1;
        }

        return count;
    }
}