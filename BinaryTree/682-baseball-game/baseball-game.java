class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(String op : operations){
            if(op.equals("C")){
                st.pop();
            }else if(op.equals("+")){
                int first = st.pop();
                int add = first+st.peek();
                st.push(first);
                st.push(add);
            }else if(op.equals("D")){
                st.push(2*st.peek());
            }else{
                st.push(Integer.parseInt(op));
            }
        }
        int sum = 0;
        while(!st.isEmpty()){
            sum+=st.pop();
        }
        return sum;
    }
}