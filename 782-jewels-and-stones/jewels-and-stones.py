class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        jewels_set = { ch for ch in jewels }
        count = 0
        for ch in jewels_set:
            count += stones.count(ch)
        
        return count
                