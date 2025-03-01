class StockSpanner {
    Stack<Integer> st;
    List<Integer> l;
    int i = 0;
    public StockSpanner() {
        st = new Stack<Integer>();
        l = new ArrayList<>();
    }
    
    public int next(int price) {
        if(st.isEmpty()){
            st.push(i);
            l.add(price);
            i++;
            return 1;
        }
        else{
            if(!st.isEmpty() && l.get(st.peek()) > price){
                st.push(i);
                l.add(price);
                i++;
                return 1;
            }else{
                while(!st.isEmpty() && l.get(st.peek())<= price){
                    st.pop();
                }
                l.add(price);
                int ret = 0;
                if(!st.isEmpty()){
                    ret = i - st.peek();
                }else{
                    ret = i+1;
                }
                st.push(i);
                i++;
                return ret;
            }
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */