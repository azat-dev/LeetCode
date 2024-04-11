class Solution {
    public boolean isUgly(int n) {

        if (n <= 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }


        final var limitedFactors = new HashSet<Integer>();
        limitedFactors.add(2);
        limitedFactors.add(3);
        limitedFactors.add(5);

        
        while (true) {

            var wasDivided = false;

            for (var factor : limitedFactors) {
                if (n % factor == 0) {
                    n /= factor;
                    wasDivided = true;
                }
            }

            if (!wasDivided) {
                break;
            }
        }

        return n == 1;
    }
}