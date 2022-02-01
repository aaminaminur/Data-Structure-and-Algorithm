class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    
    public void combUtil(int n,  int k, List<Integer> tres, int idx){
        if(idx>n){
            if(tres.size() == k){
                res.add(new ArrayList(tres));
            }
            return; 
        }
        
        tres.add(idx);
        combUtil(n, k, tres, idx+1);
        tres.remove(tres.size() - 1);
        combUtil(n, k, tres, idx+1);
    }
    
    public List<List<Integer>> combine(int n, int k) {
        combUtil(n, k, new ArrayList<>(), 1);
        return res;
    }
}