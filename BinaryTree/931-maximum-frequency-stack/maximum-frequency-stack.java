class FreqStack {
    HashMap<Integer,Stack<Integer>> hm;
    HashMap<Integer,Integer> freq;
    int maxFreq = 0;
    public FreqStack() {
        hm = new HashMap<>();
        freq = new HashMap<>();
    }
    public void push(int val) {
        freq.put(val,freq.getOrDefault(val,0)+1);
        int freqV = freq.get(val);
        maxFreq = Math.max(maxFreq,freqV);
        if(hm.containsKey(freqV)){
            hm.get(freqV).push(val);
        }else{
            hm.put(freqV, new Stack<>());
            hm.get(freqV).push(val);
        }
    }
    public int pop() {
        int val = hm.get(maxFreq).peek();
        hm.get(maxFreq).pop();
        freq.put(val,freq.get(val)-1);
        if(hm.get(maxFreq).isEmpty()){
            maxFreq--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */