class Solution:
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