class Solution {

    public int maxProduct(int[] nums) {
        
        var a = -1;
        var b = -1;

        for (final var value : nums) {

            if (value < a && value < b) {
                continue;
            }

            if (b > a) {
                a = b;
            }

            b = value;
        }

        return (a - 1) * (b - 1);
    }
}