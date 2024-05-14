import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
class Solution {
    Stack<Character> st = new Stack<>();
    ArrayList<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        gen(0,0,n);
        return ans;
    }
    public void gen(int s,int e,int n){
        if(s == e && e == n){
            Iterator it = st.iterator();
            String temp = "";
            while(it.hasNext()){
                temp = temp + it.next();
            }
            ans.add(temp);
        }
        if(s < n){
            st.push('(');
            gen(s+1,e,n);
            st.pop();
        }
        if(e<s){
            st.push(')');
            gen(s,e+1,n);
            st.pop();
        }
    }
}