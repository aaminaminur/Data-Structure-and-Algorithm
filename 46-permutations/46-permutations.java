class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    
    public void putil(int[] nums, int idx, List<Integer> tres, boolean[] vis){
        if(idx == nums.length){
            res.add(new ArrayList(tres));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(vis[i] == false){
                vis[i] = true;
                
                tres.add(nums[i]);
                putil(nums, idx+1, tres, vis);    
                tres.remove(tres.size() - 1);    
                
                vis[i] = false;
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        
        boolean[] vis = new boolean[nums.length];
        
        putil(nums, 0, new ArrayList<>(), vis);
        
        return res;
    }
}