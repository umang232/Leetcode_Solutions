class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int prevTime = 0;
        for(String log : logs){
            String[] s = log.split(":");
            int id = Integer.parseInt(s[0]);
            String type = s[1];
            int time = Integer.parseInt(s[2]);
            if(type.equals("start")){
                if(!st.isEmpty()){
                    result[st.peek()] += (time-prevTime);
                }
                st.push(id);
                prevTime = time;
            }else{
                result[st.pop()] += (time-prevTime + 1);
                prevTime = time + 1;
            }

        }
        return result;
    }
}