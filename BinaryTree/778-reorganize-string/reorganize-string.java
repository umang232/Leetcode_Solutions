class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char cur = s.charAt(i);
            freqMap.put(cur,freqMap.getOrDefault(cur,0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        StringBuilder res = new StringBuilder();
        while(maxHeap.size() >=2 ){
            char char1 = maxHeap.poll();
            char char2 = maxHeap.poll();
            res.append(char1);
            res.append(char2);
            freqMap.put(char1, freqMap.get(char1) - 1);
            freqMap.put(char2, freqMap.get(char2) - 1);

            if(freqMap.get(char1) > 0) maxHeap.offer(char1);
            if(freqMap.get(char2) > 0) maxHeap.offer(char2);
        }
        if(!maxHeap.isEmpty()){
            char ch = maxHeap.poll();
            if(freqMap.get(ch) > 1) return "";
            res.append(ch);
        }
        return res.toString();
    }
}