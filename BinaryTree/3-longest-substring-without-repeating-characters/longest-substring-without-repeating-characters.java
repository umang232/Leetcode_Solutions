class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int left = 0;
        int maxi = 0;
        for(int r=0;r<s.length();r++){
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                maxi = Math.max(maxi,r-left+1);
            }else{
                while(s.charAt(left)!= s.charAt(r)){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.remove(s.charAt(left));
                left++;
                set.add(s.charAt(r));
            }
            System.out.println(maxi);
        }
        return maxi;
    }
}