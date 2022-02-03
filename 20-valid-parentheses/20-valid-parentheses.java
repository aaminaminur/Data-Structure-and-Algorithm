class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == ')' && st.size() > 0){
                if(st.peek() != '('){
                    return false;
                }
                st.pop();
            }
            else if(ch == '}' && st.size() > 0){
                if(st.peek() != '{'){
                    return false;
                }
                st.pop();
            }
            else if(ch == ']' && st.size() > 0){
                if(st.peek() != '['){
                    return false;
                }
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        if(st.size() > 0) return false;
        return true;
    }
}