class Solution {
    public int getCommon(int[] nums1, int[] nums2) {

        Integer prevValue = null;

        for (int i = 0; i < nums1.length; i++) {

            final var currentValue = nums1[i];

            if (prevValue != null && prevValue == currentValue) {
                continue;
            }

            for (int j = 0; j < nums2.length; j++) {

                final var secondValue = nums2[j];

                if (secondValue > currentValue) {
                    break;
                }

                if (currentValue != secondValue) {
                    continue;
                }

                return currentValue;
            }
        }

        return -1;
    }
}