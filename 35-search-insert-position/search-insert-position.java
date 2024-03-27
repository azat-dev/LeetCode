class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        int middle = (right + left) / 2;

        while (left <= right) {

            final var middleValue = nums[middle];

            if (middleValue == target) {
                return middle;
            }

            if (left == right) {
                System.out.println(left);
                return middleValue < target ? middle + 1 : middle;
            }

            if (middleValue < target) {
                
                final var nextLeft = middle + 1;
                left = nextLeft > right ? right : nextLeft;
                
            } else {
                final var nextRight = middle - 1;
                right = nextRight < left ? left : nextRight;
            }

            middle = (right + left) / 2;
        }

        if (left >= nums.length) {
            return nums.length;
        }

        return 0;
    }
}