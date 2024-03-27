class Solution:
    def isPalindrome(self, string: str) -> bool:
        
        # Loop through all characters
        # Check if current character is alphanumeric else move to next character
        # Loop through all characters from last reversed order position in string in reversed order
        # check if  character is alphanumeric else move to next character
        # if two character are not equal return false
        # break inner cycle
        # wait till the end of loop
        # 

        string = string.lower()

        last_reversed_character_index = 0
        number_of_characters = len(string)

        for character in string:

            if not character.isalnum():
                continue

            for index in range(last_reversed_character_index - 1, -number_of_characters, -1):

                character_from_back = string[index]
                last_reversed_character_index = index

                if not character_from_back.isalnum():
                    continue

                if character != character_from_back:
                    return False

                break

        return True
