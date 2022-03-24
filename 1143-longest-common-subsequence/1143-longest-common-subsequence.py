class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        l1 = len(text1)
        l2 = len(text2)
                
        dp = [[0 for i in range(l2+1)] for j in range(l1+1)]
        
        for i in range(l1-1, -1, -1):
            for j in range(l2-1, -1, -1):
                c1 = text1[i]
                c2 = text2[j]
                               
                if c1 == c2:
                    dp[i][j] = 1 + dp[i+1][j+1]
                
                else:
                    dp[i][j] = max(dp[i+1][j], dp[i][j+1])
                
        return dp[0][0]