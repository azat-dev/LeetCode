class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        jewels_set = { ch for ch in jewels }
        count = 0
        for ch in stones:
            if ch in jewels_set:
                count += 1
        
        return count
                