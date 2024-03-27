class Solution {

    // O(n) + O(m)
    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1.length < nums2.length) {
            final var temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        final var values2 = new HashSet<Integer>();

        // O(m)
        for (int i = 0; i < nums2.length; i++) {
            values2.add(nums2[i]);
        }

        final var intersectedValues = new HashSet<Integer>();

        // O(n)
        for (int i = 0; i < nums1.length; i++) {

            final var currentValue = nums1[i];
            
            if (!values2.contains(currentValue)) {
                continue;
            }

            intersectedValues.add(currentValue);
        }

        final var result = new int[intersectedValues.size()];
        int i = 0;

        for (Integer value : intersectedValues) {
            result[i] = value;
            i++;
        }

        return result;
    }
}