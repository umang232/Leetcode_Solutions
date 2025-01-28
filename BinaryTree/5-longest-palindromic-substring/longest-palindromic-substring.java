class Solution {
    public String longestPalindrome(String s) {
        String maxS = "";
        int maxLeng = 0;
        for(int i=0;i<s.length();i++){
            int l = i;
            int r = i;
            while(l>=0 && r<s.length()){
                if(s.charAt(l) == s.charAt(r)){
                    int len = r-l+1;
                    if(len > maxLeng){
                        maxLeng = len;
                        maxS = s.substring(l,r+1);
                    }
                    l--;
                    r++;
                }else{
                    break;
                }
            }
            l = i;
            r = i+1;
            while(l>=0 && r <s.length()){
                if(s.charAt(l) == s.charAt(r)){
                    int len = r-l+1;
                    if(len > maxLeng){
                        maxLeng = len;
                        maxS = s.substring(l,r+1);
                    }
                    l--;
                    r++;
                }else{
                    break;
                }
            }
        }
        return maxS;
    }
}