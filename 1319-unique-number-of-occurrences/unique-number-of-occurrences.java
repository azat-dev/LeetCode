class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        final var freqByValues = new HashMap<Integer, Integer>(1000 * 2 + 1);

        for (final var value : arr) {

            final var prevFreq = freqByValues.getOrDefault(value, 0);
            freqByValues.put(value, prevFreq + 1);
        }

        final var seenFreq = new HashSet<Integer>();

        for (final var freq : freqByValues.values()) {
            if (!seenFreq.add(freq)) {
                return false;
            }
        }

        return true;
    }
}