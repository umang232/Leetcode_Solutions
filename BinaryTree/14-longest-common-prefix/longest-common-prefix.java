class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = strs[0];
        for(int i=1;i<strs.length;i++){
            String temp = "";
            for(int j =0 ; j < ans.length() && j<strs[i].length();j++){
                if(strs[i].charAt(j) == ans.charAt(j)){
                    temp+=ans.charAt(j);
                }else{
                    break;
                }
            }
            ans = temp;
            if(ans == ""){
                return ans;
            }
        }
        return ans;
    }
}