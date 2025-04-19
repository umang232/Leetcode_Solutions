class Solution {
    List<String> result = new ArrayList<>();
    Stack<Character> st = new Stack<>();
    public List<String> generateParenthesis(int n) {
       gen(0,0,n);
       return result; 
    }

    public void gen(int start, int end, int n){
        if(start == end && end == n){
            Iterator it = st.iterator();
            String temp = "";
            while(it.hasNext()){
                temp+=it.next();
            }
            result.add(temp);
        }
        if(start < n){
            st.push('(');
            gen(start+1,end,n);
            st.pop();
        }
        if(end < start){
            st.push(')');
            gen(start,end+1,n);
            st.pop();
        }
    }
}