class Solution:
    def longestCommonChars(self, str1, str2):
        n = min(len(str1), len(str2))
        count = 0

        for i in range(n):
            if str1[i] != str2[i]:
                return count
            count += 1
        return count

    def longestCommonPrefix(self, strs: List[str]) -> str:

        number_of_strings = len(strs)
        base_string = strs[0]

        for ch_index in range(len(base_string)):
            ch = base_string[ch_index]

            for str_index in range(1, number_of_strings):
                str2 = strs[str_index]

                if ch_index == len(str2) or str2[ch_index] != ch:
                    return base_string[:ch_index]

        return base_string