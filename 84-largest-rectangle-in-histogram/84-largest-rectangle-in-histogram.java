class Solution {
    
    public int[] nsr(int[] arr){
        int[] nsr = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i=arr.length-1; i>=0; i--){
            if(st.size() > 0){
                while(st.size() > 0 && arr[i] <= arr[st.peek()]){
                    st.pop();
                }
            }
            if(st.size()>0) nsr[i] = st.peek();
            else nsr[i] = arr.length;
            st.push(i);
        }
        return nsr;
    }
    
    public int[] nsl(int[] arr){
        int[] nsl = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<arr.length; i++){
            if(st.size() > 0){
                while(st.size() > 0 && arr[i] <= arr[st.peek()]){
                    st.pop();
                }
            }
            if(st.size()>0) nsl[i] = st.peek();
            else nsl[i] = -1;
            st.push(i);
        }
        return nsl;
    }
    
    public int largestRectangleArea(int[] heights) {
        
        if(heights.length == 0) return 0;
        if(heights.length == 1) return heights[0];
        
        int[] nsr = nsr(heights);
        int[] nsl = nsl(heights);

        int ans = 0;
        for(int i=0; i<heights.length; i++){
            int idxDiff = nsr[i] - nsl[i] - 1;
            int area = heights[i] * idxDiff;
            ans = Math.max(ans, area);
        }
        return ans;
    }
}