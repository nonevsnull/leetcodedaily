from typing import List

class Solution1:
    def singleNumber(self, nums: List[int]) -> int:
        i = 0
        nums.sort()
        while(i <= len(nums) - 2):
            if i >= 0 and nums[i] != nums[i + 1]:
                return nums[i]
            i += 2
        return nums[i]
 
class Solution2:
    def singleNumber(self, nums: List[int]) -> int:
        myset = set()
        for i in nums:
            if i in myset:
                myset.discard(i)
            else:
                myset.add(i)
        return myset.pop()

# This is the best solution. 
# This is also the key point of this problem. 
# TIL: a ^ b = c, so c contains the information of both a and b
# This is bc ^, XOR is reversible
class Solution3:
    def singleNumber(self, nums: List[int]) -> int:
        n = 0
        for i in nums:
            n ^= i
        return n

# s = Solution1()
# print(s.singleNumber([1,0,1]))

# s = Solution2()
# print(s.singleNumber([1,1,1,1,2]))

s = Solution3()
print(s.singleNumber([1,1,1,1,2]))