class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }
        int[] tChar = new int[128];
        int count = t.length();
        int start = 0;
        int end= 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;
        for(char c:t.toCharArray()){
            tChar[c]++;
        }
        char sChar[] = s.toCharArray();
        while(end < sChar.length){
            if(tChar[sChar[end++]]-- > 0){
                count --;
              
            }
            while(count == 0){
                if(end-start < minLen){
                    startIndex = start;
                    minLen = end-start;
                }
                if(tChar[sChar[start++]]++ == 0){
                    count++;
                    
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? new String() :
                new String(sChar, startIndex, minLen);
    }
}