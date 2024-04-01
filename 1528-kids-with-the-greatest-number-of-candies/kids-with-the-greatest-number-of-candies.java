class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        int maxValue = -1;

        for (final var value : candies) {
            if (maxValue < value) {
                maxValue = value;
            }
        }

        final var result = new ArrayList<Boolean>(candies.length);

        for (final var value : candies) {
            result.add(value + extraCandies >= maxValue);
        }

        return result;
    }
}