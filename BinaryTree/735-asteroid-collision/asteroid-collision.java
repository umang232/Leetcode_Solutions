class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int a: asteroids){
            boolean alive = true;
            while(alive && a < 0 && !st.isEmpty() && st.peek() > 0){
                int top = st.peek();
                if(top > -a){
                    alive = false;
                }else if(top == -a){
                    st.pop();
                    alive = false;
                }else{
                    st.pop();
                }
            }
            if(alive){
                st.push(a);
            }
        }
        int result[] = new int[st.size()];
        for(int i= result.length-1;i>=0;i--){
            result[i] = st.pop();
        }
        return result;
    }
}