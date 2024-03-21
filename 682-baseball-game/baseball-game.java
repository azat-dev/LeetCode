class Solution {
    public int calPoints(String[] operations) {
        final var stack = new LinkedList<Integer>();

        for(var operation : operations) {

            switch (operation) {
                case "+":
                    final var val1 = stack.peek();
                    final var val2 = stack.get(1);

                    final var result = val1 + val2;
                    stack.push(result);
                    break;

                case "C":
                    stack.pop();
                    break;

                case "D":
                    stack.push(stack.peek() * 2);
                    break;

                default:
                    int value = Integer.valueOf(operation);
                    stack.push(value);
                    break;
            }
        }

        int sum = 0;

        for (var value : stack) {
            sum += value;
        }

        return sum;
    }
}