class Pair{
    int timestamp;
    String val;
    Pair(int timestamp,String val){
        this.timestamp = timestamp;
        this.val = val;
    }
}

class TimeMap {
    private HashMap<String, ArrayList<Pair>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(hm.containsKey(key)){
            hm.get(key).add(new Pair(timestamp,value));
        }else{
            ArrayList<Pair> arr = new ArrayList<>();
            arr.add(new Pair(timestamp,value));
            hm.put(key,arr);
        }
    }
    
    public String get(String key, int timestamp) {
        String ret = "";
        if(hm.containsKey(key)){
            ArrayList<Pair> arr = hm.get(key);
            int l = 0;
            int h = arr.size() -1;
            while(l <= h){
                int mid = (l+h)/2;
                int timeVal= arr.get(mid).timestamp;
                if(timestamp == timeVal){
                    return arr.get(mid).val;
                }else if (timeVal < timestamp){
                    ret = arr.get(l).val;
                    l = mid+1;
                }else{
                    h = mid-1;
                }

            }
        }
        return ret;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */