import java.util.Arrays;

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {

        final var lastValueNums1 = nums1[nums1.length - 1];
        final var lastValueNums2 = nums2[nums2.length - 1];

        Integer prevValue = null;

        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {

            final var currentValue = nums1[i];

            if (currentValue > lastValueNums2) {
                return -1;
            }

            if (prevValue != null && prevValue == currentValue) {
                i++;
                continue;
            }

            final var secondValue = nums2[j];

            if (secondValue > lastValueNums1) {
                return -1;
            }

            if (secondValue < currentValue) {
                j++;
                continue;
            }

            if (secondValue == currentValue) {
                return currentValue;
            }

            prevValue = currentValue;
            i++;
        }

        return -1;
    }
}