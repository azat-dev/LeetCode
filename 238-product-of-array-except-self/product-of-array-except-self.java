class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        final var result = new int[nums.length];

        var prevValue = 1;
        var prevProduct = 1;

        for (int i = 0; i < nums.length; i++) {

            final var value = nums[i];
            result[i] = prevProduct * prevValue;

            prevValue = value;
            prevProduct = result[i];
        }

        prevProduct = 1;

        for (int i = nums.length - 1; i >= 0; i--) {

            final var value = nums[i];
            result[i] *= prevProduct;
            prevProduct *= value;
        }

        return result;
    }
}