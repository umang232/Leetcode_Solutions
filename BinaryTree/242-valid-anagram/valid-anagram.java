class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int alp[] = new int[26];
        for(int i=0;i<s.length();i++){
            alp[s.charAt(i) - 'a'] +=1;
        }
        for(int i=0;i<t.length();i++){
            alp[t.charAt(i) - 'a'] -= 1;
        }
        for(int i=0;i<alp.length;i++){
            if(alp[i] != 0){
                return false;
            }
        }
        return true;
    }
}