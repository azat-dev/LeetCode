class Solution {

    // O(n * m)
    public int[] intersection(int[] nums1, int[] nums2) {

        var intersectedValues = new HashSet<Integer>();

        // O(n)
        for (int i = 0; i < nums1.length; i++) {

            final var currentValue = nums1[i];
            
            if (intersectedValues.contains(currentValue)) {
                continue;
            }

            // O(m)
            for (int j = 0; j < nums2.length; j++) {
                final var value = nums2[j];

                if (value == currentValue) {
                    intersectedValues.add(currentValue);
                }
            }
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