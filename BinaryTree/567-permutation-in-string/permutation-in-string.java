class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        if(s1.length() > s2.length()){
            return false;
        }
        for(int i=0;i<s1.length();i++){
            arr1[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s1.length();i++){
            arr2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(arr1,arr2)){
            return true;
        }
        for(int j=s1.length();j<s2.length();j++){
            arr2[s2.charAt(j) - 'a']++;
            arr2[s2.charAt(j-s1.length())-'a']--;
            if(Arrays.equals(arr1,arr2)){
                return true;
            }
        }
        return false;
    }
}