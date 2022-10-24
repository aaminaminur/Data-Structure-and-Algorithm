class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        d = {}
        for i in range(len(nums)):
            num = nums[i]
            com = target-num
            if com in d:
                return [d.get(com), i]
            d[num] = i
        return None