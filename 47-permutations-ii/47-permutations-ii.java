class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    
    public void permuteUtil(int[] nums, HashMap<Integer, Integer> freq, List<Integer> ans, int idx){
        if(idx == nums.length){
            res.add(new ArrayList(ans));
            return;
        }
        
        for(int key: freq.keySet()){
            int val = freq.get(key);
            if(val>0){
                freq.put(key, val-1);

                ans.add(key);
                permuteUtil(nums, freq, ans, idx+1);

                ans.remove(ans.size()-1);
                freq.put(key, val);
            }
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        
        permuteUtil(nums, freq, ans, 0);
        
        return res;
    }
}