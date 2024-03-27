class Solution {

    // O(n) + O(m)
    public int[] intersection(int[] nums1, int[] nums2) {

        if (nums1.length < nums2.length) {
            final var temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        final var values2 = new HashSet<Integer>(nums2.length);

        // O(m)
        for (int value2 : nums2) {
            values2.add(value2);
        }

        final var intersectedValues = new HashSet<Integer>(nums1.length);

        // O(n)
        for (int value1 : nums1) {
            
            if (!values2.contains(value1)) {
                continue;
            }

            intersectedValues.add(value1);
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