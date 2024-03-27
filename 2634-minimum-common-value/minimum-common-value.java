import java.util.Arrays;

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {

        Integer prevValue = null;

        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {

            final var currentValue = nums1[i];

            if (prevValue != null && prevValue == currentValue) {
                i++;
                continue;
            }

            final var secondValue = nums2[j];

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