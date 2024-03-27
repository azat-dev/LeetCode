import java.util.stream.IntStream;

class Solution {
    public List<String> fizzBuzz(int n) {

        return IntStream.rangeClosed(1, n)
                .mapToObj((i) -> {
                    if (i % 3 == 0 && i % 5 == 0) {
                        return "FizzBuzz";
                    }

                    if (i % 3 == 0) {
                        return "Fizz";
                    }

                    if (i % 5 == 0) {
                        return "Buzz";
                    }

                    return Integer.toString(i);
                    
                }).collect(Collectors.toList());
    }
}