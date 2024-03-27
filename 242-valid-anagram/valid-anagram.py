import functools

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        available_characters = {}

        for character in s:
            available_characters[character] = available_characters.get(character, 0) + 1

        for character in t:
            number_of_characters = available_characters.get(character, 0)

            if number_of_characters == 0:
                return False

            number_of_characters -= 1
            available_characters[character] = number_of_characters

            if number_of_characters == 0:
                del available_characters[character]

        return len(available_characters) == 0