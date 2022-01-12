class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        dp = [[False for i in range(n)] for j in range(n)]
        max_len = 0
        left = 0
        right = 0
        for i in range(len(s)):
            dp[i][i] = True
        for d in range(1,n):
            for i in range(n-d):
                j = i + d
                if(d == 1):
                    if(s[i]==s[j]):
                        dp[i][j] = True
                    else:
                        dp[i][j] = False
                else:
                    if(s[i]==s[j] and dp[i+1][j-1]):
                        dp[i][j] = True
                if(dp[i][j] and j-i>max_len):
                    max_len = j-i
                    left = i
                    right = j
        return s[left:right+1]