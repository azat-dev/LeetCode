class Solution {
    private int parse(String target) {
        var result = 0;

        for (int i = 0; i < target.length(); i++) {
            final int val = target.charAt(i) - '0';
            result = result * 10 + val;
        }
        return result;
    }

    private int rotate(int value, int wheel, int sign) {
        final int offset = (int) Math.pow(10, wheel);
        final int digit = value / offset % 10;
        var nextDigit = digit + sign;
        if (nextDigit > 9) {
            nextDigit = 0;
        } else if (nextDigit < 0) {
            nextDigit = 9;
        }

        return value - digit * offset + nextDigit * offset;
    }

    public int openLock(String[] deadends, String target) {
        
        final var targetValue = parse(target);
        if (targetValue == 0) {
            return 0;
        }

        final var queue = new LinkedList<Integer>();
        final var seen = new HashSet<Integer>();
        
        queue.add(0);

        for (final var deadend: deadends) {
            seen.add(parse(deadend));
        }

        if (!seen.add(0)) {
            // is deadend
            return -1;
        }

        var numberOfCurrentLevelItems = 1;
        var edges = 1;

        while (numberOfCurrentLevelItems > 0) {

            var nextLevelNumberOfItems = 0;

            for(;numberOfCurrentLevelItems > 0; numberOfCurrentLevelItems--) {

                final var currentValue = queue.poll();

                for (int position = 0; position < 4; position++) {
                    for (int sign = -1; sign <= 1; sign += 2) {
                    
                        final var nextValue = rotate(currentValue, position, sign);
                        final var isValueSeen = !seen.add(nextValue);
                        if (isValueSeen) {
                            continue;
                        }

                        if (nextValue == targetValue) {
                            return edges;
                        }
                        
                        queue.offer(nextValue);
                        nextLevelNumberOfItems++;
                    }
                }
            }

            edges++;
            numberOfCurrentLevelItems = nextLevelNumberOfItems;
        }

        return -1;
    }
}