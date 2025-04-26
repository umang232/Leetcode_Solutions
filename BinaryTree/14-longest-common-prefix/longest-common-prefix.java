class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder(strs[0]);
        for(int i=1;i<strs.length;i++){
            StringBuilder temp = new StringBuilder();
            for(int j =0 ; j < ans.length() && j<strs[i].length();j++){
                if(strs[i].charAt(j) == ans.charAt(j)){
                    temp.append(ans.charAt(j));
                }else{
                    break;
                }
            }
            ans = temp;
            if(ans.toString() == ""){
                return ans.toString();
            }
        }
        return ans.toString();
    }
}