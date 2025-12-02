# 3190. Find Minimum Operations to Make All Elements Divisible by Three
class Solution:
    def minimumOperations(self, nums: List[int]) -> int:
        operations = 0
        for num in nums:
            remainder = num % 3
            operations += min(remainder, 3 - remainder)
        return operations