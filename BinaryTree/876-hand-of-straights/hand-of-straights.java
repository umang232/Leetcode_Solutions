class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize != 0){
            return false;
        }
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<hand.length;i++){
            hm.put(hand[i],hm.getOrDefault(hand[i],0)+1);
        }
        Arrays.sort(hand);
        for(int i=0;i<hand.length;i++){
            if(hm.containsKey(hand[i])){
                hm.put(hand[i],hm.get(hand[i])-1);
                if(hm.get(hand[i]) == 0){
                    hm.remove(hand[i]);
                }
                int k = 1;
                while(k < groupSize){
                    if(hm.containsKey(hand[i]+k)){
                    hm.put(hand[i]+k,hm.get(hand[i]+k)-1);
                        if(hm.get(hand[i]+k) == 0){
                            hm.remove(hand[i]+k);
                        }
                    }else{
                        return false;
                    }
                    k+=1;
                }
            }
        }
        return hm.isEmpty();
    }
}