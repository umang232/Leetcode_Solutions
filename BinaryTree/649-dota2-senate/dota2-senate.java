class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i) == 'R'){
                rQueue.add(i);
            }else{
                dQueue.add(i);
            }
        }

        while(!rQueue.isEmpty() && !dQueue.isEmpty()){
            int rIndex = rQueue.poll();
            int dIndex = dQueue.poll();
            if(rIndex < dIndex){
                rQueue.add(rIndex + senate.length());
            }else{
                dQueue.add(dIndex + senate.length());
            }
        }

        return rQueue.isEmpty() ? "Dire":"Radiant";
    }
}