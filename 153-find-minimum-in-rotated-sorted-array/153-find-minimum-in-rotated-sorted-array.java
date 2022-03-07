class Solution {
    public int findMin(int[] nums) {       
        if(nums.length == 1 || nums[0] <= nums[nums.length-1]) return nums[0];
        
        int low = 0;
        int high = nums.length - 1;
        
        while(low<=high){
            int mid = low + (high - low) / 2;
            
            if(nums[mid] > nums[mid+1]) return nums[mid+1];
            
            else if(nums[mid] < nums[mid-1]) return nums[mid];
            
            else if(nums[low] <= nums[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return -1;
    }
}