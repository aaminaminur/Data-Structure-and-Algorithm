#User function Template for python3

class Solution:
    ##Complete this function
    #Function to find the sum of contiguous subarray with maximum sum.
    def maxSubArraySum(self,arr,N):
        ##Your code here
        max_so_far = -10**10
        max_ending_here = 0
        
        for num in arr:
            max_ending_here = max_ending_here + num
            
            if max_so_far < max_ending_here:
                max_so_far = max_ending_here
                
            if max_ending_here < 0:
                max_ending_here = 0
                
        return max_so_far

#{ 
#  Driver Code Starts
#Initial Template for Python 3

import math

 
def main():
        T=int(input())
        while(T>0):
            
            n=int(input())
            
            arr=[int(x) for x in input().strip().split()]
            
            ob=Solution()
            
            print(ob.maxSubArraySum(arr,n))
            
            T-=1


if __name__ == "__main__":
    main()
# } Driver Code Ends