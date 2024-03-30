class Solution:
    def reverseWords(self, s: str) -> str:
        
        result = ""
        start = -1

        for i in range(len(s) - 1, -1, -1):
            
            is_space = s[i] == " "

            if start != -1:
                if is_space:
                    if result != "":
                        result += " "
                    result += s[i + 1: start + 1]
                    start = -1
            else:
                if not is_space:
                    start = i
        
        if start != -1:
            if result != "":
                result += " "
            result += s[:start + 1]

        return result
