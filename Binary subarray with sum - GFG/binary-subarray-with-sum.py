#{ 
 # Driver Code Starts
#Initial Template for Python 3

# } Driver Code Ends
#User function Template for python3

class Solution:
    
    def arrCount(self, arr, N, target):
        count = 0
        summ = 0
        left = 0
        right = 0
        while right<N:
            summ += arr[right]
            while summ > target:
                summ -= arr[left]
                left += 1
            count += right-left+1
            right +=1
        return count
    
    def numberOfSubarrays(self, arr, N, target):
        # Code here
        return self.arrCount(arr, N, target) - self.arrCount(arr, N, target-1)

#{ 
 # Driver Code Starts.
if __name__ == '__main__': 
    t = int(input ())
    for _ in range (t):
        N, target = list(map(int, input().split()))
        arr = list(map(int, input().split()))
        ob = Solution()
        res = ob.numberOfSubarrays(arr, N, target)
        print(res)
# } Driver Code Ends