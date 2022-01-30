class Solution {
    public boolean isValid(String s) {
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == ')'){
                if(st.isEmpty()) return false;
                
                if(s.charAt(st.peek()) == '(') {
                    st.pop();
                }
                else{
                    return false;
                }
            }
            else if(ch == '}'){
                if(st.isEmpty()) return false;
                
                if(s.charAt(st.peek()) == '{') {
                    st.pop();
                }
                else{
                    return false;    
                }
            }
            else if(ch == ']'){
                if(st.isEmpty()) return false;
                
                if(s.charAt(st.peek()) == '[') {
                    st.pop();
                }
                else{
                    return false;
                }
            }
            else{
                st.push(i);
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }
}