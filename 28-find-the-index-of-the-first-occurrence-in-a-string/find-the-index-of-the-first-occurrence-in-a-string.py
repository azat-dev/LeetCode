class Solution:
    def hasSubstring(self, substring: str, text: str, startFrom: int) -> bool:
        
        index = startFrom

        for character in substring:
            if character != text[index]:
                return False

            index += 1

        return True

    def strStr(self, haystack: str, needle: str) -> int:
        
        number_of_characters_in_haystack = len(haystack)

        for haystack_index in range(number_of_characters_in_haystack):

            number_of_left_characters = number_of_characters_in_haystack - haystack_index
            
            if  number_of_left_characters < len(needle):
                return -1

            if self.hasSubstring(needle, haystack, haystack_index):
                return haystack_index

        return -1
        
