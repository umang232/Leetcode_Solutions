class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0){
            return false;
        }
        Arrays.sort(hand);
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i:hand){
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(int i:hand){
            if(hm.containsKey(i)){
                System.out.println(i);
                hm.put(i,hm.get(i)-1);
                if(hm.get(i) == 0){
                    hm.remove(i);
                }
                for(int j=1;j<groupSize;j++){
                    if(!hm.containsKey(i+j)){
                        System.out.println("Her"+hm.get(i+j));
                        return false;
                    }
                    hm.put(i+j,hm.get(i+j)-1);
                    if(hm.get(i+j) == 0){
                        hm.remove(i+j);
                    }
                }
                
                System.out.println(hm.size());
            }
        }
        return true;
    }
}