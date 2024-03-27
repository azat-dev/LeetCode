import java.util.ArrayList;

class Solution {
    public List<String> fizzBuzz(int n) {
        var result = new ArrayList<String>();

        for (int i = 1; i <= n; i++) {

            String value;

            if (i % 3 == 0 && i % 5 == 0) {
                value = "FizzBuzz";
            } else if (i % 3 == 0) {
                value = "Fizz";
            } else if (i % 5 == 0) {
                value = "Buzz";
            } else {
                value = Integer.toString(i);
            }

            result.add(value);
        }

        return result;
    }
}