class Solution {
    public int[] findArray(int[] pref) {
        
        final var result = new int[pref.length];
        var prev = -1;

        for (int i = 0; i < pref.length; i++) {
            
            final var currentValue = pref[i];
            final var calculatedValue = i == 0 ? currentValue : prev ^ currentValue;

            result[i] = calculatedValue;
            prev = i == 0 ? calculatedValue : prev ^ calculatedValue;
        }

        return result;
    }
}