class Solution:
    def reverse_number(x: int) -> int:
        temp = abs(x)
        result = 0

        while temp != 0:

            last_digit = temp % 10
            result = result * 10 + last_digit
            temp = temp // 10

        return result
    
    def isPalindrome(self, x: int) -> bool:
        return x >= 0 and x == Solution.reverse_number(x)