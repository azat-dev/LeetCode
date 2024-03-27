class Solution {
    public boolean isHappy(int n) {
        
        var seen = new HashSet<Integer>();
        
        while (true) {
            
            if (seen.contains(n)) {
                return false;
            }
            
            seen.add(n);
            
            int sum = 0;
            
            while (n > 0) {
                final var digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            
            if (sum == 1) {
                return true;
            }
            
            n = sum;
        }
    }
}